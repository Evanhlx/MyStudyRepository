<a href="https://www.zhihu.com/question/36641355?sort=created">Android onTrimMemory方法的一些疑惑？</a>

<div class="RichContent-inner"><span class="RichText CopyrightRichText-richText" itemprop="text"><p>android进程回收主要涉及两个组件：ActivityManagerService（Ams）和lowmemorykiller。</p><p>当手机内存不足时，lowmemorykiller就要开始杀进程了。但是lowmemorykiller呢只知道进程占用的内存大小，不知道进程对用户的重要性。Ams则负责管理android四大组件，当然知道进程的重要性了，所以呢还需要与Ams充分交换意见。</p><p>盗张图（侵删）<br></p><figure><noscript>&amp;lt;img src="https://pic3.zhimg.com/50/4f94687097c56823d6031cbd8f095e7d_hd.jpg" data-rawwidth="686" data-rawheight="348" class="origin_image zh-lightbox-thumb" width="686" data-original="https://pic3.zhimg.com/4f94687097c56823d6031cbd8f095e7d_r.jpg"&amp;gt;</noscript><img src="https://pic3.zhimg.com/80/4f94687097c56823d6031cbd8f095e7d_hd.jpg" data-rawwidth="686" data-rawheight="348" class="origin_image zh-lightbox-thumb lazy" width="686" data-original="https://pic3.zhimg.com/4f94687097c56823d6031cbd8f095e7d_r.jpg" data-actualsrc="https://pic3.zhimg.com/50/4f94687097c56823d6031cbd8f095e7d_hd.jpg"></figure><br>当app状态发生改变时，比如退到后台时，ams会对app的进程计算出一个值，即Oomadj（ams#computeOomAdjLocked），然后把这个值传给linux内核，lowmemorykiller呢就可以拿到这个值了，lowmemorykiller则就有了所有app进程的Oomadj值，即进程对用户的重要程度。当手机内存不足时，lowmemorykiller就有了足够的信息决定干掉哪个进程了。<p></p><p>那，lowmemorykiller决定干掉哪个进程呢？</p><p>这个要根据手机还有多少空闲内存，比如还有16MB空闲内存，如下lowmemorykiller.c</p><div class="highlight"><pre><code class="language-text"><span></span>static short lowmem_adj[6] = {
0,
1,
6,
12,
};
static int lowmem_adj_size = 4;
static int lowmem_minfree[6] = {
3 * 512,	/* 6MB */
2 * 1024,	/* 8MB */
4 * 1024,	/* 16MB */
16 * 1024,	/* 64MB */
};
</code></pre></div><br><p>16MB在lowmem_minfree第三个位置，取lowmem_adj第三个位置即6，ok所有Oomadj大于6的进程就被选中了。而lowmemorykiller不是把这些选中的进程都干掉，而是先干掉oomAdj最大而且占用内存最大的进程。如下lowmemorykiller.c#lowmem_scan：</p><div class="highlight"><pre><code class="language-text"><span></span>for_each_process(tsk) {  
...
oom_score_adj = p-&gt;signal-&gt;oom_score_adj;
if (oom_score_adj &lt; min_score_adj) {
task_unlock(p);
continue;
}
tasksize = get_mm_rss(p-&gt;mm);
task_unlock(p);
if (tasksize &lt;= 0)
continue;
if (selected) {
if (oom_score_adj &lt; selected_oom_score_adj)
continue;
if (oom_score_adj == selected_oom_score_adj &amp;&amp;
tasksize &lt;= selected_tasksize)
continue;
}
selected = p;
selected_tasksize = tasksize;
selected_oom_score_adj = oom_score_adj;
}
</code></pre></div><br><p>总之一句话：进程对用户越不重要（Oomadj值就越大），占用内存越大，进程就越容易被干掉。</p>应对策略：<br>1 ams计算出一个危险的Oomadj值会调用onTrimMemory通知app，此时app应该把不重要的内存释放掉，只要比友商app占用的内存小被lowmemorykiller干掉的概率就小。<br>2 当然我们也可以先把忧伤的app干掉。。。帮用户释放内存（开玩笑啦）<br>3 如果我们的app能预置到手机中，并且manifest设置为persistence（Oomadj=0），或者coreserver则不必担心被lowmemorykiller干掉了。不过还有可能被linux层的oomkiller干掉的。当然这也是某些手机预置一堆app导致越用越慢的一个原因，所以我们尽量把这些预置app卸载掉。</span><!-- react-empty: 632 --></div>