<div class="show-content-free">
            <p>版权声明：本文为博主原创文章，未经博主允许不得转载。<a href="https://www.jianshu.com/p/c70989bd5f29" target="_blank">https://www.jianshu.com/p/c70989bd5f29</a></p>
<p>转载请标明出处：<br>
<a href="https://www.jianshu.com/p/c70989bd5f29" target="_blank">https://www.jianshu.com/p/c70989bd5f29</a><br>
本文出自 <a href="https://www.jianshu.com/u/f408bdadacce" target="_blank">AWeiLoveAndroid的博客</a></p>

<a href="https://github.com/oo1993448102/CommonDevKnowledge">常见Java、Android问题及答案汇总</a><br>
<a href="https://www.jianshu.com/p/fb815eaf628f">互联网大型公司（阿里腾讯百度等）android面试题目(有答案)</a>

<p>临近年关，又到了面试求职高峰期，最近有很多网友都在求大厂面试题。正好我之前电脑里面有这方面的整理，于是就发上来分享给大家。</p>
<p>这些题目是网友去百度、小米、乐视、美团、58、猎豹、360、新浪、搜狐等一线互联网公司面试被问到的题目。熟悉本文中列出的知识点会大大增加通过前两轮技术面试的几率。</p>
<p>网上的都是按照公司划分的，想找具体某一方面的知识点有点不好找，我这里就根据知识点分门别类的整理了一下，想看哪一块可以快速找到，希望可以帮助大家，祝大家求职顺利。</p>
<p><strong>本文同步发布在github上，想要md文件的，有兴趣的可以去github下载下来研究，同时也欢迎网友提交面试题库，欢迎点赞和留言。<br>
<a href="https://link.jianshu.com?t=https%3A%2F%2Fgithub.com%2FAweiLoveAndroid%2FCommonDevKnowledge" target="_blank" rel="nofollow">https://github.com/AweiLoveAndroid/CommonDevKnowledge</a></strong></p>
<hr>
<p><strong>主要分为以下几部分：</strong><br>
（1）java面试题<br>
（2）Android面试题<br>
（3）高端技术面试题<br>
（4）非技术性问题&amp;HR问题汇总</p>
<hr>
<h2>一、java面试题</h2>
<p>熟练掌握java是很关键的，大公司不仅仅要求你会使用几个api，更多的是要你熟悉源码实现原理，甚至要你知道有哪些不足，怎么改进，还有一些java有关的一些算法，设计模式等等。</p>
<h5>（一） java基础面试知识点</h5>
<ul>
<li>java中==和equals和hashCode的区别</li>
<li>int、char、long各占多少字节数</li>
<li>int与integer的区别</li>
<li>探探对java多态的理解</li>
<li>String、StringBuffer、StringBuilder区别</li>
<li>什么是内部类？内部类的作用</li>
<li>抽象类和接口区别</li>
<li>抽象类的意义</li>
<li>抽象类与接口的应用场景</li>
<li>抽象类是否可以没有方法和属性？</li>
<li>接口的意义</li>
<li>泛型中extends和super的区别</li>
<li>父类的静态方法能否被子类重写</li>
<li>进程和线程的区别</li>
<li>final，finally，finalize的区别</li>
<li>序列化的方式</li>
<li>Serializable 和Parcelable 的区别</li>
<li>静态属性和静态方法是否可以被继承？是否可以被重写？以及原因？</li>
<li>静态内部类的设计意图</li>
<li>成员内部类、静态内部类、局部内部类和匿名内部类的理解，以及项目中的应用</li>
<li>谈谈对kotlin的理解</li>
<li>闭包和局部内部类的区别</li>
<li>string 转换成 integer的方式及原理</li>
</ul>
<h5>（二） java深入源码级的面试题（有难度）</h5>
<ul>
<li>哪些情况下的对象会被垃圾回收机制处理掉？</li>
<li>讲一下常见编码方式？</li>
<li>utf-8编码中的中文占几个字节；int型几个字节？</li>
<li>静态代理和动态代理的区别，什么场景使用？</li>
<li>Java的异常体系</li>
<li>谈谈你对解析与分派的认识。</li>
<li>修改对象A的equals方法的签名，那么使用HashMap存放这个对象实例的时候，会调用哪个equals方法？</li>
<li>Java中实现多态的机制是什么？</li>
<li>如何将一个Java对象序列化到文件里？</li>
<li>说说你对Java反射的理解</li>
<li>说说你对Java注解的理解</li>
<li>说说你对依赖注入的理解</li>
<li>说一下泛型原理，并举例说明</li>
<li>Java中String的了解</li>
<li>String为什么要设计成不可变的？</li>
<li>Object类的equal和hashCode方法重写，为什么？</li>
</ul>
<h5>（三） 数据结构</h5>
<ul>
<li>常用数据结构简介</li>
<li>并发集合了解哪些？</li>
<li>列举java的集合以及集合之间的继承关系</li>
<li>集合类以及集合框架</li>
<li>容器类介绍以及之间的区别（容器类估计很多人没听这个词，Java容器主要可以划分为4个部分：List列表、Set集合、Map映射、工具类（Iterator迭代器、Enumeration枚举类、Arrays和Collections），具体的可以看看这篇博文 <a href="https://link.jianshu.com?t=http%3A%2F%2Falexyyek.github.io%2F2015%2F04%2F06%2FCollection%2F" target="_blank" rel="nofollow">Java容器类</a>）</li>
<li>List,Set,Map的区别</li>
<li>List和Map的实现方式以及存储方式</li>
<li>HashMap的实现原理</li>
<li>HashMap数据结构？</li>
<li>HashMap源码理解</li>
<li>HashMap如何put数据（从HashMap源码角度讲解）？</li>
<li>HashMap怎么手写实现？</li>
<li>ConcurrentHashMap的实现原理</li>
<li>ArrayMap和HashMap的对比</li>
<li>HashTable实现原理</li>
<li>TreeMap具体实现</li>
<li>HashMap和HashTable的区别</li>
<li>HashMap与HashSet的区别</li>
<li>HashSet与HashMap怎么判断集合元素重复？</li>
<li>集合Set实现Hash怎么防止碰撞</li>
<li>ArrayList和LinkedList的区别，以及应用场景</li>
<li>数组和链表的区别</li>
<li>二叉树的深度优先遍历和广度优先遍历的具体实现</li>
<li>堆的结构</li>
<li>堆和树的区别</li>
<li>堆和栈在内存中的区别是什么(解答提示：可以从数据结构方面以及实际实现方面两个方面去回答)？</li>
<li>什么是深拷贝和浅拷贝</li>
<li>手写链表逆序代码</li>
<li>讲一下对树，B+树的理解</li>
<li>讲一下对图的理解</li>
<li>判断单链表成环与否？</li>
<li>链表翻转（即：翻转一个单项链表）</li>
<li>合并多个单有序链表（假设都是递增的）</li>
</ul>
<h5>（四） 线程、多线程和线程池</h5>
<ul>
<li>开启线程的三种方式？</li>
<li>线程和进程的区别？</li>
<li>为什么要有线程，而不是仅仅用进程？</li>
<li>run()和start()方法区别</li>
<li>如何控制某个方法允许并发访问线程的个数？</li>
<li>在Java中wait和seelp方法的不同；</li>
<li>谈谈wait/notify关键字的理解</li>
<li>什么导致线程阻塞？</li>
<li>线程如何关闭？</li>
<li>讲一下java中的同步的方法</li>
<li>数据一致性如何保证？</li>
<li>如何保证线程安全？</li>
<li>如何实现线程同步？</li>
<li>两个进程同时要求写或者读，能不能实现？如何防止进程的同步？</li>
<li>线程间操作List</li>
<li>Java中对象的生命周期</li>
<li>Synchronized用法</li>
<li>synchronize的原理</li>
<li>谈谈对Synchronized关键字，类锁，方法锁，重入锁的理解</li>
<li>static synchronized 方法的多线程访问和作用</li>
<li>同一个类里面两个synchronized方法，两个线程同时访问的问题</li>
<li>volatile的原理</li>
<li>谈谈volatile关键字的用法</li>
<li>谈谈volatile关键字的作用</li>
<li>谈谈NIO的理解</li>
<li>synchronized 和volatile 关键字的区别</li>
<li>synchronized与Lock的区别</li>
<li>ReentrantLock 、synchronized和volatile比较</li>
<li>ReentrantLock的内部实现</li>
<li>lock原理</li>
<li>死锁的四个必要条件？</li>
<li>怎么避免死锁？</li>
<li>对象锁和类锁是否会互相影响？</li>
<li>什么是线程池，如何使用?</li>
<li>Java的并发、多线程、线程模型</li>
<li>谈谈对多线程的理解</li>
<li>多线程有什么要注意的问题？</li>
<li>谈谈你对并发编程的理解并举例说明</li>
<li>谈谈你对多线程同步机制的理解？</li>
<li>如何保证多线程读写文件的安全？</li>
<li>多线程断点续传原理</li>
<li>断点续传的实现</li>
</ul>
<h5>（五）并发编程有关知识点（这个是一般Android开发用的少的，所以建议多去看看）：</h5>
<p>平时Android开发中对并发编程可以做得比较少，Thread这个类经常会用到，但是我们想提升自己的话，一定不能停留在表面，,我们也应该去了解一下java的关于线程相关的源码级别的东西。</p>
<p><strong>学习的参考资料如下：</strong></p>
<blockquote>
<p>Java 内存模型</p>
</blockquote>
<ul>
<li><a href="https://link.jianshu.com?t=http%3A%2F%2Fwww.iteye.com%2Ftopic%2F806990" target="_blank" rel="nofollow">java线程安全总结</a></li>
<li><a href="https://link.jianshu.com?t=http%3A%2F%2Fifeve.com%2Fjava-memory-model-0%2F" target="_blank" rel="nofollow">深入理解java内存模型系列文章</a></li>
</ul>
<blockquote>
<p>线程状态：</p>
</blockquote>
<ul>
<li><a href="https://link.jianshu.com?t=https%3A%2F%2Fmy.oschina.net%2Fmingdongcheng%2Fblog%2F139263" target="_blank" rel="nofollow">一张图让你看懂JAVA线程间的状态转换</a></li>
</ul>
<blockquote>
<p>锁：</p>
</blockquote>
<ul>
<li><a href="https://link.jianshu.com?t=http%3A%2F%2Fblog.csdn.net%2Fvking_wang%2Farticle%2Fdetails%2F9952063" target="_blank" rel="nofollow">锁机制：synchronized、Lock、Condition</a></li>
<li><a href="https://link.jianshu.com?t=http%3A%2F%2Fwiki.jikexueyuan.com%2Fproject%2Fjava-concurrent%2Flocks-in-java.html" target="_blank" rel="nofollow">Java 中的锁</a></li>
</ul>
<blockquote>
<p>并发编程：</p>
</blockquote>
<ul>
<li><a href="https://link.jianshu.com?t=http%3A%2F%2Fwww.cnblogs.com%2Fdolphin0520%2Fp%2F3920357.html" target="_blank" rel="nofollow">Java并发编程：Thread类的使用</a></li>
<li><a href="https://link.jianshu.com?t=http%3A%2F%2Fblog.51cto.com%2Flavasoft%2F27069" target="_blank" rel="nofollow">Java多线程编程总结</a></li>
<li><a href="https://www.jianshu.com/p/053943a425c3#" target="_blank">Java并发编程的总结与思考</a></li>
<li><a href="https://link.jianshu.com?t=http%3A%2F%2Fwww.cnblogs.com%2Fchenssy%2Fp%2F4701027.html" target="_blank" rel="nofollow">Java并发编程实战-----synchronized</a></li>
<li><a href="https://link.jianshu.com?t=http%3A%2F%2Fwww.infoq.com%2Fcn%2Farticles%2FConcurrentHashMap%23" target="_blank" rel="nofollow">深入分析ConcurrentHashMap</a></li>
</ul>
<hr>
<h2>二、Android面试题</h2>
<p>Android面试题包括Android基础，还有一些源码级别的、原理这些等。所以想去大公司面试，一定要多看看源码和实现方式，常用框架可以试试自己能不能手写实现一下，锻炼一下自己。</p>
<h5>（一）Android基础知识点</h5>
<ul>
<li>四大组件是什么</li>
<li>四大组件的生命周期和简单用法</li>
<li>Activity之间的通信方式</li>
<li>Activity各种情况下的生命周期</li>
<li>横竖屏切换的时候，Activity 各种情况下的生命周期</li>
<li>Activity与Fragment之间生命周期比较</li>
<li>Activity上有Dialog的时候按Home键时的生命周期</li>
<li>两个Activity 之间跳转时必然会执行的是哪几个方法？</li>
<li>前台切换到后台，然后再回到前台，Activity生命周期回调方法。弹出Dialog，生命值周期回调方法。</li>
<li>Activity的四种启动模式对比</li>
<li>Activity状态保存于恢复</li>
<li>fragment各种情况下的生命周期</li>
<li>Fragment状态保存startActivityForResult是哪个类的方法，在什么情况下使用？</li>
<li>如何实现Fragment的滑动？</li>
<li>fragment之间传递数据的方式？</li>
<li>Activity 怎么和Service 绑定？</li>
<li>怎么在Activity 中启动自己对应的Service？</li>
<li>service和activity怎么进行数据交互？</li>
<li>Service的开启方式</li>
<li>请描述一下Service 的生命周期</li>
<li>谈谈你对ContentProvider的理解</li>
<li>说说ContentProvider、ContentResolver、ContentObserver 之间的关系</li>
<li>请描述一下广播BroadcastReceiver的理解</li>
<li>广播的分类</li>
<li>广播使用的方式和场景</li>
<li>在manifest 和代码中如何注册和使用BroadcastReceiver?</li>
<li>本地广播和全局广播有什么差别？</li>
<li>BroadcastReceiver，LocalBroadcastReceiver 区别</li>
<li>AlertDialog,popupWindow,Activity区别</li>
<li>Application 和 Activity 的 Context 对象的区别</li>
<li>Android属性动画特性</li>
<li>如何导入外部数据库?</li>
<li>LinearLayout、RelativeLayout、FrameLayout的特性及对比，并介绍使用场景。</li>
<li>谈谈对接口与回调的理解</li>
<li>回调的原理</li>
<li>写一个回调demo</li>
<li>介绍下SurfView</li>
<li>RecycleView的使用</li>
<li>序列化的作用，以及Android两种序列化的区别</li>
<li>差值器</li>
<li>估值器</li>
<li>Android中数据存储方式</li>
</ul>
<h5>（二）Android源码相关分析</h5>
<ul>
<li>Android动画框架实现原理</li>
<li>Android各个版本API的区别</li>
<li>Requestlayout，onlayout，onDraw，DrawChild区别与联系</li>
<li>invalidate和postInvalidate的区别及使用</li>
<li>Activity-Window-View三者的差别</li>
<li>谈谈对Volley的理解</li>
<li>如何优化自定义View</li>
<li>低版本SDK如何实现高版本api？</li>
<li>描述一次网络请求的流程</li>
<li>HttpUrlConnection 和 okhttp关系</li>
<li>Bitmap对象的理解</li>
<li>looper架构</li>
<li>ActivityThread，AMS，WMS的工作原理</li>
<li>自定义View如何考虑机型适配</li>
<li>自定义View的事件</li>
<li>AstncTask+HttpClient 与 AsyncHttpClient有什么区别？</li>
<li>LaunchMode应用场景</li>
<li>AsyncTask 如何使用?</li>
<li>SpareArray原理</li>
<li>请介绍下ContentProvider 是如何实现数据共享的？</li>
<li>AndroidService与Activity之间通信的几种方式</li>
<li>IntentService原理及作用是什么？</li>
<li>说说Activity、Intent、Service 是什么关系</li>
<li>ApplicationContext和ActivityContext的区别</li>
<li>SP是进程同步的吗?有什么方法做到同步？</li>
<li>谈谈多线程在Android中的使用</li>
<li>进程和 Application 的生命周期</li>
<li>封装View的时候怎么知道view的大小</li>
<li>RecycleView原理</li>
<li>AndroidManifest的作用与理解</li>
</ul>
<h5>（三）常见的一些原理性问题</h5>
<ul>
<li>Handler机制和底层实现</li>
<li>Handler、Thread和HandlerThread的差别</li>
<li>handler发消息给子线程，looper怎么启动？</li>
<li>关于Handler，在任何地方new Handler 都是什么线程下?</li>
<li>ThreadLocal原理，实现及如何保证Local属性？</li>
<li>请解释下在单线程模型中Message、Handler、Message Queue、Looper之间的关系</li>
<li>请描述一下View事件传递分发机制</li>
<li>Touch事件传递流程</li>
<li>事件分发中的onTouch 和onTouchEvent 有什么区别，又该如何使用？</li>
<li>View和ViewGroup分别有哪些事件分发相关的回调方法</li>
<li>View刷新机制</li>
<li>View绘制流程</li>
<li>自定义控件原理</li>
<li>自定义View如何提供获取View属性的接口？</li>
<li>Android代码中实现WAP方式联网</li>
<li>AsyncTask机制</li>
<li>AsyncTask原理及不足</li>
<li>如何取消AsyncTask？</li>
<li>为什么不能在子线程更新UI？</li>
<li>ANR产生的原因是什么？</li>
<li>ANR定位和修正</li>
<li>oom是什么？</li>
<li>什么情况导致oom？</li>
<li>有什么解决方法可以避免OOM？</li>
<li>Oom 是否可以try catch？为什么？</li>
<li>内存泄漏是什么？</li>
<li>什么情况导致内存泄漏？</li>
<li>如何防止线程的内存泄漏？</li>
<li>内存泄露场的解决方法</li>
<li>内存泄漏和内存溢出区别？</li>
<li>LruCache默认缓存大小</li>
<li>ContentProvider的权限管理(解答：读写分离，权限控制-精确到表级，URL控制)</li>
<li>如何通过广播拦截和abort一条短信？</li>
<li>广播是否可以请求网络？</li>
<li>广播引起anr的时间限制是多少？</li>
<li>计算一个view的嵌套层级</li>
<li>Activity栈</li>
<li>Android线程有没有上限？</li>
<li>线程池有没有上限？</li>
<li>ListView重用的是什么？</li>
<li>Android为什么引入Parcelable？</li>
<li>有没有尝试简化Parcelable的使用？</li>
</ul>
<h5>（四）开发中常见的一些问题</h5>
<ul>
<li>ListView 中图片错位的问题是如何产生的?</li>
<li>混合开发有了解吗？</li>
<li>知道哪些混合开发的方式？说出它们的优缺点和各自使用场景？（解答：比如:RN，weex，H5，小程序，WPA等。做Android的了解一些前端js等还是很有好处的)；</li>
<li>屏幕适配的处理技巧都有哪些?</li>
<li>服务器只提供数据接收接口，在多线程或多进程条件下，如何保证数据的有序到达？</li>
<li>动态布局的理解</li>
<li>怎么去除重复代码？</li>
<li>画出 Android 的大体架构图</li>
<li>Recycleview和ListView的区别</li>
<li>ListView图片加载错乱的原理和解决方案</li>
<li>动态权限适配方案，权限组的概念</li>
<li>Android系统为什么会设计ContentProvider？</li>
<li>下拉状态栏是不是影响activity的生命周期</li>
<li>如果在onStop的时候做了网络请求，onResume的时候怎么恢复？</li>
<li>Bitmap 使用时候注意什么？</li>
<li>Bitmap的recycler()</li>
<li>Android中开启摄像头的主要步骤</li>
<li>ViewPager使用细节，如何设置成每次只初始化当前的Fragment，其他的不初始化？</li>
<li>点击事件被拦截，但是想传到下面的View，如何操作？</li>
<li>微信主页面的实现方式</li>
<li>微信上消息小红点的原理</li>
<li>CAS介绍（这是阿里巴巴的面试题，我不是很了解，可以参考博客: <a href="https://link.jianshu.com?t=http%3A%2F%2Fblog.csdn.net%2Fjly4758%2Farticle%2Fdetails%2F46673835" target="_blank" rel="nofollow">CAS简介</a>）</li>
</ul>
<hr>
<h2>三、高端技术面试题</h2>
<p><strong>这里讲的是大公司需要用到的一些高端Android技术，这里专门整理了一个文档，希望大家都可以看看。这些题目有点技术含量，需要好点时间去研究一下的。</strong></p>
<h5>（一）图片</h5>
<ul>
<li>图片库对比</li>
<li>图片库的源码分析</li>
<li>图片框架缓存实现</li>
<li>LRUCache原理</li>
<li>图片加载原理</li>
<li>自己去实现图片库，怎么做？</li>
<li>Glide源码解析</li>
<li>Glide使用什么缓存？</li>
<li>Glide内存缓存如何控制大小？</li>
</ul>
<h5>（二）网络和安全机制</h5>
<ul>
<li>网络框架对比和源码分析</li>
<li>自己去设计网络请求框架，怎么做？</li>
<li>okhttp源码</li>
<li>网络请求缓存处理，okhttp如何处理网络缓存的</li>
<li>从网络加载一个10M的图片，说下注意事项</li>
<li>TCP的3次握手和四次挥手</li>
<li>TCP与UDP的区别</li>
<li>TCP与UDP的应用</li>
<li>HTTP协议</li>
<li>HTTP1.0与2.0的区别</li>
<li>HTTP报文结构</li>
<li>HTTP与HTTPS的区别以及如何实现安全性</li>
<li>如何验证证书的合法性?</li>
<li>https中哪里用了对称加密，哪里用了非对称加密，对加密算法（如RSA）等是否有了解?</li>
<li>client如何确定自己发送的消息被server收到?</li>
<li>谈谈你对WebSocket的理解</li>
<li>WebSocket与socket的区别</li>
<li>谈谈你对安卓签名的理解。</li>
<li>请解释安卓为啥要加签名机制?</li>
<li>视频加密传输</li>
<li>App 是如何沙箱化，为什么要这么做？</li>
<li>权限管理系统（底层的权限是如何进行 grant 的）？</li>
</ul>
<h5>（三）数据库</h5>
<ul>
<li>sqlite升级，增加字段的语句</li>
<li>数据库框架对比和源码分析</li>
<li>数据库的优化</li>
<li>数据库数据迁移问题</li>
</ul>
<h5>（四）算法</h5>
<ul>
<li>排序算法有哪些？</li>
<li>最快的排序算法是哪个？</li>
<li>手写一个冒泡排序</li>
<li>手写快速排序代码</li>
<li>快速排序的过程、时间复杂度、空间复杂度</li>
<li>手写堆排序</li>
<li>堆排序过程、时间复杂度及空间复杂度</li>
<li>写出你所知道的排序算法及时空复杂度，稳定性</li>
<li>二叉树给出根节点和目标节点，找出从根节点到目标节点的路径</li>
<li>给阿里2万多名员工按年龄排序应该选择哪个算法？</li>
<li>GC算法(各种算法的优缺点以及应用场景)</li>
<li>蚁群算法与蒙特卡洛算法</li>
<li>子串包含问题(KMP 算法)写代码实现</li>
<li>一个无序，不重复数组，输出N个元素，使得N个元素的和相加为M，给出时间复杂度、空间复杂度。手写算法</li>
<li>万亿级别的两个URL文件A和B，如何求出A和B的差集C(提示：Bit映射-&gt;hash分组-&gt;多文件读写效率-&gt;磁盘寻址以及应用层面对寻址的优化)</li>
<li>百度POI中如何试下查找最近的商家功能(提示：坐标镜像+R树)。</li>
<li>两个不重复的数组集合中，求共同的元素。</li>
<li>两个不重复的数组集合中，这两个集合都是海量数据，内存中放不下，怎么求共同的元素？</li>
<li>一个文件中有100万个整数，由空格分开，在程序中判断用户输入的整数是否在此文件中。说出最优的方法</li>
<li>一张Bitmap所占内存以及内存占用的计算</li>
<li>2000万个整数，找出第五十大的数字？</li>
<li>烧一根不均匀的绳，从头烧到尾总共需要1个小时。现在有若干条材质相同的绳子，问如何用烧绳的方法来计时一个小时十五分钟呢？</li>
<li>求1000以内的水仙花数以及40亿以内的水仙花数</li>
<li>5枚硬币，2正3反如何划分为两堆然后通过翻转让两堆中正面向上的硬8币和反面向上的硬币个数相同</li>
<li>时针走一圈，时针分针重合几次</li>
<li>N*N的方格纸,里面有多少个正方形</li>
<li>x个苹果，一天只能吃一个、两个、或者三个，问多少天可以吃完？</li>
</ul>
<h5>（五）插件化、模块化、组件化、热修复、增量更新、Gradle</h5>
<ul>
<li>对热修复和插件化的理解</li>
<li>插件化原理分析</li>
<li>模块化实现（好处，原因）</li>
<li>热修复,插件化</li>
<li>项目组件化的理解</li>
<li>描述清点击 Android Studio 的 build 按钮后发生了什么</li>
</ul>
<h5>（六）架构设计和设计模式</h5>
<ul>
<li>谈谈你对Android设计模式的理解</li>
<li>MVC MVP MVVM原理和区别</li>
<li>你所知道的设计模式有哪些？</li>
<li>项目中常用的设计模式</li>
<li>手写生产者/消费者模式</li>
<li>写出观察者模式的代码</li>
<li>适配器模式，装饰者模式，外观模式的异同？</li>
<li>用到的一些开源框架，介绍一个看过源码的，内部实现过程。</li>
<li>谈谈对RxJava的理解</li>
<li>RxJava的功能与原理实现</li>
<li>RxJava的作用，与平时使用的异步操作来比的优缺点</li>
<li>说说EventBus作用，实现方式，代替EventBus的方式</li>
<li>从0设计一款App整体架构，如何去做？</li>
<li>说一款你认为当前比较火的应用并设计(比如：直播APP，P2P金融，小视频等)</li>
<li>谈谈对java状态机理解</li>
<li>Fragment如果在Adapter中使用应该如何解耦？</li>
<li>Binder机制及底层实现</li>
<li>对于应用更新这块是如何做的？(解答：灰度，强制更新，分区域更新)？</li>
<li>实现一个Json解析器(可以通过正则提高速度)</li>
<li>统计启动时长,标准</li>
</ul>
<h5>（七）性能优化</h5>
<ul>
<li>如何对Android 应用进行性能分析以及优化?</li>
<li>ddms 和 traceView</li>
<li>性能优化如何分析systrace？</li>
<li>用IDE如何分析内存泄漏？</li>
<li>Java多线程引发的性能问题，怎么解决？</li>
<li>启动页白屏及黑屏解决？</li>
<li>启动太慢怎么解决？</li>
<li>怎么保证应用启动不卡顿？</li>
<li>App启动崩溃异常捕捉</li>
<li>自定义View注意事项</li>
<li>现在下载速度很慢,试从网络协议的角度分析原因,并优化(提示：网络的5层都可以涉及)。</li>
<li>Https请求慢的解决办法（提示：DNS，携带数据，直接访问IP）</li>
<li>如何保持应用的稳定性</li>
<li>RecyclerView和ListView的性能对比</li>
<li>ListView的优化</li>
<li>RecycleView优化</li>
<li>View渲染</li>
<li>Bitmap如何处理大图，如一张30M的大图，如何预防OOM</li>
<li>java中的四种引用的区别以及使用场景</li>
<li>强引用置为null，会不会被回收？</li>
</ul>
<h5>（八）NDK、jni、Binder、AIDL、进程通信有关</h5>
<ul>
<li>请介绍一下NDK</li>
<li>什么是NDK库?</li>
<li>jni用过吗？</li>
<li>如何在jni中注册native函数，有几种注册方式?</li>
<li>Java如何调用c、c++语言？</li>
<li>jni如何调用java层代码？</li>
<li>进程间通信的方式？</li>
<li>Binder机制</li>
<li>简述IPC？</li>
<li>什么是AIDL？</li>
<li>AIDL解决了什么问题？</li>
<li>AIDL如何使用？</li>
<li>Android 上的 Inter-Process-Communication 跨进程通信时如何工作的？</li>
<li>多进程场景遇见过么？</li>
<li>Android进程分类？</li>
<li>进程和 Application 的生命周期？</li>
<li>进程调度</li>
<li>谈谈对进程共享和线程安全的认识</li>
<li>谈谈对多进程开发的理解以及多进程应用场景</li>
<li>什么是协程？</li>
</ul>
<h5>（九）framework层、ROM定制、Ubuntu、Linux之类的问题</h5>
<ul>
<li>java虚拟机的特性</li>
<li>谈谈对jvm的理解</li>
<li>JVM内存区域，开线程影响哪块内存</li>
<li>对Dalvik、ART虚拟机有什么了解？</li>
<li>Art和Dalvik对比</li>
<li>虚拟机原理，如何自己设计一个虚拟机(内存管理，类加载，双亲委派)</li>
<li>谈谈你对双亲委派模型理解</li>
<li>JVM内存模型，内存区域</li>
<li>类加载机制</li>
<li>谈谈对ClassLoader(类加载器)的理解</li>
<li>谈谈对动态加载（OSGI）的理解</li>
<li>内存对象的循环引用及避免</li>
<li>内存回收机制、GC回收策略、GC原理时机以及GC对象</li>
<li>垃圾回收机制与调用System.gc()区别</li>
<li>Ubuntu编译安卓系统</li>
<li>系统启动流程是什么？（提示：Zygote进程 –&gt; SystemServer进程 –&gt; 各种系统服务 –&gt; 应用进程）</li>
<li>大体说清一个应用程序安装到手机上时发生了什么</li>
<li>简述Activity启动全部过程</li>
<li>App启动流程，从点击桌面开始</li>
<li>逻辑地址与物理地址，为什么使用逻辑地址？</li>
<li>Android为每个应用程序分配的内存大小是多少？</li>
<li>Android中进程内存的分配，能不能自己分配定额内存？</li>
<li>进程保活的方式</li>
<li>如何保证一个后台服务不被杀死？（相同问题：如何保证service在后台不被kill？）比较省电的方式是什么？</li>
<li>App中唤醒其他进程的实现方式</li>
</ul>
<hr>
<h2>四、非技术性问题&amp;HR问题汇总</h2>
<p><strong>这里整理的是一些与技术没有直接关系的面试题，但是能够考察你的综合水平，所以不要以为不是技术问题，就不看，往往有时候就是这样一些细节的题目被忽视，而错过了一次次面试机会。</strong></p>
<h5>（一）非技术问题</h5>
<ul>
<li>介绍你做过的哪些项目</li>
<li>都使用过哪些框架、平台？</li>
<li>都使用过哪些自定义控件？</li>
<li>研究比较深入的领域有哪些？</li>
<li>对业内信息的关注渠道有哪些？</li>
<li>最近都读哪些书？</li>
<li>有没有什么开源项目？</li>
<li>自己最擅长的技术点，最感兴趣的技术领域和技术点</li>
<li>项目中用了哪些开源库，如何避免因为引入开源库而导致的安全性和稳定性问题</li>
<li>实习过程中做了什么，有什么产出？</li>
</ul>
<h5>（二）HR提出的面试问题</h5>
<ul>
<li>您在前一家公司的离职原因是什么？</li>
<li>讲一件你印象最深的一件事情</li>
<li>介绍一个你影响最深的项目</li>
<li>介绍你最热爱最擅长的专业领域</li>
<li>公司实习最大的收获是什么？</li>
<li>与上级意见不一致时，你将怎么办？</li>
<li>自己的优点和缺点是什么？并举例说明？</li>
<li>你的学习方法是什么样的？实习过程中如何学习？实习项目中遇到的最大困难是什么以及如何解决的？</li>
<li>说一件最能证明你能力的事情</li>
<li>针对你你申请的这个职位，你认为你还欠缺什么</li>
<li>如果通过这次面试我们单位录用了你，但工作一段时间却发现你根本不适合这个职位，你怎么办？</li>
<li>项目中遇到最大的困难是什么？如何解决的？</li>
<li>你的职业规划以及个人目标、未来发展路线及求职定位</li>
<li>如果你在这次面试中没有被录用，你怎么打算？</li>
<li>评价下自己，评价下自己的技术水平，个人代码量如何？</li>
<li>通过哪些渠道了解的招聘信息，其他同学都投了哪些公司？</li>
<li>业余都有哪些爱好？</li>
<li>你做过的哪件事最令自己感到骄傲？</li>
<li>假如你晚上要去送一个出国的同学去机场，可单位临时有事非你办不可，你怎么办？</li>
<li>就你申请的这个职位，你认为你还欠缺什么？</li>
<li>当前的offer状况；如果BATH都给了offer该如何选？</li>
<li>你对一份工作更看重哪些方面？平台，技术，氛围，城市，还是money？</li>
<li>理想薪资范围；杭州岗和北京岗选哪个？</li>
<li>理想中的工作环境是什么？</li>
<li>谈谈你对跳槽的看法</li>
<li>说说你对行业、技术发展趋势的看法</li>
<li>实习过程中周围同事/同学有哪些值得学习的地方？</li>
<li>家人对你的工作期望及自己的工作期望</li>
<li>如果你的工作出现失误，给本公司造成经济损失，你认为该怎么办？</li>
<li>若上司在公开会议上误会你了，该如何解决？</li>
<li>是否可以实习，可以实习多久？</li>
<li>在五年的时间内，你的职业规划</li>
<li>你看中公司的什么？或者公司的那些方面最吸引你？</li>
</ul>
<hr>
<p><strong>引用声明：</strong></p>
<p>文章开头图片来自于 <a href="https://link.jianshu.com?t=https%3A%2F%2Fmini.eastday.com%2Fa%2F160420175508810.html%3Fbtype%3Dlistpage%26idx%3D37%26ishot%3D0%26subtype%3Dnews" target="_blank" rel="nofollow">https://mini.eastday.com/a/160420175508810.html?btype=listpage&amp;idx=37&amp;ishot=0&amp;subtype=news</a></p>
<p>本文参考相关博文如下：</p>
<p><a href="https://link.jianshu.com?t=https%3A%2F%2Fmp.weixin.qq.com%2Fs%3F__biz%3DMzIyMjQ0MTU0NA%3D%3D%26mid%3D2247484617%26idx%3D1%26sn%3D3734e643d241ac9615424dd44462ee2d%26chksm%3De82c3deedf5bb4f82e7be0823739774a0a2cf8372284c8409471c2752fea1f367ca3f6857795%26mpshare%3D1%26scene%3D23%26srcid%3D1128DKotEvTe4dheaTextbqp%23rd" target="_blank" rel="nofollow">阿里、腾讯、百度、华为、京东、搜狗和滴滴最新面试题汇集</a></p>
<p><a href="https://link.jianshu.com?t=https%3A%2F%2Fzhuanlan.zhihu.com%2Fp%2F30016683" target="_blank" rel="nofollow">2017下半年，一二线互联网公司Android面试题汇总</a></p>
<p><a href="https://link.jianshu.com?t=https%3A%2F%2Fzhuanlan.zhihu.com%2Fp%2F26327485" target="_blank" rel="nofollow">2017 年初、阿里、腾讯、百度、华为、京东、搜狗和滴滴面试题汇集（更新篇）</a></p>
<p><a href="https://link.jianshu.com?t=https%3A%2F%2Fgithub.com%2FLRH1993%2Fandroid_interview" target="_blank" rel="nofollow">android_interview</a></p>
<p><a href="https://link.jianshu.com?t=https%3A%2F%2Fgithub.com%2FJackyAndroid%2FAndroidInterview-Q-A" target="_blank" rel="nofollow">AndroidInterview-Q-A</a></p>
<hr>
<h3>相关文章：</h3>
<p><strong><a href="https://www.jianshu.com/p/3ff11bada6a0" target="_blank">【面试经验】那些年面试遇到的“坑”</a><br>
<a href="https://www.jianshu.com/p/76daf0ea966c" target="_blank">老程序员的10条中肯建议</a><br>
<a href="https://www.jianshu.com/p/57fd54974d71" target="_blank">一个十几年程序员给所有新老程序员的忠告</a></strong></p>

          </div>