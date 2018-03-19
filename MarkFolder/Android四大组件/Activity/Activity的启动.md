#Activity的启动知识整理<hr>
<a href="https://www.jianshu.com/p/86ad1026cef3">Android 7.0 startActivity()源码解析以及对几个问题的思考--Xu朝旭</a><br>
<a href=""></a>
<pre>
作者：Xu朝旭
链接：https://www.jianshu.com/p/86ad1026cef3
來源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
</pre>

######1、是通过何种方式生成一个新的Activity类的，是通过java反射生成的吗？<br>
>新的Activity类是通过类加载器方式即通过反射的方式生成的<br>
>>ActivityThread里面：
><pre>
>ContextImpl appContext = createBaseContextForActivity(r);
        Activity activity = null;
        try {
            java.lang.ClassLoader cl = appContext.getClassLoader();
            activity = mInstrumentation.newActivity(
                    cl, component.getClassName(), r.intent);	
		........................
></pre>
>>Instrumentation里面：
><pre>
>public Activity newActivity(ClassLoader cl, String className, Intent intent)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    return (Activity)cl.loadClass(className).newInstance();
}
></pre>
>接着调用了Activity的onCreate方法
>>ActivityThread的performLaunchActivity里面：
><pre>
>activity.mCalled = false;
                if (r.isPersistable()) {
                    mInstrumentation.callActivityOnCreate(activity, r.state, r.persistentState);
                } else {
                    mInstrumentation.callActivityOnCreate(activity, r.state);
                }
></pre>
>>Instrumentation的里面：
><pre>
>  public void callActivityOnCreate(Activity activity, Bundle icicle) {
        prePerformCreate(activity);
        activity.performCreate(icicle);
        postPerformCreate(activity);
    }
  public void callActivityOnCreate(Activity activity, Bundle icicle,
            PersistableBundle persistentState) {
        prePerformCreate(activity);
        activity.performCreate(icicle, persistentState);
        postPerformCreate(activity);
    }
></pre>
>>Activity里面：
><pre>
  >final void performCreate(Bundle icicle) {
        restoreHasCurrentPermissionRequest(icicle);
        onCreate(icicle);
        mActivityTransitionState.readState(icicle);
        performCreateCommon();
    }
>
   final void performCreate(Bundle icicle, PersistableBundle persistentState) {
        restoreHasCurrentPermissionRequest(icicle);
        onCreate(icicle, persistentState);
        mActivityTransitionState.readState(icicle);
        performCreateCommon();
    }
></pre>
######2、Activity的生命周期回调方法是通过哪个类调用的，在什么时候调用的？<br>
>Activity的生命周期方法是通过Instrumentation类调用callActivityOnXXX方法最终调用Activity的onCreate等方法，调用时机为ActivityThread#performLaunchActivitiy()方法中。
>>ActivityThread的performLaunchActivity里面：
><pre>
if (!r.activity.mFinished) {
    activity.performStart();
    r.stopped = false;
}
></pre>
>>Activity里面：
><pre>
> final void performStart() {
        mActivityTransitionState.setEnterActivityOptions(this, getActivityOptions());
        mFragments.noteStateNotSaved();
        mCalled = false;
        mFragments.execPendingActions();
        mInstrumentation.callActivityOnStart(this);
	.....................................
</pre>
>>Instrumentation的里面：
><pre>
> public void callActivityOnStart(Activity activity) {
        activity.onStart();
    }
</pre>
>除了Destroy方法，其他的生命周期都有在ActivityThread 里面显示的调用activity.performXXX 然后Activity里面调用 Intrumentation的  mInstrumentation.callActivityOnXXX方法来执行Activity的生命周期<br><br>
><h6>Activity的onDestroy方法</h6>
>>ActivityThread里面：
><pre>
>  public final ActivityClientRecord performDestroyActivity(IBinder token, boolean finishing) {
        return performDestroyActivity(token, finishing, 0, false);
    }
></pre>
><pre>
> private ActivityClientRecord performDestroyActivity(IBinder token, boolean finishing,
            int configChanges, boolean getNonConfigInstance) {
	...................
> mInstrumentation.callActivityOnDestroy(r.activity);
	...................
}
></pre>
>>Instrumentation的里面：
><pre>
>public void callActivityOnDestroy(Activity activity) {
      activity.performDestroy();
  }
</pre>
>>Activity里面：
><pre>
>   final void performDestroy() {
        mDestroyed = true;
        mWindow.destroy();
        mFragments.dispatchDestroy();
        onDestroy();
        mFragments.doLoaderDestroy();
        if (mVoiceInteractor != null) {
            mVoiceInteractor.detachActivity();
        }
    }
</pre>
>这里看到调用Activity的onDestroy方法之前销毁的Window对象。前后销毁和Fragment相关联的对象。
######3、界面的绘制是在执行Activity#onResume()之后还是之前？<br>
><pre>ActivityThread#performResumeActivity()
  --> Activity#performResume()
    --> Instrumentation#callActivityOnResume()
      --> Activity#onResume()
</pre>
><pre>
>final void handleResumeActivity(IBinder token,
            boolean clearHide, boolean isForward, boolean reallyResume, int seq, String reason) {
	..............................
	 // TODO Push resumeArgs into the activity for consideration
        r = performResumeActivity(token, clearHide, reason);
	..............................
	if (r.window == null && !a.mFinished && willBeVisible) {
                r.window = r.activity.getWindow();
                View decor = r.window.getDecorView();
	..............................
	    wm.addView(decor, l);
	..............................
></pre>
>所以页面的渲染再Ressume后。<br>

但是怎么优化Activity的加载速度呢？
>因为我们一般吧视图的加载都放到了Activity的onResume方法里面去调用了，但是这样还不够。<br>
>>来看看DK_BurNIng大神的 <a href="https://juejin.im/post/5a6fd7b86fb9a01ca">深入理解 Activty 加载速度优化</a> 吧。
>><pre>
> @Override
    protected void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                @Override
                public boolean queueIdle() {
                    Log.v("wuyue", "textView height2==" + textView.getWidth());
			//再这里做视图的加载！！！
                    return false;
                }
            });
        }
    }
作者：DK_BurNIng
链接：https://juejin.im/post/5a6fd7b86fb9a01ca47ac6e8
来源：掘金
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
>></pre>



######4、在之前的学习中，我了解到应用程序的真正入口是ActivityThread类，那么ActivityThread#main()方法是在哪里调用的？
><pre>
>ActivityThread的main方法是在生成一个新的app进程过程中调用的，具体是通过与Zygote
>通信，之后通过RuntimeInit类采用反射的方式调用ActivityThread#main()方法，
>即生成app中的主线程（UI线程）！
></pre>
