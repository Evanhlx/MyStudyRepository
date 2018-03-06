#Android屏幕适配
<hr>
<a href="https://developer.android.com/guide/practices/screens_support.html">Android 支持多种屏幕</a>
#####六种通用的密度：
><pre>
ldpi（低）~120dpi 			0.75
mdpi（中）~160dpi			1
hdpi（高）~240dpi			1.5
xhdpi（超高）~320dpi			2
xxhdpi（超超高）~480dpi		3
xxxhdpi（超超超高）~640dpi	4
</pre>

#####<a href="https://developer.android.com/guide/practices/screens_support.html#DensityConsiderations">不需要缩放资源</a>
><pre>
>有时您可能不希望 Android 预缩放 资源。避免预缩放最简单的方法是将资源放在 
>有 nodpi 配置限定符的资源目录中。例如：
res/drawable-nodpi/icon.png
当系统使用此文件夹中的 icon.png 位图时，不会 根据当前设备密度缩放。
></pre>

#####<a href="https://developer.android.com/guide/practices/screens_support.html#testing">将 dp 单位转换为像素单位</a>
><pre>
>// The gesture threshold expressed in dp
>private static final float GESTURE_THRESHOLD_DP = 16.0f;
>
>// Get the screen's density scale
>final float scale = getResources().getDisplayMetrics().density;
>// Convert the dps to pixels, based on density scale
>mGestureThreshold = (int) (GESTURE_THRESHOLD_DP * scale + 0.5f);
>
>// Use mGestureThreshold as a distance in pixels...
></pre>

><pre>
><h6 style="font-size:12px">但是，不能为此类事件定义任意阈值，而应 使用 ViewConfiguration 中的预缩放配置值。</h6>
>使用预缩放的配置值
>您可以使用 ViewConfiguration 类访问 Android 系统使用的通常距离、 速度和时间。例如， 
>使用 >getScaledTouchSlop() 可获取框架用作滚动阈值的距离（像素）：
>
>private static final int GESTURE_THRESHOLD_DP = 
>ViewConfiguration.get(myContext).getScaledTouchSlop();
>ViewConfiguration 中以 getScaled 前缀 开头的方法确定会返回不管当前屏幕密度为何都会
>正常显示的 像素值。
></pre>