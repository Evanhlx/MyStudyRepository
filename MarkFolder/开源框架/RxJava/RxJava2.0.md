#RxJava 2.0 <hr>
前言：<br>
有人说RxJava 1.0 和2.0 没多大却别。看完<a href="http://gank.io/post/560e15be2dca930e00da1083">抛物线大神</a>的1.0版本后再去看2.0。怎么我发现里面的实现却别大的去了呢？只能说思想是不变的。

<a href="http://blog.csdn.net/qq_35064774/article/details/53045298">RxJava 2.0有什么不同(译)</a>

<a href="https://github.com/ReactiveX/RxJava/wiki/What%27s-different-in-2.0">What's different in 2.0</a>

<a href="https://juejin.im/post/5848d96761ff4b0058c9d3dc">给初学者的RxJava2.0教程(一)</a>

#####1、2.0后，Observable 订阅不上Subscriber了

#####2、2.0后 Subscriber改成了独立的接口。不再是Observer的抽象实现类。所以Observable订阅不上了Subscriber。
>自然，跟随Subscriber 的 Subscription 也该了。虽然还是接口，但是里面的实现边了。没了unsbuscribe()和 isUnsubscribed()。改成了 request() 和 cancel()

#####3、2.0 看图：<a href="https://www.jianshu.com/p/220955eefc1f">参考来源：RxJava 2.0 全新来袭</a>
>出现了两种观察者模式：
>
>Observable(被观察者)/Observer（观察者）<br>
>Flowable(被观察者)/Subscriber(观察者)
><img src="https://dn-mhke0kuv.qbox.me/1cfc1779f2a93ad2f7c8.png"/>

>><h5>背压:<h5>
>><h6>背压是指在异步场景中，被观察者发送事件速度远快于观察者的处理速度的情况下，一种告诉上游的被观察者降低发送速度的策略</h6>
>RxJava2.X中，Observeable用于订阅Observer，是不支持背压的，而Flowable用于订阅Subscriber，是支持背压(Backpressure)的。


<pre>
当你在onSubscribe/onStart中做了一些初始化的工作，而这些工作是在request后面时，
会出现一些问题，在onNext执行时，你的初始化工作的那部分代码还没有执行。
为了避免这种情况，请确保你调用request时，已经把所有初始化工作做完了。
</pre>

Single/SingleObserver
>没有onComplete 方法。<br>
>数据流只执行一次

Completable/CompletableObserver
>

Maybe/MaybeObserver
>数据流只执行一次

######4、2.0 Action的改变
>Rx1.0-----------Rx2.0
>
Action1--------Action<br>
Action1--------Consumer<br>
Action2--------BiConsumer<br>
后面的Action都去掉了，只保留了ActionN

<pre>
TCK 允许同步但限制onSubscribe 和 onNext之间往返。也就是说在onSubscribe中，
调用request(1)后将会调用onNext，在onNext返回后request(1)才会返回。
虽然大部分操作符都是这样的，但操作符observeOn会异步的调用onNext，
因此onSubscribe会和onNext同时被调用。这就是由TCK来检测，
我们使用another operator来延迟下游请求直到onSubscribe返回。
再次声明，这种异步行为不是RxJava 2的一个问题，
因为在Reactor 3中操作符是线程安全的执行onSubscribe。Akka-Stream的转换类似于延迟请求。
因为这两个影响inter-library的行为，我们考虑在以后给Flowable增加了一个标准的操作符，
把这两种行为改到一个单独的方法。
???????????????????
</pre>

#####5、以前在1.x中独立的BlockingObservable 已经集成了主要的基础类型。现在你可以直接调用blockingX来阻塞等待结果:

#####6、在2.x中另外一个关于rx.Subscriber 和org.reactivestreams.Subscriber重要的区别是，你的Subscriber和Observer不允许抛出任何致命的异常。
>这样的规则同样适用于Observer, SingleObserver, MaybeObserver 和CompletableObserver。
>
由于很多现有基于1.x的代码做了类似的事情，我们设计了safeSubscribe方法来帮助你处理这样的代码。

#####7、Testing

>测试RxJava 2.x和1.x中一样，<br>
>Flowable可以用io.reactivex.subscribers.TestSubscriber测试，<br>
>而非背压的Observable, Single, Maybe 和 Completable可以用io.reactivex.observers.TestObserver测试

#####8、2.x中，我们在onSubscribe()回调中必须调用s.request()方法去请求资源，参数就是要请求的数量，一般如果不限制请求数量，可以写成Long.MAX_VALUE，之后会立即触发onNext()方法！