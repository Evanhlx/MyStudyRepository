#Android屏幕适配
<hr>
<a href="https://developer.android.com/guide/practices/screens_support.html">Android 支持多种屏幕</a>

#####总结：
<pre>
1、使用 dp。
2、为相应密度提供代替的位图资源。
3、为相应大小屏幕、横竖屏提供对应的布局资源。
</pre>




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

#####匹配资源的情况
><pre>
如果没有更好的匹配资源，则系统将 使用专为小于当前屏幕的屏幕而设计的 资源（例如，如有必
要，大尺寸屏幕将使用标准尺寸的屏幕 资源）。但是，如果唯一可用的资源大于当前屏幕， 则系
统不会使用这些资源，并且如果没有其他资源与设备 配置匹配，应用将会崩溃
></pre>
为何，位图资源 却可以上下兼容？
><pre>
>Android 如下解释：
>这条规则有一个例外：如果应用的 minSdkVersion 为 4 或更高版本，则在提供带屏幕密度限定
>符的备用可绘制对象资源时，不需要默认可绘制对象资源。 即使没有默认可绘制对象资源，
>Android 也可以从备用屏幕密度中找到最佳匹配项并根据需要缩放位图。 但是，为了在所有类型
>的设备上提供最佳体验，您应该为所有三种类型的密度提供备用可绘制对象
></pre>

#####密度独立性
><pre>
Android 系统可帮助您的应用以两种方式实现密度独立性：
>
1、系统根据当前屏幕密度扩展 dp 单位数
2、系统在必要时可根据当前屏幕 密度将可绘制对象资源扩展到适当的大小
>
密度独立像素的基线是中密度屏幕
></pre>
保持密度独立性很重要，因为如果没有此功能，UI 元素（例如 按钮）在低密度屏幕上看起来较大，在高密度屏幕上看起来较小。

#####如何支持多种屏幕
在清单中显式声明您的应用 支持哪些屏幕尺寸
><pre>
>要声明应用支持的屏幕尺寸，应在清单文件中包含 &lt supports-screens &gt 元素。
>通过声明您的应用支持哪些屏幕尺寸，可确保只有 其屏幕受支持的设备才能下载您的应用。
</pre>

为不同屏幕尺寸提供不同的布局
><pre>
>为不同屏幕尺寸提供不同的布局
>
>small、normal、large 和 xlarge。
从 Android 3.2（API 级别 13）开始，以上尺寸组已弃用，您 应改为使用 sw<N>dp 配置限定符
来定义布局资源 可用的最小宽度。
例如：
	需要至少 600dp 的屏幕宽度，应将其放在 layout-sw600dp/ 中。
注：您使用这些限定符指定的尺寸 不是实际屏幕尺寸。更确切地说，尺寸是可用于 Activity
 窗口的宽度或高度（dp 单位）,高度应该包含操作栏在内（Tollbar等）
</pre>

为不同屏幕密度提供不同的位图可绘制对象
><pre>
>系统使用适当的备用资源
>如果没有匹配的资源，系统将使用默认资源，并按需要向上 或向下扩展，以匹配当前的屏幕尺寸
>和密度
>当系统查找密度特定的资源但在 密度特定目录中未找到时，不一定会使用默认资源。
>
>要为不同的密度创建替代位图可绘制对象，应遵循六种通用密度之间的 3:4:6:8:12:16 
>缩放比率。----0.75:1:1.5:2:3:4
></pre>

多窗口适配
><a href="https://www.jianshu.com/p/e6a908d7d5b1">是时候学习Android分屏开发了</a>