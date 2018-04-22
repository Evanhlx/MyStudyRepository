#进阶--Android<hr>
## 阅读源码的准备

* Java基础：上层framework以及App层都是采用Java语法；
* C/C++基础：Android的jni/native层代码采用C++，Linux 采用C；* 
* Linux：Android内核基于Linux的，了解Linux相关知识对深入掌握 Android还是很有必要。
* Git：Android源码采用git和repo进行管理；
* Make：Android源码采用Make系统编译，源码系统中会看到很多Android.mk之类的文件；
* Source Insight：这绝对是看源码的神器；可以在Java、C++、C代码之间无缝衔接；
* Eclipse：熟悉常用快捷键，工欲善其事必先利其器；虽然Source Insight很方便，但由于对Eclipse的熟悉感，对于framework Java层面的代码，我还是更习惯用Eclipse来看，对于Native代码以及linux代码则采用Source Insight来看；
* Android Studio：这是Google官方支持的App开发环境，简称AS，目前已经推出AS 2.0正式版，使用教程android-studio.org；
* Google Drawings：这是画图工具，Gityuan博客中的文章都是采用Google Drawing完成，比如Binder开篇文中的图。
* StarUML：这是类图，Gityuan博客文章的类图和流程图都是采用StarUML完成，比如理解Android进程创建流程文中时序图。

##进阶书籍

* 深入理解Linux内核
* 深入Linux内核架构 
* Linux内核设计与实现 
*  Linux设备驱动程序 
* 重构 改善既有代码的设计
* 编程珠玑 （卷1, 卷2）
* 设计模式
* 设计模式之禅
* 人月神话


##Java书籍 


* Thinking in Java： 中文版《Java编程思想 》
 	>这是一本非常经典的Java书籍，很多人都说这个书不适合初学者，我记得自己当初看的第一本Java书便是这本书。看完第一遍对Java有了整体的理解，但很多细节没有完全理解，查了资源又看了第二遍，对Java有了更深地理解。再后来一段时间后，能力也有所提升，再拿起这本书又看了第三遍，发现对面向对象有了更深一步的理解，这本书就是适合反复的阅读。
 
* Effective Java：Java进阶书
  	>这本书采用“条目”的方式来展开的，总提出了78条Java具体的建议，对Java平台精妙之处的独到见解，还提供优秀的代码范例。作为Java进阶之书，对Java水平的提升大有裨益。
  
* Java concurrency in Practice：中文版《Java并发编程实战》
	>本书采用循序渐进的讲解方式，从并发编程的基本理论讲起，再讲述了结构化并发应用，性能与测试，最后将显式锁、原子变量、非阻塞算法这些高级主题。对于Java并发这一块算得上是一本很棒的书。 
	

* Java Performance：中文版《Java性能优化权威指南》
    >Java之父James Gosling推荐的一本Java应用性能优化的经典之作，包含算法结构、内存、I/O、磁盘使用方式，内容通俗易懂，还介绍了大量的监控和测量工具。关于优化都是属于较深的领域，对Java有一定基础后，很有必要了解看看。


* Java虚拟机，这是作为进阶Java高手必需有所了解：
    >The Java Language Specification，官方Java文档（英文版）<br>
    >The Java® Virtual Machine Specification，官方Jvm文档（英文版）<br>
    深入理解java虚拟机：<br>这是国内关于Java虚拟机讲得非常全面的一本书，从Java GC到Java虚拟机内部实现以及优化策略，作为Java高手非常值得一看的书籍。
