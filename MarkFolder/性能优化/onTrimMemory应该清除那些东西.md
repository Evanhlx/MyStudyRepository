<a href="http://androidperformance.com/2015/07/20/Android-Performance-Memory-onTrimMemory.html">Android代码内存优化建议-OnTrimMemory优化</a>

###2. OnTrimMemory回调中可以释放哪些资源？

通常在架构阶段就要考虑清楚，我们有哪些东西是要常驻内存的，有哪些是伴随界面存在的．一般情况下，有下面几种资源需要进行释放：

* 缓存 缓存包括一些文件缓存，图片缓存等，在用户正常使用的时候这些缓存很有作用，但当你的应用程序UI不可见的时候，这些缓存就可以被清除以减少内存的使用．比如第三方图片库的缓存．


* 一些动态生成动态添加的View．　这些动态生成和添加的View且少数情况下才使用到的View，这时候可以被释放，下次使用的时候再进行动态生成即可．比如原生桌面中，会在OnTrimMemory的TRIM_MEMORY_MODERATE等级中，释放所有AppsCustomizePagedView的资源，来保证在低内存的时候，桌面不会轻易被杀掉．