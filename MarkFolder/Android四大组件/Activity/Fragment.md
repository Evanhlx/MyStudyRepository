#Fragment<hr>
######1、setUserVisibleHint－－ fragment真正的onResume和onPause方法
>这个方法，只有当嵌套在ViewPager才调用，而且比Fragment的onCreate方法早调用几次。

######2、Difference between onCreateView and onViewCreated in Fragment


>What's the essential difference between these two methods? When I create a TextView, should I use one over the other for performance?
>
>onViewCreated is called immediately after onCreateView (the method you initialize and create all your objects, including your TextView), so it's not a matter of performance.

######4、Fragment的回退栈、
>当你移除一个fragment的时候，如果commit()之前没有调用addToBackStack()，那个fragment将会是destroyed；如果调用了addToBackStack()，这个fragment会是stopped，可以通过返回键来恢复。

######5、commit()方法
>1、调用commit()方法并不能立即执行transaction中包含的改变动作，commit()方法把transaction加入activity的UI线程队列中。<br>
2、注意：你只能在activity存储它的状态（当用户要离开activity时）之前调用commit()，如果在存储状态之后调用commit()，将会抛出一个异常 ???

######6、onHiddenChanged
>public void onHiddenChanged(boolean hidden)<br>
>Fragment 隐藏切换时候调用。

######7、method 'void android.support.v4.app.Fragment.setNextAnim(int)' on a null object reference
><a href="https://www.cnblogs.com/hixin/p/4427276.html">问题处理</a>

######8、Fragment、replace、和hide、show方法的生命周期
><a href="http://blog.csdn.net/tiantaiaiqing/article/details/79527350">Fragment --replace方法和hide、show方法的生命周期分析</a>