<div class="markdown_views">
                <p>最近在忙着找工作，所以趁热打铁写一份Android最新的面试题，希望可以帮助到大家。一直被问的问题Glide的源码（重点），最好和Picasso比较着说。 <br>
Glide原理(自己看)：<a href="https://www.jianshu.com/p/3d699bf007c7" target="_blank">https://www.jianshu.com/p/3d699bf007c7</a></p>

<p>1.什么是接口？Android中有哪些机制是基于接口编程？ <br>
接口就是一些方法特征的集合，用interface修饰。 <br>
面向接口编程：<a href="http://blog.csdn.net/wangjinyu501/article/details/74355351" target="_blank">http://blog.csdn.net/wangjinyu501/article/details/74355351</a></p>

<p>2.说明Activity和Service的生命周期？ <br>
<img src="http://img.blog.csdn.net/20180228165150646?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI4NjU4ODc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70" alt="Activity的生命周期" title=""> <br>
<img src="http://img.blog.csdn.net/20180228165414128?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI4NjU4ODc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70" alt="service的生命周期" title=""></p>

<p>3.Intent flag有哪些？作用是什么？ <br>
自己看（25种） ：<a href="https://www.jianshu.com/p/08177910b0a2" target="_blank">https://www.jianshu.com/p/08177910b0a2</a></p>

<p>4.Android的多线程模型有哪几种？ <br>
Android提供了四种常用的操作多线程的方式，分别是： <br>
1. Handler+Thread <br>
2. AsyncTask <br>
3. ThreadPoolExecutor <br>
4. IntentService <br>
详细介绍：<a href="https://www.jianshu.com/p/2b634a7c49ec" target="_blank">https://www.jianshu.com/p/2b634a7c49ec</a></p>

<p>5.如何规避oom? <br>
  1.使用更加轻量的数据结构 <br>
  2.避免在Android里面使用Enum <br>
  3.减小Bitmap对象的内存占用 <br>
  4.使用更小的图片 <br>
  5.复用系统自带的资源 <br>
  6.注意在ListView/GridView等出现大量重复子组件的视图里面对ConvertView的复用 <br>
  7.Bitmap对象的复用 <br>
  8.避免在onDraw方法里面执行对象的创建 <br>
  9.避免对象的内存泄露(重点) <br>
  10.考虑使用Application Context而不是Activity Context <br>
  11.注意WebView的泄漏(重点) <br>
  12.资源文件需要选择合适的文件夹进行存放 <br>
  13.谨慎使用static对象(重点) <br>
  14.特别留意单例对象中不合理的持有 <br>
  15.珍惜Services资源 <br>
  16.谨慎使用“抽象”编程 <br>
  17.谨慎使用依赖注入框架 <br>
  18..谨慎使用多进程 <br>
  19.Handler的使用（重点） <br>
  20.强软弱虚引用的应用（重点） <br>
  22.主线程操作UI，子线程操作数据（必填） <br>
  原因地址：<a href="http://blog.csdn.net/ljx19900116/article/details/50037627" target="_blank">http://blog.csdn.net/ljx19900116/article/details/50037627</a></p>

<p>6.数据存储有哪些方式？ <br>
1.sharedpreferences 2.file 3.Sqlite 4.ContentProvide 5.网络存储</p>

<p>7.如何做多设备支持？ <br>
个人理解为屏幕适配，不知道出题者的意图</p>

<p>8.Android的布局方式有哪些？分别是如何实现OnDraw的？ <br>
LinearLayout，RelativeLayout，TableLayout，FrameLayout，AbsoluteLayout，GridLayout </p>

<p>9.ScrollView是否可以和listView混合使用？如何可以，说明混合使用的方式，如果不行，说明原因。 <br>
可以，计算整个ListView的高度，填充数据后重新设置ListView高度，重写onMeasure和onInterceptTouchEvent方法</p>

<p>10.在创建fragment时如何传递初始化参数？ <br>
Fragment初始化一定要提供默认构造函数。不能用构造函数传递参数！不要写带参数的构造函数。在Fragment里添加获取Fragment的newInstance函数，以后获取Fragment就使用这个函数，不要使用构造函数新建Fragment！使用setArgument和getArgument传递参数 <br>
详细地址和注意事项：<a href="http://blog.csdn.net/xiaofei_it/article/details/45675497" target="_blank">http://blog.csdn.net/xiaofei_it/article/details/45675497</a></p>

<p>每篇文章10篇，答案仅做参考，非标准答案，如有疑问，可评论提出。</p>            </div>