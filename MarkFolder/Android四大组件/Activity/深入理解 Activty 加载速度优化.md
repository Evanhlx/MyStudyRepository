
<a href="https://juejin.im/post/5a6fd7b86fb9a01ca">深入理解 Activty 加载速度优化</a>
<hr>
<h6>但是怎么优化Activity的加载速度呢？</h6>
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

