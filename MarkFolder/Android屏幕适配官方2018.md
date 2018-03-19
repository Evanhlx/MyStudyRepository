开发
API 指南
Device Compatibility
#支持多种屏幕

<div class="jd-descr " itemprop="articleBody">
      

<div id="qv-wrapper">
<div id="qv">

  <h2>内容快览</h2>
  <ul>
    <li>Android 可在具有不同屏幕尺寸和密度的设备上运行。</li>
    <li>显示应用的屏幕可影响其用户界面。</li>
    <li>系统会处理大多数工作，使您的应用适应当前屏幕。</li>
    <li>您应该创建屏幕特定的资源，以精确控制 UI。 </li>
  </ul>

  <h2>本文内容</h2>
  <ol>
    <li><a href="#overview">屏幕支持概览</a>
      <ol>
        <li><a href="#terms">术语和概念</a></li>
        <li><a href="#range">支持的屏幕范围</a></li>
        <li><a href="#density-independence">密度独立性</a></li>
      </ol></li>
    <li><a href="#support">如何支持多种屏幕</a>
      <ol>
        <li><a href="#qualifiers">使用配置限定符</a></li>
        <li><a href="#DesigningResources">设计替代布局和可绘制对象</a></li>
      </ol></li>
    <li><a href="#DeclaringTabletLayouts">声明适用于 Android 3.2 的平板电脑布局</a>
      <ol>
        <li><a href="#NewQualifiers">使用新尺寸限定符</a></li>
        <li><a href="#ConfigurationExamples">配置示例</a></li>
        <li><a href="#DeclaringScreenSizeSupport">声明屏幕尺寸支持</a></li>
      </ol></li>
    <li><a href="#screen-independence">最佳做法</a></li>
    <li><a href="#DensityConsiderations">其他密度注意事项</a>
      <ol>
        <li><a href="#scaling">缩放运行时创建的位图对象</a></li>
        <li><a href="#dips-pels">将 dp 单位转换为像素单位</a></li>
      </ol></li>
    <li><a href="#testing">如何在多个屏幕上测试您的应用</a></li>
  </ol>

  <h2>相关示例</h2>
  <ol>
    <li><a href="https://developer.android.com/resources/samples/MultiResolution/index.html">多种分辨率</a>
</li>
  </ol>

  <h2>另请参阅</h2>
  <ol>
    <li><a href="http://android-developers.blogspot.com/2011/09/thinking-like-web-designer.html">视同 Web Designer</a>
</li>
    <li><a href="https://developer.android.com/guide/topics/resources/providing-resources.html#AlternativeResources">提供备用资源</a>
</li>
    <li><a href="https://developer.android.com/guide/practices/ui_guidelines/icon_design.html">图标设计指南</a>
</li>
    <li><a href="https://developer.android.com/tools/devices/index.html">管理虚拟设备</a></li>
  </ol>

</div>
</div>

<p>Android 可在各种具有不同屏幕尺寸和密度的设备上运行。对于应用，Android 系统在不同设备中提供一致的开发环境，可以处理大多数工作，将每个应用的用户界面调整为适应其显示的屏幕。


同时，系统提供 API，可用于控制应用适用于特定屏幕尺寸和密度的 UI，以针对不同屏幕配置优化 UI 设计。

例如，您可能想要不同于手机 UI 的平板电脑 UI。
</p>

<p>虽然系统为使您的应用适用于不同的屏幕，会进行缩放和大小调整，但您应针对不同的屏幕尺寸和密度优化应用。

这样可以最大程度优化所有设备上的用户体验，用户会
认为您的应用实际上是专为<em>他们的</em>设备而设计，而不是
简单地拉伸以适应其设备屏幕。</p>

<p>按照本文档所述的做法，您可以创建
正常显示的应用，然后使用
一个 <code>.apk</code> 文件在所有支持的屏幕配置中提供优化的用户体验。</p>

<p class="note"><strong>注</strong>：本文档中的信息假设您的
应用设计用于 Android 1.6（API 级别 4）或更高级别。如果您的应用只支持
Android 1.5 或更低版本，请先阅读<a href="https://developer.android.com/guide/practices/screens-support-1.5.html">适用于 Android 1.5 的策略</a>。
<br><br>
另请注意，<strong>Android 3.2 引入了新的 API</strong>，可用于更
精确地控制应用用于不同屏幕尺寸的布局资源。如果您要开发针对平板电脑优化的应用，这些新
功能特别重要。
有关详情，请参阅<a href="#DeclaringTabletLayouts">声明
Android 3.2 的平板电脑布局</a>相关章节。
</p>



<h2 id="overview" style="padding-bottom: 0px;">屏幕支持概览</h2><hr>

<p>本节概述 Android 对多种屏幕的支持，包括：
本文档和 API 中所用术语和概述的简介、
系统支持的屏幕配置摘要，以及 API 和基本
屏幕兼容性功能的概述。</p>

<h3 id="terms">术语和概念</h3>

<dl>
<dt><em>屏幕尺寸</em></dt>
  <dd>按屏幕对角测量的实际物理尺寸。

  <p>为简便起见，Android 将所有实际屏幕尺寸分组为四种通用尺寸：小、
正常、大和超大。</p></dd>

<dt><em>屏幕密度</em></dt>
  <dd>屏幕物理区域中的像素量；通常称为 dpi（每英寸
点数）。例如，
与“正常”或“高”密度屏幕相比，“低”密度屏幕在给定物理区域的像素较少。<p></p>

  <p>为简便起见，Android 将所有屏幕密度分组为六种通用密度：
低、中、高、超高、超超高和超超超高。</p></dd>

<dt><em>方向</em></dt>
  <dd>从用户视角看屏幕的方向，即横屏还是
竖屏，分别表示屏幕的纵横比是宽还是高。请注意，
不仅不同的设备默认以不同的方向操作，而且
方向在运行时可随着用户旋转设备而改变。
</dd>

<dt><em>分辨率</em></dt>
  <dd>屏幕上物理像素的总数。添加对多种屏幕的支持时，
应用不会直接使用分辨率；而只应关注通用尺寸和密度组指定的屏幕
尺寸及密度。</dd>

<dt><em>密度无关像素 (dp)</em></dt>
  <dd>在定义 UI 布局时应使用的虚拟像素单位，用于以密度无关方式表示布局维度
或位置。
  <p>密度无关像素等于 160 dpi 屏幕上的一个物理像素，这是
系统为“中”密度屏幕假设的基线密度。在运行时，系统
根据使用中屏幕的实际密度按需要以透明方式处理 dp 单位的任何缩放
。dp 单位转换为屏幕像素很简单：
<nobr><code>px = dp * (dpi / 160)</code></nobr>。
例如，在 240 dpi 屏幕上，1 dp 等于 1.5 物理像素。在定义应用的 UI 时应始终使用 dp 单位
，以确保在不同密度的屏幕上正常显示 UI。
 </p></dd>
</dl>


<h3 id="range">支持的屏幕范围</h3>

<p>从 Android 1.6（API 级别 4）开始，Android 支持多种屏幕尺寸和密度，反映设备可能具有的多种不同屏幕配置。
您可以使用
Android 系统的功能优化应用在各种屏幕配置下的用户界面
，确保应用不仅正常渲染，而且在每个屏幕上提供
最佳的用户体验。</p>

<p>为简化您为多种屏幕设计用户界面的方式，Android 将实际屏幕尺寸和密度的范围
分为：</p>

<ul>
<li>四种通用<strong>尺寸</strong>：<em>小</em>、<em>正常</em>、
<em>大</em>
和<em>超大</em>
<p class="note"><strong>注</strong>：从 Android 3.2（API 级别 13）开始，这些尺寸组
已弃用，而采用根据可用屏幕宽度管理屏幕尺寸的
新技术。如果为 Android 3.2 和更高版本开发，请参阅<a href="#DeclaringTabletLayouts">声明适用于 Android 3.2 的平板电脑布局</a>以了解更多信息。
</p>
</li>
<li>六种通用的<strong>密度</strong>：
  <ul>
    <li><em>ldpi</em>（低）~120dpi</li>
    <li><em>mdpi</em>（中）~160dpi</li>
    <li><em>hdpi</em>（高）~240dpi</li>
    <li><em>xhdpi</em>（超高）~320dpi</li>
    <li><em>xxhdpi</em>（超超高）~480dpi</li>
    <li><em>xxxhdpi</em>（超超超高）~640dpi</li>
  </ul>
</li>
</ul>

<p>通用的尺寸和密度按照基线配置（即<em>正常</em>尺寸和 <em>mdpi</em>（中）密度）排列。
此基线基于第一代 Android 设备 (T-Mobile
G1) 的屏幕配置，该设备采用 HVGA 屏幕（在 Android 1.6 之前，这是 Android
支持的唯一屏幕配置）。
</p>

<p>每种通用的尺寸和密度都涵盖一个实际屏幕尺寸和密度范围。例如，
两部都报告<em>正常</em>屏幕尺寸的设备在手动测量时，实际屏幕尺寸和
高宽比可能略有不同。类似地，对于两台报告
 <em>hdpi</em> 屏幕密度的设备，其实际像素密度可能略有不同。
Android 将这些差异抽象概括到应用，使您可以提供为通用尺寸和密度设计的 UI，让系统按需要处理任何最终调整。
图 1 说明不同的尺寸和密度如何粗略归类为不同的尺寸
和密度组。
</p>

<img src="https://developer.android.com/images/screens_support/screens-ranges.png" style="padding:1em 0 0" alt="">
<p class="img-caption"><strong>图 1.</strong>
说明 Android 如何将实际尺寸和密度粗略地
对应到通用的尺寸和密度（数据并不精确）。</p>

<p>在为不同的屏幕尺寸设计 UI 时，您会发现每种设计都需要
最小空间。因此，上述每种通用的屏幕尺寸都关联了系统定义的最低
分辨率。这些最小尺寸以“dp”单位表示 — 在定义布局时应使用相同的单位 — 这样系统无需担心屏幕密度的变化。

</p>

<ul>
  <li><em>超大</em>屏幕至少为 960dp x 720dp</li>
  <li><em>大</em>屏幕至少为 640dp x 480dp</li>
  <li><em>正常</em>屏幕至少为 470dp x 320dp</li>
  <li><em>小</em>屏幕至少为 426dp x 320dp</li>
</ul>

<p class="note"><strong>注</strong>：这些最小屏幕尺寸在
Android 3.0 之前未正确定义，因此某些设备在正常屏幕与大屏幕之间变换时可能会出现分类错误的情况。
这些尺寸还基于屏幕的物理分辨率，因此设备之间可能不同 — 例如，具有系统状态栏的 1024x720 平板电脑因系统状态栏要占用空间，所以可供
应用使用的空间要小一点。
</p>

<p>要针对不同的屏幕尺寸和密度优化应用的 UI，可为任何通用的尺寸和密度提供<a href="https://developer.android.com/guide/topics/resources/providing-resources.html#AlternativeResources">备用资源</a>。

通常，应为某些不同的屏幕尺寸提供替代布局，为不同的屏幕密度提供替代位图图像。

在运行时，系统会根据当前设备屏幕的通用
尺寸或密度对应用使用适当的资源。</p>

<p>无需为屏幕尺寸和
密度的每个组合提供备用资源。系统提供强大的兼容性功能，可处理在任何设备屏幕上
渲染应用的大多数工作，前提是您已经使用
可以适当调整大小的技术实现 UI（如下面的<a href="#screen-independence">最佳做法</a>所述）。</p>

<p class="note"><strong>注</strong>：定义设备通用屏幕
尺寸和密度的特性相互独立。例如，WVGA 高密度屏幕
被视为正常尺寸屏幕，因为其物理尺寸与 T-Mobile G1
（Android 的第一代设备和基线屏幕配置）大约相同。另一方面，WVGA 中密度
屏幕被视为大尺寸屏幕。虽然它提供相同的分辨率（相同的
像素数），但 WVGA 中密度屏幕的屏幕密度更低，意味着每个像素
实际上更大，因此整个屏幕大于基线（正常尺寸）屏幕。</p>



<h3 id="density-independence">密度独立性</h3>

<p>应用显示在密度不同的屏幕上时，如果它保持用户界面元素的物理尺寸（从
用户的视角），便可实现“密度独立性”
。</p>

<p>保持密度独立性很重要，因为如果没有此功能，UI 元素（例如
按钮）在低密度屏幕上看起来较大，在高密度屏幕上看起来较小。这些
密度相关的大小变化可能给应用布局和易用性带来问题。图 2
和 3 分别显示了应用不提供密度独立性和
提供密度独立性时的差异。</p>

<img src="https://developer.android.com/images/screens_support/density-test-bad.png" alt="">
<p class="img-caption"><strong>图 2.</strong> 不支持不同密度的示例应用在低、中、高密度屏幕上的显示情况。
</p>

<img src="https://developer.android.com/images/screens_support/density-test-good.png" alt="">
<p class="img-caption"><strong>图 3.</strong> 良好支持不同密度（密度独立）的示例应用在低、中、高密度屏幕上的显示情况。

</p>

<p>Android 系统可帮助您的应用以两种方式实现密度独立性： </p>

<ul>
<li>系统根据当前屏幕密度扩展 dp 单位数</li>
<li>系统在必要时可根据当前屏幕
密度将可绘制对象资源扩展到适当的大小</li>
</ul>

<p>在图 2 中，文本视图和位图可绘制对象具有以像素（<code>px</code>
单位）指定的尺寸，因此视图的物理尺寸在低密度屏幕上更大，在高密度
屏幕上更小。这是因为，虽然实际屏幕尺寸可能相同，但高密度屏幕
的每英寸像素更多（同样多的像素在一个更小的区域内）。在图 3 中，布局
尺寸以密度独立的像素（<code>dp</code> 单位）指定。由于
密度独立像素的基线是中密度屏幕，因此具有中密度屏幕的设备看起来
与图 2 一样。但对于低密度和高密度屏幕，系统
将分别增加和减少密度独立像素值，以适应
屏幕。</p>

<p>大多数情况下，确保应用中的屏幕独立性很简单，只需以适当的密度独立像素（<code>dp</code> 单位）或 <code>"wrap_content"</code> 指定所有
布局尺寸值。系统然后根据适用于当前屏幕密度的缩放比例适当地缩放位图可绘制对象，以
适当的大小显示。
</p>

<p>但位图缩放可能导致模糊或像素化位图，您或许已经在上面的屏幕截图中
发现了这些问题。为避免这些伪影，应为
不同的密度提供替代的位图资源。例如，应为高密度
屏幕提供分辨率较高的位图，然后系统对中密度
屏幕将使用这些位图，而无需调整位图大小。下一节详细说明如何为
不同的屏幕配置提供备用资源。</p>



<h2 id="support" style="padding-bottom: 0px;">如何支持多种屏幕</h2><hr>

<p>Android 支持多种屏幕的基础是它能够管理针对当前屏幕配置
以适当方式渲染应用的布局和位图
可绘制对象。系统可处理大多数工作，通过适当地
缩放布局以适应屏幕尺寸/密度和根据屏幕密度缩放位图可绘制对象
，在每种屏幕配置中渲染您的应用。但是，为了更适当地处理不同的屏幕配置
，还应该：</p>

<ul>
  <li><strong>在清单中显式声明您的应用
支持哪些屏幕尺寸</strong>
    <p>通过声明您的应用支持哪些屏幕尺寸，可确保只有
其屏幕受支持的设备才能下载您的应用。声明对
不同屏幕尺寸的支持也可影响系统如何在较大
屏幕上绘制您的应用 — 特别是，您的应用是否在<a href="https://developer.android.com/guide/practices/screen-compat-mode.html">屏幕兼容模式</a>中运行。</p>
    <p>要声明应用支持的屏幕尺寸，应在清单文件中包含
<a href="https://developer.android.com/guide/topics/manifest/supports-screens-element.html"><code>&lt;supports-screens&gt;</code></a> 元素。</p>
  </li>

  <li><strong>为不同屏幕尺寸提供不同的布局</strong>
    <p>默认情况下，Android 会调整应用布局的大小以适应当前设备屏幕。大多数
情况下效果很好。但有时 UI 可能看起来不太好，需要针对
不同的屏幕尺寸进行调整。例如，在较大屏幕上，您可能要调整
某些元素的位置和大小，以利用其他屏幕空间，或者在较小屏幕上，
可能需要调整大小以使所有内容纳入屏幕。</p>
    <p>可用于提供尺寸特定资源的配置限定符包括
<code>small</code>、<code>normal</code>、<code>large</code> 和 <code>xlarge</code>。例如，超大屏幕的布局应使用 <code>layout-xlarge/</code>。
</p>
    <p>从 Android 3.2（API 级别 13）开始，以上尺寸组已弃用，您
应改为使用 <code>sw&lt;N&gt;dp</code> 配置限定符来定义布局资源
可用的最小宽度。例如，如果多窗格平板电脑布局
需要至少 600dp 的屏幕宽度，应将其放在 <code>layout-sw600dp/</code> 中。<a href="#DeclaringTabletLayouts">声明适用于 Android 3.2 的平板电脑布局</a>一节将进一步讨论如何使用新技术声明布局资源。
</p>
  </li>

  <li><strong>为不同屏幕密度提供不同的位图可绘制对象</strong>
    <p>默认情况下，Android 会缩放位图可绘制对象（<code>.png</code>、<code>.jpg</code> 和 <code>.gif</code> 文件）和九宫格可绘制对象（<code>.9.png</code> 文件），使它们以适当的
物理尺寸显示在每部设备上。例如，如果您的应用只为
基线中密度屏幕 (mdpi) 提供位图可绘制对象，则在高密度
屏幕上会增大位图，在低密度屏幕上会缩小位图。这种缩放可能在
位图中造成伪影。为确保位图的最佳显示效果，应针对
不同屏幕密度加入不同分辨率的替代版本。</p>
    <p>可用于密度特定资源的<a href="#qualifiers">配置限定符</a>（在下面详述）
包括 <code>ldpi</code>（低）、<code>mdpi</code>（中）、
<code>hdpi</code>（高）、<code>xhdpi</code>（超高）、<code>xxhdpi</code>
（超超高）和 <code>xxxhdpi</code>（超超超高）。例如，高密度屏幕的位图应使用 <code>drawable-hdpi/</code>。
</p>
    <p class="note" id="xxxhdpi-note"><strong>注</strong>：仅当要在 
xxhdpi 设备上提供比正常位图大的启动器图标时才需要提供 <code>mipmap-xxxhdpi</code>
限定符。无需为所有应用的图像提供 xxxhdpi 资源。</p>
    <p>有些设备会将启动器图标增大 25%。例如，如果您的最高
密度启动器图标已是超超高密度，缩放处理会降低其
清晰度。因此应在
<code>mipmap-xxxhdpi</code> 目录中提供更高密度的启动器图标，系统将改为增大较小
的图标。</p>
    <p>请参阅<a href="https://developer.android.com/design/style/iconography.html#xxxhdpi-launcher">提供
xxx-高密度启动器图标</a>以了解详细信息。对启动程序图标以外的 UI 元素不应使用
<code>xxxhdpi</code> 限定符。</p>
  </li>
</ul>

<p class="note"><strong>注</strong>：将您的所有启动器图标放在
<code>res/mipmap-[density]/</code> 文件夹中，而非 <code>res/drawable-[density]/</code>
文件夹中。无论安装应用的设备屏幕分辨率如何，Android 系统都会将资源保留在这些密度特定的文件夹中，例如
mipmap-xxxhdpi。此
行为可让启动器应用为您的应用选择要显示在主
屏幕上的最佳分辨率图标。如需了解有关使用 mipmap
文件夹的详细信息，请参阅<a href="https://developer.android.com/tools/projects/index.html#mipmap">管理项目概览</a>。
</p>


<p>尺寸和密度配置限定符对应于
前面<a href="#range">支持的屏幕范围</a>中所述的通用尺寸和密度。</p>

<p class="note"><strong>注</strong>：如果不熟悉配置限定符以及
系统如何使用它们来应用备用资源，请参阅<a href="https://developer.android.com/guide/topics/resources/providing-resources.html#AlternativeResources">提供备用资源</a>了解详细信息。
</p>

<p>在运行时，系统通过
以下程序确保任何给定资源在当前屏幕上都能保持尽可能最佳的显示效果：</p>

<ol>
<li>系统使用适当的备用资源
  <p>根据当前屏幕的尺寸和密度，系统将使用您的应用中提供的任何尺寸和
密度特定资源。例如，如果设备有
高密度屏幕，并且应用请求可绘制对象资源，系统将查找
与设备配置最匹配的可绘制对象资源目录。根据可用的其他
备用资源，包含 <code>hdpi</code> 限定符（例如
<code>drawable-hdpi/</code>）的资源目录可能是最佳匹配项，因此系统将使用此
目录中的可绘制对象资源。</p>
</li>

<li>如果没有匹配的资源，系统将使用默认资源，并按需要向上
或向下扩展，以匹配当前的屏幕尺寸和密度。
  <p>“默认”资源是指未标记配置限定符的资源。例如，<code>drawable/</code> 中的资源是默认可绘制资源。
系统假设默认资源设计用于基线屏幕尺寸和密度，即
正常屏幕尺寸和中密度。
因此，系统对于高密度屏幕向上扩展默认密度
资源，对于低密度屏幕向下扩展。</p>
  <p>当系统查找密度特定的资源但在
密度特定目录中未找到时，不一定会使用默认资源。系统在缩放时可能
改用其他密度特定资源提供更好的
效果。例如，查找低密度资源但该资源不可用时，
系统会缩小资源的高密度版本，因为
系统可轻松以 0.5 为系数将高密度资源缩小至低密度资源，与以 0.75 为系数
缩小中密度资源相比，伪影更少。</p>
</li>
</ol>

  <p>如需有关 Android 如何通过使配置限定符与设备配置匹配来选择备用资源的更多信息，请参阅<a href="https://developer.android.com/guide/topics/resources/providing-resources.html#BestMatch">Android 如何查找最佳匹配资源</a>。


</p>




<h3 id="qualifiers">使用配置限定符</h3>

<p>Android 支持多种配置限定符，可让您控制系统
如何根据当前设备屏幕的特性选择备用资源。配置限定符是可以附加到 Android
项目中资源目录的字符串，用于指定在其中设计资源的配置。
</p>

<p>要使用配置限定符：</p>
<ol>
  <li>在项目的 <code>res/</code> 目录中新建一个目录，并使用以下
格式命名： <nobr><code>&lt;resources_name&gt;-&lt;qualifier&gt;</code></nobr>
    <ul>
      <li><code>&lt;resources_name&gt;</code> 是标准资源名称（例如 <code>drawable</code> 或
<code>layout</code>）。</li>
      <li><code>&lt;qualifier&gt;</code> 是下表 1 中的配置限定符，用于指定
要使用这些资源的屏幕配置（例如 <code>hdpi</code> 或 <code>xlarge</code>）。</li>
    </ul>
    <p>您可以一次使用多个 <code>&lt;qualifier&gt;</code> — 只需使用短划线分隔每个
限定符。</p>
  </li>
  <li>将适当的配置特定资源保存在此新目录下。这些资源
文件的名称必须与默认资源文件完全一样。</li>
</ol>

<p>例如，<code>xlarge</code> 是超大屏幕的配置限定符。将
此字符串附加到资源目录名称（例如 <code>layout-xlarge</code>）时，它指向
要在具有超大屏幕的设备上使用这些资源的系统。</p>

<p class="table-caption"><strong>表 1.</strong> 可用于为
不同屏幕配置提供特殊资源的配置限定符。</p>

<table>
<tbody><tr>
<th>屏幕特性</th>
<th>限定符</th>
<th>说明</th>
</tr>

<tr>
  <td rowspan="4">尺寸</td>
  <td><code>small</code></td>
  <td>适用于<em>小</em>尺寸屏幕的资源。</td>
</tr>
<tr>
  <td><code>normal</code></td>
  <td>适用于<em>正常</em>尺寸屏幕的资源。（这是基线尺寸。）</td>
</tr>
<tr>
<td><code>large</code></td>
<td>适用于<em>大</em>尺寸屏幕的资源。</td>
</tr>
<tr>
<td><code>xlarge</code></td>
<td>适用于<em>超大</em>尺寸屏幕的资源。</td>
</tr>

<tr>
<td rowspan="8">密度</td>
<td><code>ldpi</code></td>
<td>适用于低密度 (<em>ldpi</em>) 屏幕 (~120dpi) 的资源。</td>
</tr>
<tr>
<td><code>mdpi</code></td>
<td>适用于中密度 (<em>mdpi</em>) 屏幕 (~160dpi) 的资源。（这是基线
密度。）</td>
</tr>
<tr>
<td><code>hdpi</code></td>
<td>适用于高密度 (<em>hdpi</em>) 屏幕 (~240dpi) 的资源。</td>
</tr>
<tr>
<td><code>xhdpi</code></td>
<td>适用于超高密度 (<em>xhdpi</em>) 屏幕 (~320dpi) 的资源。</td>
</tr>
<tr><td><code>xxhdpi</code></td>
<td>适用于超超高密度 (<em>xxhdpi</em>) 屏幕 (~480dpi) 的资源。</td>
</tr>
<tr><td><code>xxxhdpi</code></td>
<td>适用于超超超高密度 (<em>xxxhdpi</em>) 屏幕 (~640dpi) 的资源。此限定符仅适用于
启动器图标，请参阅上面的<a href="#xxxhdpi-note">注</a>。</td>
</tr>
<tr>
<td><code>nodpi</code></td>
<td>适用于所有密度的资源。这些是密度独立的资源。不管当前屏幕的密度如何，系统都不会
缩放以此限定符标记的资源。</td>
</tr>
<tr>
<td><code>tvdpi</code></td>
<td>适用于密度介于 mdpi 和 hdpi 之间屏幕（约为 213dpi）的资源。它并不是
“主要”密度组，主要用于电视，而大多数应用都不
需要它 — 对于大多数应用而言，提供 mdpi 和 hdpi 资源便已足够，系统将根据需要对其进行
缩放。如果发现必须提供 tvdpi 资源，应以 1.33*mdpi 的系数
调整其大小。例如，mdpi 屏幕的 100px x 100px 图像应该相当于 tvdpi 的 133px x
133px。</td>
</tr>
<tr>
<td rowspan="2">方向</td>
<td><code>land</code></td>
<td>适用于横屏（长宽比）的资源。</td>
</tr>
<tr>
<td><code>port</code></td>
<td>适用于竖屏（高宽比）的资源。</td>
</tr>

<tr>
<td rowspan="2">纵横比</td>
<td><code>long</code></td>
<td>适用于纵横比明显高于或宽于（分别在竖屏
或横屏时）基线屏幕配置的屏幕的资源。</td>
</tr>
<tr>
<td><code>notlong</code></td>
<td>适用于使用纵横比类似于基线屏幕
配置的屏幕的资源。</td>
</tr>
</tbody></table>

<p class="note"><strong>注：</strong>如果是为 Android 3.2 和
更高版本开发应用，请参阅有关<a href="#DeclaringTabletLayouts">声明适用于 Android 3.2 的平板电脑布局</a>的章节，了解
在为特定屏幕尺寸声明布局资源时应使用的
新配置限定符（而不是使用表 1 中的尺寸限定符）。</p><p></p>

<p>如需了解有关这些限定符如何粗略地对应于实际屏幕
尺寸和密度的更多信息，请参阅本文档前面的<a href="#range">支持的屏幕范围</a>
。</p>

<p>例如，以下应用资源目录
为不同屏幕尺寸和不同可绘制对象提供不同的布局设计。使用 <code>mipmap/</code> 文件夹放置
启动器图标。</p>

<pre class="classic prettyprint"><span class="pln">res</span><span class="pun">/</span><span class="pln">layout</span><span class="pun">/</span><span class="pln">my_layout</span><span class="pun">.</span><span class="pln">xml &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span><span class="com">// layout for normal screen size ("default")</span><span class="pln"><br>res</span><span class="pun">/</span><span class="pln">layout</span><span class="pun">-</span><span class="pln">large</span><span class="pun">/</span><span class="pln">my_layout</span><span class="pun">.</span><span class="pln">xml &nbsp; &nbsp; &nbsp; &nbsp;</span><span class="com">// layout for large screen size</span><span class="pln"><br>res</span><span class="pun">/</span><span class="pln">layout</span><span class="pun">-</span><span class="pln">xlarge</span><span class="pun">/</span><span class="pln">my_layout</span><span class="pun">.</span><span class="pln">xml &nbsp; &nbsp; &nbsp; </span><span class="com">// layout for extra-large screen size</span><span class="pln"><br>res</span><span class="pun">/</span><span class="pln">layout</span><span class="pun">-</span><span class="pln">xlarge</span><span class="pun">-</span><span class="pln">land</span><span class="pun">/</span><span class="pln">my_layout</span><span class="pun">.</span><span class="pln">xml &nbsp;</span><span class="com">// layout for extra-large in landscape orientation</span><span class="pln"><br><br>res</span><span class="pun">/</span><span class="pln">drawable</span><span class="pun">-</span><span class="pln">mdpi</span><span class="pun">/</span><span class="pln">graphic</span><span class="pun">.</span><span class="pln">png &nbsp; &nbsp; &nbsp; &nbsp; </span><span class="com">// bitmap for medium-density</span><span class="pln"><br>res</span><span class="pun">/</span><span class="pln">drawable</span><span class="pun">-</span><span class="pln">hdpi</span><span class="pun">/</span><span class="pln">graphic</span><span class="pun">.</span><span class="pln">png &nbsp; &nbsp; &nbsp; &nbsp; </span><span class="com">// bitmap for high-density</span><span class="pln"><br>res</span><span class="pun">/</span><span class="pln">drawable</span><span class="pun">-</span><span class="pln">xhdpi</span><span class="pun">/</span><span class="pln">graphic</span><span class="pun">.</span><span class="pln">png &nbsp; &nbsp; &nbsp; &nbsp;</span><span class="com">// bitmap for extra-high-density</span><span class="pln"><br>res</span><span class="pun">/</span><span class="pln">drawable</span><span class="pun">-</span><span class="pln">xxhdpi</span><span class="pun">/</span><span class="pln">graphic</span><span class="pun">.</span><span class="pln">png &nbsp; &nbsp; &nbsp; </span><span class="com">// bitmap for extra-extra-high-density</span><span class="pln"><br><br>res</span><span class="pun">/</span><span class="pln">mipmap</span><span class="pun">-</span><span class="pln">mdpi</span><span class="pun">/</span><span class="pln">my_icon</span><span class="pun">.</span><span class="pln">png &nbsp; &nbsp; &nbsp; &nbsp; </span><span class="com">// launcher icon for medium-density</span><span class="pln"><br>res</span><span class="pun">/</span><span class="pln">mipmap</span><span class="pun">-</span><span class="pln">hdpi</span><span class="pun">/</span><span class="pln">my_icon</span><span class="pun">.</span><span class="pln">png &nbsp; &nbsp; &nbsp; &nbsp; </span><span class="com">// launcher icon for high-density</span><span class="pln"><br>res</span><span class="pun">/</span><span class="pln">mipmap</span><span class="pun">-</span><span class="pln">xhdpi</span><span class="pun">/</span><span class="pln">my_icon</span><span class="pun">.</span><span class="pln">png &nbsp; &nbsp; &nbsp; &nbsp;</span><span class="com">// launcher icon for extra-high-density</span><span class="pln"><br>res</span><span class="pun">/</span><span class="pln">mipmap</span><span class="pun">-</span><span class="pln">xxhdpi</span><span class="pun">/</span><span class="pln">my_icon</span><span class="pun">.</span><span class="pln">png &nbsp; &nbsp; &nbsp; </span><span class="com">// launcher icon for extra-extra-high-density</span><span class="pln"><br>res</span><span class="pun">/</span><span class="pln">mipmap</span><span class="pun">-</span><span class="pln">xxxhdpi</span><span class="pun">/</span><span class="pln">my_icon</span><span class="pun">.</span><span class="pln">png &nbsp; &nbsp; &nbsp;</span><span class="com">// launcher icon for extra-extra-extra-high-density</span></pre>

<p>如需了解如何使用备用资源的更多信息以及
配置限定符的完整列表（不只是屏幕配置），请参阅
<a href="https://developer.android.com/guide/topics/resources/providing-resources.html#AlternativeResources">
提供备用资源</a>。</p>

<p>请注意，当 Android 系统在运行时选择使用哪些资源时，它会使用
特定逻辑确定“最佳匹配”资源。也就是说，您使用的限定符无
需在所有情况下精确匹配当前屏幕配置，系统也可
使用它们。特别是，根据屏幕尺寸限定符选择资源时，如果没有更好的匹配资源，则系统将
使用专为小于当前屏幕的屏幕而设计的
资源（例如，如有必要，大尺寸屏幕将使用标准尺寸的屏幕
资源）。但是，如果唯一可用的资源<em>大</em>于当前屏幕，
则系统不会使用这些资源，并且如果没有其他资源与设备
配置匹配，应用将会崩溃（例如，如果所有布局资源均用 <code>xlarge</code> 限定符标记，
但设备是标准尺寸的屏幕）。如需有关系统如何选择资源的更多信息，请参阅<a href="https://developer.android.com/guide/topics/resources/providing-resources.html#BestMatch">Android 如何查找最佳匹配资源</a>。

</p>

  <p class="note"><strong>提示：</strong>如果您有一些系统
应该永远不会缩放（或许是因为您在
运行时亲自对图像做一些调整）的可绘制对象资源，则应将它们放在有 <code>nodpi</code> 配置限定符的目录中。
使用此限定符的资源被视为与密度无关，系统不会缩放
它们。</p>


<h3 id="DesigningResources">设计替代布局和可绘制对象</h3>

<p>您应该创建的备用资源类型取决于应用的需求。
通常，您应该使用尺寸和方向限定符提供替代布局资源
，并且使用密度限定符提供替代位图可绘制对象资源。</p>

<p>以下各节摘要说明您可能要如何使用尺寸和密度限定符
来分别提供替代布局和可绘制对象。</p>


<h4>替代布局</h4>

<p>一般而言，在不同的屏幕配置上测试应用后，您会知道
是否需要用于不同屏幕尺寸的替代布局。例如：</p>

<ul>
  <li>在小屏幕上测试时，可能会发现您的布局不太适合
屏幕。例如，小屏幕设备的屏幕宽度可能无法容纳一排
按钮。在此情况下，您应该为小屏幕提供调整
按钮大小或位置的替代布局。</li>
  <li>在超大屏幕上测试时，可能会发现您的布局无法
有效地利用大屏幕，并且明显拉伸填满屏幕。
在此情况下，您应该为超大屏幕提供替代布局，以提供
针对大屏幕（例如平板电脑）优化、重新设计的 UI。
    <p>虽然您的应用不使用替代布局也能在大屏幕上正常运行，但
必须让用户感觉您的应用看起来像是专为其
设备而设计。如果 UI 明显拉伸，用户很可能对
应用体验不满意。</p></li>
  <li>而且，对比横屏测试和竖屏测试时
可能会发现，竖屏时置于底部的 UI
在横屏时应位于屏幕右侧。</li>
</ul>

<p>简而言之，您应确保应用布局：</p>
<ul>
  <li>适应小屏幕（让用户能实际使用您的应用）</li>
  <li>已针对大屏幕优化，可以利用其他屏幕空间</li>
  <li>已同时针对横屏和竖屏方向优化</li>
</ul>

<p>如果 UI 使用的位图即使在系统缩放
布局后也需要适应视图大小（例如按钮的背景图片），则应使用<a href="https://developer.android.com/guide/topics/graphics/2d-graphics.html#nine-patch">九宫格</a>位图文件。九宫格文件基本上是一个指定可拉伸的二维区域的 PNG 文件。

当系统需要缩放使用位图的视图时，系统
会拉伸九宫格位图，但只拉伸指定的区域。因此，您无
需为不同的屏幕尺寸提供不同的可绘制对象，因为九宫格位图可
调整至任何大小。但您应该为不同的屏幕密度提供
九宫格文件的替代版本。</p>


<h4>替代可绘制对象</h4>

<div class="figure" style="width:223px;margin:0">
<img src="https://developer.android.com/images/screens_support/screens-densities.png" alt="">
<p class="img-caption"><strong>图 4.</strong> 支持每种密度的
位图可绘制对象的相对大小。</p>
</div>

<p>基本上每个应用都应该具有不同密度的替代可绘制对象
资源，因为基本上每个应用都有启动器图标，而且该图标应该在
所有屏幕密度中看起来都很好。同样，如果您的应用中包含其他位图可绘制对象（例如
应用中的菜单图标或其他图形），则应该为不同密度提供替代版本或
每种密度一个版本。</p>

<p class="note"><strong>注：</strong>您只需要为
位图文件（<code>.png</code>、<code>.jpg</code> 或 <code>.gif</code>）和九宫格文件 (<code>.9.png</code>) 提供密度特定的可绘制对象。如果您使用 XML 文件定义形状、颜色或其他<a href="https://developer.android.com/guide/topics/resources/drawable-resource.html">可绘制对象资源</a>，应该
将一个副本放在默认可绘制对象目录中 (<code>drawable/</code>)。</p>

<p>要为不同的密度创建替代位图可绘制对象，应遵循六种通用密度之间的
<b>3:4:6:8:12:16 缩放比率</b>。例如，如果您的
位图可绘制对象是对中密度屏幕使用 48x48 像素，则所有不同的尺寸应为：
</p>

<ul>
  <li>36x36 (0.75x) 用于低密度</li>
  <li>48x48（1.0x 基线）用于中密度</li>
  <li>72x72 (1.5x) 用于高密度</li>
  <li>96x96 (2.0x) 用于超高密度</li>
  <li>144x144 (3.0x) 用于超超高密度</li>
  <li>192x192 (4.0x) 用于超超超高密度（仅限启动器图标；请参阅上面的
<a href="#xxxhdpi-note">注</a>）</li>
</ul>

<p>如需了解有关设计图标的更多信息，请参阅<a href="https://developer.android.com/guide/practices/ui_guidelines/icon_design.html">图标设计指南</a>，
其中包含各种位图可绘制对象（例如启动器图标、菜单
图标、状态栏图标、选项卡图标等）的大小信息。</p>




<h2 id="DeclaringTabletLayouts" style="padding-bottom: 0px;">声明适用于 Android 3.2 的平板电脑布局</h2><hr>

<p>对于第一代运行 Android 3.0 的平板电脑，声明平板电脑
的正确方式是将它们放在有 <code>xlarge</code> 配置限定符的目录（例如
 <code>res/layout-xlarge/</code>）中。为适应其他类型的平板电脑和屏幕
尺寸 — 特别是 7 英寸平板电脑 — Android 3.2 引入了为更具体的屏幕尺寸指定资源
的新方式。新技术基于布局需要的空间量
（例如 600dp 宽），而不是尝试让您的布局容纳通用化的尺寸组
（例如<em>大</em>或<em>超大</em>）。</p>

<p>使用通用化的尺寸组时，为 7 英寸平板电脑设计很棘手的原因在于，
7 英寸平板电脑在技术上与 5 英寸手机属于同一个组（<em>大</em>组）。虽然
这两种设备在尺寸上似乎很接近，但用于
应用 UI 的空间量明显不同，用户交互的方式也是如此。因此，7 英寸和 5 英寸
屏幕不一定使用相同的布局。为便于您为这两种屏幕提供不同的
布局，Android 现在允许您
根据实际适用于应用布局的宽度和/或高度指定布局资源（
以 dp 单位数指定）。</p>

<p>例如，在设计要用于平板电脑样式设备的布局之后，您可能
发现该布局在屏幕宽度小于 600dp 时不适用。此阈值
于是变成平板电脑布局需要的最小尺寸。因此，您现在可以指定应仅当至少有
600dp 宽度供应用的 UI 使用时才使用这些布局资源。
</p>

<p>应选择一个宽度并将其设计为最小尺寸，或者在布局设计完成后测试
其支持的最小宽度。</p>

<p class="note"><strong>注：</strong>请记住，这些新尺寸 API
使用的所有数据是密度独立的像素 (dp) 值，您的布局尺寸也应始终
使用 dp 单位定义，因为您关注的是系统
考虑屏幕密度后可用的屏幕空间量（与使用原始像素分辨率相反）。如需了解
密度独立像素的更多信息，请参阅本文档前面的<a href="#terms">术语和概念</a>
。</p>


<h3 id="NewQualifiers">使用新尺寸限定符</h3>

<p>表 2 摘要列出了您可以根据
布局可用空间指定的不同资源配置。与传统的屏幕尺寸组（小、
正常、大和超大）相比，这些新的限定符可用于更多地控制
应用支持的屏幕尺寸。</p>

<p class="note"><strong>注：</strong>您使用这些限定符指定的尺寸
<strong>不是实际屏幕尺寸</strong>。更确切地说，尺寸是
<strong>可用于 Activity 窗口</strong>的宽度或高度（dp 单位）。Android 系统
可能将某些屏幕用于系统 UI（例如屏幕底部的系统栏或
顶部的状态栏），因此有些屏幕可能不适用于您的布局。因此，
您声明的尺寸应与 Activity 需要的尺寸具体相关 — 系统
在声明向您的布局提供的空间量时会计算系统 UI 使用的任何空间。
另请注意，<a href="https://developer.android.com/guide/topics/ui/actionbar.html">操作栏</a>被视为
应用的窗口空间的一部分，但您的布局未声明此事，因此会减少
您的布局可用的空间，您在设计时必须考虑进去。</p>

<p class="table-caption"><strong>表 2.</strong> 屏幕尺寸的新配置限定符
（在 Android 3.2 中引入）。</p>
<table>
  <tbody><tr><th>屏幕配置</th><th>限定符值</th><th>说明</th></tr>
  <tr><td>smallestWidth</td>
      <td><code>sw&lt;N&gt;dp</code><br><br>
        示例：<br>
        <code>sw600dp</code><br>
        <code>sw720dp</code><br>
      </td>
      <td>
        <p>屏幕的基本尺寸，由可用屏幕区域的最小尺寸指定。
具体来说，设备的 smallestWidth
是屏幕可用高度和宽度的最小尺寸（您也可以将其视为屏幕的“最小可能宽度”）。无论屏幕的当前方向如何，您均可使用此限定符确保应用
UI 的可用宽度至少为
<code>&lt;N&gt;</code>dp。</p>
        <p>例如，如果布局要求屏幕区域的最小尺寸始终至少为
600 dp，则可使用此限定符创建布局资源 <code>res/layout-sw600dp/</code>。仅当可用屏幕的最小尺寸至少为
600dp 时，系统才会使用这些资源，而不考虑
600dp 所代表的边是用户所认为的高度还是宽度。smallestWidth 是设备的固定屏幕尺寸特性；<strong>设备的 smallestWidth 不会随屏幕方向的变化而改变</strong>。
</p>
  <p>设备的 smallestWidth 将屏幕装饰元素和系统 UI 考虑在内。例如，如果设备的屏幕上有一些永久性 UI 元素占据沿 smallestWidth 轴的空间，则系统会声明 smallestWidth 小于实际屏幕尺寸，因为这些屏幕像素不适用于您的 UI。


</p>
  <p>这可替代通用化的屏幕尺寸限定符（小、正常、大、超大），
可让您为 UI 可用的有效尺寸定义不连续的数值。
使用 smallestWidth 定义一般屏幕尺寸很有用，因为宽度
通常是设计布局时的驱动因素。UI 经常会垂直滚动，但
对其水平需要的最小空间具有非常硬性的限制。可用的宽度也是
确定是否对手机使用单窗格布局或是对平板电脑使用多窗格布局
的关键因素。因此，您可能最关注每部
设备上的最小可能宽度。</p>
    </td>
  </tr>
    <tr>
      <td>可用屏幕宽度</td>
      <td><code>w&lt;N&gt;dp</code><br><br>
        示例：<br>
        <code>w720dp</code><br>
        <code>w1024dp</code><br>
      </td>
      <td>
        <p>指定资源应该使用的最小可用宽度（dp 单位）
— 由 <code>&lt;N&gt;</code> 值定义。当屏幕的方向在横屏与竖屏之间切换时，系统对应的
宽度值将会变化，以
反映 UI 可用的当前实际宽度。</p>
        <p>这对于确定是否使用多窗格布局往往很有用，因为即使是在
平板电脑设备上，您也通常不希望竖屏像横屏一样
使用多窗格布局。因此，您可以使用此功能指定布局需要的最小宽度，而
无需同时使用屏幕尺寸和方向限定符。</p>
      </td>
    </tr>
    <tr>
      <td>可用屏幕高度</td>
      <td><code>h&lt;N&gt;dp</code><br><br>
        示例：<br>
        <code>h720dp</code><br>
        <code>h1024dp</code><br>
        等等
      </td>
      <td>
        <p>指定资源应该使用的最小屏幕高度（dp 单位）
— 由 <code>&lt;N&gt;</code> 值定义。当屏幕的方向在横屏与竖屏之间切换时，系统
对应的高度值将会变化，以
反映 UI 可用的当前实际高度。</p>
        <p>使用此方式定义
布局需要的高度很有用，它与使用 <code>w&lt;N&gt;dp</code> 定义
所需宽度的方式相同，无需同时使用屏幕尺寸和方向限定符。
但大多数应用不需要此限定符，考虑到 UI 经常垂直滚动，
因此高度更弹性，而宽度更刚性。</p>
      </td>
    </tr>
</tbody></table>

<p>虽然使用这些限定符似乎比使用屏幕尺寸组更复杂，但
当您确定 UI 的要求后，它实际上应该更简单。在设计 UI 时，
您主要关注的可能是应用在
手机样式 UI 与使用多窗格的平板电脑样式 UI 之间切换时的实际尺寸。此确切的精确时间
取决于特定设计 — 可能平板电脑布局需要 720dp 宽度，
但 600dp、480dp 或这两者之间的某个值就够了。使用表 2 中的这些限定符
可以控制布局切换时的精确尺寸。</p>

<p>如需有关这些尺寸配置限定符的更多讨论，请参阅<a href="https://developer.android.com/guide/topics/resources/providing-resources.html#SmallestScreenWidthQualifier">
提供资源</a>文档。</p>


<h3 id="ConfigurationExamples">配置示例</h3>

<p>为帮助您针对不同的设备类型确定某些设计，下面提供了一些
常见的屏幕宽度值：</p>

<ul>
  <li>320dp：常见手机屏幕（240x320 ldpi、320x480 mdpi、480x800 hdpi 等）。</li>
  <li>480dp：中间平板电脑，例如 Streak (480x800 mdpi)。</li>
  <li>600dp：7 英寸平板电脑 (600x1024 mdpi)。</li>
  <li>720dp：10 英寸平板电脑（720x1280 mdpi、800x1280 mdpi 等）。</li>
</ul>

<p>利用表 2 中的尺寸限定符，您的应用可以使用要用于宽度和/或高度的
的任何值，在用于手机和平板电脑的不同布局资源之间切换。例如，
如果 600dp 是平板电脑布局支持的最小可用宽度，您可以提供以下两
组布局：</p>

<pre class="classic prettyprint"><span class="pln">res</span><span class="pun">/</span><span class="pln">layout</span><span class="pun">/</span><span class="pln">main_activity</span><span class="pun">.</span><span class="pln">xml &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span><span class="com"># For handsets</span><span class="pln"><br>res</span><span class="pun">/</span><span class="pln">layout</span><span class="pun">-</span><span class="pln">sw600dp</span><span class="pun">/</span><span class="pln">main_activity</span><span class="pun">.</span><span class="pln">xml &nbsp; </span><span class="com"># For tablets</span></pre>

<p>在此情况下，可用屏幕空间的最小宽度必须是 600dp，才可
应用平板电脑布局。</p>

<p>对于要进一步自定义 UI 以区分不同尺寸
（例如 7 英寸和 10 英寸平板电脑）的其他情况，您可以定义其他最小宽度布局：</p>

<pre class="classic prettyprint"><span class="pln">res</span><span class="pun">/</span><span class="pln">layout</span><span class="pun">/</span><span class="pln">main_activity</span><span class="pun">.</span><span class="pln">xml &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span><span class="com"># For handsets (smaller than 600dp available width)</span><span class="pln"><br>res</span><span class="pun">/</span><span class="pln">layout</span><span class="pun">-</span><span class="pln">sw600dp</span><span class="pun">/</span><span class="pln">main_activity</span><span class="pun">.</span><span class="pln">xml &nbsp; </span><span class="com"># For 7” tablets (600dp wide and bigger)</span><span class="pln"><br>res</span><span class="pun">/</span><span class="pln">layout</span><span class="pun">-</span><span class="pln">sw720dp</span><span class="pun">/</span><span class="pln">main_activity</span><span class="pun">.</span><span class="pln">xml &nbsp; </span><span class="com"># For 10” tablets (720dp wide and bigger)</span></pre>

<p>请注意，上面两组示例资源使用“最小宽度”限定符 <code>sw&lt;N&gt;dp</code>，用于指定屏幕两边的最小值，而不管设备
当前的方向如何。因此，使用 <code>sw&lt;N&gt;dp</code> 是指定
布局可用于整体屏幕尺寸的简便方法，它会忽略屏幕的方向。</p>

<p>但在某些情况下，可能
必须确定布局<em>当前</em>可用的精确宽度或高度。例
如，如果是并排显示两个片段的双窗格布局，则只要
屏幕提供至少 600dp 的宽度（无论设备是横屏还是竖屏），
您可能就要使用该布局。在此情况下，您的资源可能与以下所示类似：</p>

<pre class="classic prettyprint"><span class="pln">res</span><span class="pun">/</span><span class="pln">layout</span><span class="pun">/</span><span class="pln">main_activity</span><span class="pun">.</span><span class="pln">xml &nbsp; &nbsp; &nbsp; &nbsp; </span><span class="com"># For handsets (smaller than 600dp available width)</span><span class="pln"><br>res</span><span class="pun">/</span><span class="pln">layout</span><span class="pun">-</span><span class="pln">w600dp</span><span class="pun">/</span><span class="pln">main_activity</span><span class="pun">.</span><span class="pln">xml &nbsp;</span><span class="com"># Multi-pane (any screen with 600dp available width or more)</span></pre>

<p>请注意，第二组使用“可用宽度”限定符 <code>w&lt;N&gt;dp</code>。这
样，一部设备可能实际使用两种布局，具体取决于屏幕的方向（如果
可用的宽度在一个方向上至少为 600dp，而在另一个方向上小于
600dp）。</p>

<p>如果您关注可用高度，便可使用 <code>h&lt;N&gt;dp</code> 限定符执行同样的操作。或者，如果您需要很具体，甚至可以结合 <code>w&lt;N&gt;dp</code> 与 <code>h&lt;N&gt;dp</code>
限定符。</p>


<h3 id="DeclaringScreenSizeSupport">声明屏幕尺寸支持</h3>

<p>在对不同的屏幕尺寸实现您的布局后，在
清单文件中声明您的应用支持哪些屏幕相当重要。</p>

<p>与用于屏幕尺寸的新配置限定符一起，Android 3.2 为
<a href="https://developer.android.com/guide/topics/manifest/supports-screens-element.html">&lt;supports-screens&gt;</a>
清单元素引入了新的属性：</p>

<dl>

  <dt><a href="https://developer.android.com/guide/topics/manifest/supports-screens-element.html#requiresSmallest">
<code>android:requiresSmallestWidthDp</code></a></dt>
  <dd>指定需要的最小 smallestWidth。smallestWidth 是必须为您的应用 UI 提供的
屏幕空间的最短尺寸（<code>dp</code> 单位）—即
可用屏幕的两个尺寸中的最短者。因此，为使设备
与您的应用兼容，设备的 smallestWidth 必须等于或大于此
值。（通常，无论屏幕的当前方向如何，
此值都是布局支持的“最小宽度”。）
  <p>例如，如果您的应用只用于最小可用宽度为 600dp
的平板电脑样式设备：</p>
<pre class="prettyprint"><span class="tag">&lt;manifest</span><span class="pln"> ... </span><span class="tag">&gt;</span><span class="pln"><br>&nbsp; &nbsp; </span><span class="tag">&lt;supports-screens</span><span class="pln"> </span><span class="atn">android:requiresSmallestWidthDp</span><span class="pun">=</span><span class="atv">"600"</span><span class="pln"> </span><span class="tag">/&gt;</span><span class="pln"><br>&nbsp; &nbsp; ...<br></span><span class="tag">&lt;/manifest&gt;</span></pre>
  <p>但是，如果您的应用支持 Android 支持的所有屏幕尺寸（小至
426dp x 320dp），则无需声明此属性，因为应用
需要的最小宽度就是任何设备上可以实现的最小宽度。</p>

  <p class="caution"><strong>注意：</strong>Android 系统不关注此
属性，因为它不影响应用在运行时的行为，而是被用于
在服务（例如 Google Play）上过滤您的应用。但是，
<strong>Google Play 目前不支持此属性用于过滤</strong>（在 Android
3.2 上），因此如果您的应用不支持
小屏幕，您应继续使用其他尺寸属性。</p>
</dd>

  <dt><a href="https://developer.android.com/guide/topics/manifest/supports-screens-element.html#compatibleWidth">
<code>android:compatibleWidthLimitDp</code></a></dt>
  <dd>此属性可让您指定用户支持的最大“最小宽度”，将<a href="https://developer.android.com/guide/practices/screen-compat-mode.html">屏幕兼容性模式</a>用作
用户可选的功能
。如果设备可用屏幕的最小边大于您在这里的值，
用户仍可安装您的应用，但提议在屏幕兼容性模式下运行。默认
情况下，屏幕兼容性模式会停用，并且您的布局照例会调整大小以
适应屏幕，但按钮会显示在系统栏中，可让用户打开和关闭屏幕兼容性
模式。
  <p class="note"><strong>注：</strong>如果您的应用可针对大
屏幕正确调整大小，则无需使用此属性。建议不要使用此
属性，而是按照本文档的
建议，确保您的布局针对较大屏幕调整大小。</p></dd>

  <dt><a href="https://developer.android.com/guide/topics/manifest/supports-screens-element.html#largestWidth">
<code>android:largestWidthLimitDp</code></a></dt>
  <dd>此属性可让您指定应用支持的最大“最小宽度”来强制启用<a href="https://developer.android.com/guide/practices/screen-compat-mode.html">屏幕兼容性模式</a>。
如果设备可用屏幕的最小
边大于您在这里的值，应用将在屏幕
兼容性模式下运行，且用户无法停用该模式。
  <p class="note"><strong>注：</strong>如果您的应用可针对大
屏幕正确调整大小，则无需使用此属性。建议不要使用此
属性，而是按照本文档的
建议，确保您的布局针对较大屏幕调整大小。</p></dd>
</dl>

<p class="caution"><strong>注意：</strong>针对 Android 3.2 及更高版本开发时，您
应改为将旧屏幕尺寸属性与上列
属性结合使用。同时使用新属性和旧尺寸属性可能导致
非预期的行为。</p>

<p>如需了解每个属性的更多信息，请跟随上面各自的链接。</p>




<h2 id="screen-independence" style="padding-bottom: 0px;">最佳做法</h2><hr>

<p>支持多种屏幕的目标是创建一款在 Android 系统支持的通用屏幕尺寸上都可以
正常运行且显示良好的应用。本文档
前面各节内容介绍了 Android 系统如何使您的
应用适应屏幕配置，以及如何在不同的
屏幕配置上自定义应用的外观。本节提供另外一些提示以及有助于
确保应用针对不同屏幕配置正确缩放的
技巧概览。</p>

<p>下面是有关如何确保应用在
不同屏幕上正常显示的快速检查清单：</p>

<ol>
  <li>在 XML 布局文件中指定尺寸时使用 <code>wrap_content</code>、<code>match_parent</code> 或 <code>dp</code> 单位
。</li>
  <li>不要在应用代码中使用硬编码的像素值</li>
  <li>不要使用 <code>AbsoluteLayout</code>（已弃用）</li>
  <li>为不同屏幕密度提供替代位图可绘制对象</li>
</ol>

<p>下文将提供更详细的信息。</p>


<h3 id="use-relative">1. 对布局尺寸使用 wrap_content、match_parent 或 dp 单位</h3>

<p>为 XML 布局文件中的视图定义 <a href="https://developer.android.com/reference/android/view/ViewGroup.LayoutParams.html#attr_android:layout_width"><code>android:layout_width</code></a> 和 <a href="https://developer.android.com/reference/android/view/ViewGroup.LayoutParams.html#attr_android:layout_height"><code>android:layout_height</code></a>
时，使用 <code>"wrap_content"</code>、
<code>"match_parent"</code> 或 <code>dp</code> 单位可确保在当前设备屏幕上为
视图提供适当的尺寸。</p>

<p>例如，<code>layout_width="100dp"</code> 的视图在
中密度屏幕上测出宽度为 100 像素，在高密度屏幕上系统会将其扩展至 150 像素宽，
因此视图在屏幕上占用的物理空间大约相同。</p>

<p>类似地，您应选择 <code>sp</code>（缩放独立的像素）来定义文本
大小。<code>sp</code> 缩放系数取决于用户设置，系统
会像处理 <code>dp</code> 一样缩放大小。</p>


<h3>2. 不要在应用代码中使用硬编码的像素值</h3>

<p>由于性能的原因和简化代码的需要，Android 系统使用像素作为
表示尺寸或坐标值的标准单位。这意味着，
视图的尺寸在代码中始终以像素表示，但始终基于当前的屏幕密度。
例如，如果 <code>myView.getWidth()</code> 返回 10，则表示视图在
当前屏幕上为 10 像素宽，但在更高密度的屏幕上，返回的值可能是 15。如果
在应用代码中使用像素值来处理预先未针对
当前屏幕密度缩放的位图，您可能需要缩放代码中使用的像素值，以与
未缩放的位图来源匹配。</p>

<p>如果应用在运行时操作位图或处理像素值，请参阅
下面有关<a href="#DensityConsiderations">其他密度注意事项</a>的一节。</p>


<h3 id="avoid-absolute">3. 不要使用 AbsoluteLayout </h3>

<p>与其他布局小工具不同，<code><a href="https://developer.android.com/reference/android/widget/AbsoluteLayout.html">AbsoluteLayout</a></code> 会强制
使用固定位置放置其子视图，很容易导致
在不同显示屏上显示效果不好的用户界面。因此，<code><a href="https://developer.android.com/reference/android/widget/AbsoluteLayout.html">AbsoluteLayout</a></code> 在
Android 1.5（API 级别 3）上便已弃用。</p>

<p>您应改用 <code><a href="https://developer.android.com/reference/android/widget/RelativeLayout.html">RelativeLayout</a></code>，它会使用相对定位
来放置其子视图。例如，您可以指定按钮小部件显示在文本小工具的“右边”。
</p>


<h3>4. 使用尺寸和密度特定资源</h3>

<p>虽然系统会根据当前屏幕
配置扩展布局，但您在不同的屏幕尺寸上可能要调整 UI，以及提供
针对不同密度优化的可绘制对象。这基本上是重申
本文档前面的信息。</p>

<p>如果需要精确控制应用在不同
屏幕配置上的外观，请在配置特定的
资源目录中调整您的布局和位图可绘制对象。例如，考虑要显示在
中密度和高密度屏幕上的图标。只需创建两种不同大小的图标
（例如中密度使用 100x100，高密度使用 150x150），然后使用适当的限定符
以适当的方向放置两个
变体：</p>

<pre class="classic prettyprint"><span class="pln">res</span><span class="pun">/</span><span class="pln">drawable</span><span class="pun">-</span><span class="pln">mdpi</span><span class="pun">/</span><span class="pln">icon</span><span class="pun">.</span><span class="pln">png &nbsp; </span><span class="com">//for medium-density screens</span><span class="pln"><br>res</span><span class="pun">/</span><span class="pln">drawable</span><span class="pun">-</span><span class="pln">hdpi</span><span class="pun">/</span><span class="pln">icon</span><span class="pun">.</span><span class="pln">png &nbsp; </span><span class="com">//for high-density screens</span></pre>

<p class="note"><strong>注：</strong>如果密度限定符在目录名称中未定义，
系统会假设该目录中的资源是针对基线中
密度而设计，对于其他密度将会适当地缩放。</p>

<p>如需了解有效配置限定符的更多信息，请参阅本文档前面的<a href="#qualifiers">使用
配置限定符</a>。</p>





<h2 id="DensityConsiderations" style="padding-bottom: 0px;">其他密度注意事项</h2><hr>

<p>本节详细说明 Android 如何在不同
屏幕密度上对位图可绘制对象执行缩放，以及如何进一步控制在不同密度屏幕上位图的绘制。
本节信息对大多数应用应该不怎么重要，除非您的
应用在不同屏幕密度上运行或
操控图形时遇到了问题。</p>

<p>为更好地了解在运行时
操控图形时如何支持多种密度，您应该先了解，系统通过以下方式帮助确保正确
缩放位图：</p>

<ol>
<li><em>资源（例如位图可绘制对象）的预缩放</em>

  <p>根据当前屏幕的密度，系统将使用您的应用中提供的任何尺寸或
密度特定资源，并且不加缩放而显示它们。如果没有可用于正确密度
的资源，系统将加载默认资源，并按需要向上或向下扩展，以
匹配当前屏幕的密度。系统假设默认资源（
没有配置限定符的目录中的资源）针对基线屏幕密度 (mdpi) 而设计，
除非它们加载自密度特定的资源目录。因此，系统
会执行预缩放，以将位图调整至适应当前屏幕
密度的大小。</p>

  <p>如果您请求预缩放的资源的尺寸，系统将返回
代表缩放<em>后</em>尺寸的值。例如，针对 mdpi 屏幕以 50x50 像素
设计的位图在 hdpi 屏幕上将扩展至 75x75 像素（如果没有
用于 hdpi 的备用资源），并且系统会这样报告大小。</p>

<p>有时您可能不希望 Android 预缩放
资源。避免预缩放最简单的方法是将资源放在
有 <code>nodpi</code> 配置限定符的资源目录中。例如：</p>

<pre class="classic prettyprint"><span class="pln">res</span><span class="pun">/</span><span class="pln">drawable</span><span class="pun">-</span><span class="pln">nodpi</span><span class="pun">/</span><span class="pln">icon</span><span class="pun">.</span><span class="pln">png</span></pre>

<p>当系统使用此文件夹中的 <code>icon.png</code> 位图时，不会
根据当前设备密度缩放。</p>
</li>

<li><em>像素尺寸和坐标的自动缩放</em>

  <p>应用可通过在清单中将 <a href="https://developer.android.com/guide/topics/manifest/supports-screens-element.html#any"><code>android:anyDensity</code></a> 设置为 <code>"false"</code> 或者通过将 <code><a href="https://developer.android.com/reference/android/graphics/BitmapFactory.Options.html#inScaled">inScaled</a></code> 设置为
<code>"false"</code> 对 <code><a href="https://developer.android.com/reference/android/graphics/Bitmap.html">Bitmap</a></code> 编程来停用预缩放。在此情况下，系统在绘制时会自动缩放任何绝对的像素坐标和像素
尺寸值。缩放的目的是确保像素定义的屏幕元素仍
以它们在基线屏幕密度
(mdpi) 下的大致相同物理尺寸显示。系统会对应用透明地处理此缩放，并且
向应用报告缩放后的像素尺寸，而不是物理像素尺寸。</p>

  <p>例如，假设设备具有 480x800 的 WVGA 高密度屏幕，大约
与传统 HVGA 屏幕的尺寸一样，但它运行的应用停用了
预缩放。在此情况下，系统在查询屏幕尺寸时会对应用“撒谎”
，报告 320x533（屏幕密度的近似 mdpi 转换值）。然后，当
应用执行绘制操作时，例如作废从 (10,10) 到 (100,
100) 的矩形，系统会将它们缩放适当的量以转变坐标，并且实际
作废区域 (15,15) 到 (150, 150)。如果应用直接操控缩放的位图，
此差异可能会导致非预期的行为，但这被视为
确保应用最佳性能所需的合理权衡。如果遇到此
情况，请参阅<a href="#dips-pels">将 dp 单位转换为像素
单位</a>一节。</p>

  <p>通常，<strong>不应停用预缩放</strong>。支持多种
屏幕的最佳方法是采用上面<a href="#support">如何支持
多种屏幕</a>中所述的基本技术。</p><p>
</p></li>

</ol>


<p>如果您的应用操控位图或以某种其他方式直接与
屏幕上的像素交互，您可能需要采取其他步骤支持不同的屏幕密度。例
如，如果您通过计算手指滑过的像素数
来响应触控手势，则需使用适当的密度独立像素值，而不是实际
像素。</p>


<h3 id="scaling">缩放运行时创建的位图对象</h3>

<div class="figure" style="width:300px">
<img src="https://developer.android.com/images/screens_support/scale-test.png" alt="">
<p class="img-caption"><strong>图 5.</strong> 预缩放的位图与自动缩放的
位图比较。
</p>
</div>

<p>如果您的应用创建内存中位图（<code><a href="https://developer.android.com/reference/android/graphics/Bitmap.html">Bitmap</a></code> 对象），
系统在默认情况下假设位图是针对基线中密度屏幕而设计，然后
在绘制时自动缩放位图。当位图具有不明的密度属性时，系统会对 <code><a href="https://developer.android.com/reference/android/graphics/Bitmap.html">Bitmap</a></code> 应用“自动缩放”。如果未正确
考虑当前设备的屏幕密度和指定位图的密度属性，
自动缩放可能导致缩放伪影，就像未提供备用资源一样。
</p>

<p>要控制是否缩放运行时创建的 <code><a href="https://developer.android.com/reference/android/graphics/Bitmap.html">Bitmap</a></code>，可以
使用 <code><a href="https://developer.android.com/reference/android/graphics/Bitmap.html#setDensity(int)">setDensity()</a></code> 指定位图的密度，
从 <code><a href="https://developer.android.com/reference/android/util/DisplayMetrics.html">DisplayMetrics</a></code> 传递密度常量，例如 <code><a href="https://developer.android.com/reference/android/util/DisplayMetrics.html#DENSITY_HIGH">DENSITY_HIGH</a></code> 或 <code><a href="https://developer.android.com/reference/android/util/DisplayMetrics.html#DENSITY_LOW">DENSITY_LOW</a></code>。</p>

<p>如果使用 <code><a href="https://developer.android.com/reference/android/graphics/BitmapFactory.html">BitmapFactory</a></code> 创建 <code><a href="https://developer.android.com/reference/android/graphics/Bitmap.html">Bitmap</a></code>，例如从文件或流创建，可以使用 <code><a href="https://developer.android.com/reference/android/graphics/BitmapFactory.Options.html">BitmapFactory.Options</a></code> 定义位图的属性（因为
它已经存在），确定系统是否要缩放或者如何缩放。例如，您可以使用
<code><a href="https://developer.android.com/reference/android/graphics/BitmapFactory.Options.html#inDensity">inDensity</a></code> 字段定义
位图设计时的密度，使用 <code><a href="https://developer.android.com/reference/android/graphics/BitmapFactory.Options.html#inScaled">inScaled</a></code> 字段指定位图是否应缩放以
匹配当前设备的屏幕密度。</p>

<p>如果将 <code><a href="https://developer.android.com/reference/android/graphics/BitmapFactory.Options.html#inScaled">inScaled</a></code> 字段设置为 <code>false</code>，然后停用
系统可能应用到位图的预缩放，则系统在绘制时将自动
缩放它。使用自动缩放代替预缩放可能耗用的 CPU 更多，但耗用的内存
更少。</p>

<p>图 5 所示为在高密度屏幕上加载低
(120)、中 (160) 和高 (240) 密度位图时预缩放和自动缩放机制产生的效果。差异
很小，因为所有位图都针对当前屏幕密度而缩放，但根据在绘制时
是预缩放还是自动缩放，
缩放后位图的外观略有不同。</p>

<p class="note"><strong>注：</strong>在 Android 3.0 的更高版本中，由于图形框架的改进，应该觉察不出预缩放的位图
与自动缩放的位图之间
的差异。</p>





<h3 id="dips-pels">将 dp 单位转换为像素单位</h3>

<p>在某些情况下，您需要以 <code>dp</code> 表示尺寸，然后将它们转换为
像素。设想一个在用户
手指移动至少 16 像素之后可以识别滚动或滑动手势的应用。在基线屏幕上，用户必须移动 <code>16 pixels
/ 160 dpi</code>（等于一英寸的 1/10 或 2.5 毫米），然后才会识别该手势。在
具有高密度显示屏 (240dpi) 的设备上，用户必须移动 <code>16 pixels / 240 dpi</code>（等于
一英寸的 1/15 或 1.7 毫米）。此距离更短，应用因此
似乎对用户更灵敏。</p>

<p>要修复此问题，手势阈值必须在代码中以 <code>dp</code> 表示，然后
转换为实际像素。例如：</p>

<pre class="prettyprint"><span class="com">// The gesture threshold expressed in dp</span><span class="pln"><br></span><span class="kwd">private</span><span class="pln"> </span><span class="kwd">static</span><span class="pln"> </span><span class="kwd">final</span><span class="pln"> </span><span class="kwd">float</span><span class="pln"> GESTURE_THRESHOLD_DP </span><span class="pun">=</span><span class="pln"> </span><span class="lit">16.0f</span><span class="pun">;</span><span class="pln"><br><br></span><span class="com">// Get the screen's density scale</span><span class="pln"><br></span><span class="kwd">final</span><span class="pln"> </span><span class="kwd">float</span><span class="pln"> scale </span><span class="pun">=</span><span class="pln"> </span><code><a href="https://developer.android.com/reference/android/content/ContextWrapper.html#getResources()"><span class="pln">getResources</span><span class="pun">()</span></a></code><span class="pun">.</span><code><a href="https://developer.android.com/reference/android/content/res/Resources.html#getDisplayMetrics()"><span class="pln">getDisplayMetrics</span><span class="pun">()</span></a></code><span class="pun">.</span><span class="pln">density</span><span class="pun">;</span><span class="pln"><br></span><span class="com">// Convert the dps to pixels, based on density scale</span><span class="pln"><br>mGestureThreshold </span><span class="pun">=</span><span class="pln"> </span><span class="pun">(</span><span class="kwd">int</span><span class="pun">)</span><span class="pln"> </span><span class="pun">(</span><span class="pln">GESTURE_THRESHOLD_DP </span><span class="pun">*</span><span class="pln"> scale </span><span class="pun">+</span><span class="pln"> </span><span class="lit">0.5f</span><span class="pun">);</span><span class="pln"><br><br></span><span class="com">// Use mGestureThreshold as a distance in pixels...</span></pre>

<p><code><a href="https://developer.android.com/reference/android/util/DisplayMetrics.html#density">DisplayMetrics.density</a></code> 字段根据当前屏幕密度指定
将 <code>dp</code> 单位转换为像素必须使用的缩放系数。
在中密度屏幕上，<code><a href="https://developer.android.com/reference/android/util/DisplayMetrics.html#density">DisplayMetrics.density</a></code>
等于 1.0；在高密度屏幕上，它等于 1.5；在超高密度屏幕上，等于 2.0；
在低密度屏幕上，等于 0.75。此数字是一个系数，应用其乘以
<code>dp</code> 单位以获取用于当前屏幕的实际像素数。（然后在转换时加上 <code>0.5f</code>，将该数字四舍五入到最接近的整数。）如需了解
详细信息，请参阅 <code><a href="https://developer.android.com/reference/android/util/DisplayMetrics.html">DisplayMetrics</a></code> 类。</p>

<p>但是，不能为此类事件定义任意阈值，而应
使用 <code><a href="https://developer.android.com/reference/android/view/ViewConfiguration.html">ViewConfiguration</a></code> 中的预缩放配置值。.</p>


<h4 id="pre-scaled-values">使用预缩放的配置值</h4>

<p>您可以使用 <code><a href="https://developer.android.com/reference/android/view/ViewConfiguration.html">ViewConfiguration</a></code> 类访问 Android 系统使用的通常距离、
速度和时间。例如，
使用 <code><a href="https://developer.android.com/reference/android/view/ViewConfiguration.html#getScaledTouchSlop()">getScaledTouchSlop()</a></code> 可获取框架用作滚动阈值的距离（像素）：</p>

<pre class="prettyprint"><span class="kwd">private</span><span class="pln"> </span><span class="kwd">static</span><span class="pln"> </span><span class="kwd">final</span><span class="pln"> </span><span class="kwd">int</span><span class="pln"> GESTURE_THRESHOLD_DP </span><span class="pun">=</span><span class="pln"> </span><span class="typ">ViewConfiguration</span><span class="pun">.</span><span class="kwd">get</span><span class="pun">(</span><span class="pln">myContext</span><span class="pun">).</span><span class="pln">getScaledTouchSlop</span><span class="pun">();</span></pre>

<p><code><a href="https://developer.android.com/reference/android/view/ViewConfiguration.html">ViewConfiguration</a></code> 中以 <code>getScaled</code> 前缀
开头的方法确定会返回不管当前屏幕密度为何都会正常显示的
像素值。</p>






<h2 id="testing" style="padding-bottom: 0px;">如何在多个屏幕上测试您的应用</h2><hr>

<div class="figure" style="width:500px;margin:0">
  <img src="https://developer.android.com/images/screens_support/avds-config.png" alt="">
  <p class="img-caption"><strong>图 6.</strong>
  一组用于测试屏幕支持的 AVD。</p>
</div>

<p>在发布应用之前，应在所有支持的屏幕
尺寸和密度中全面测试。Android SDK 包含可以使用的模拟器皮肤，
它们会复制您的应用可能要在其中运行的常见屏幕配置的
尺寸和密度。也可修改模拟器皮肤的默认尺寸、密度和分辨率，
以复制任何特定屏幕的特性。使用模拟器皮肤和其他
自定义配置可测试任何可能的屏幕配置，因此您无
需仅仅为了测试应用的屏幕支持而购买不同的设备。</p>

<p>要设置环境以测试应用的屏幕支持，应使用能模拟您希望应用支持的
屏幕尺寸和密度的模拟器皮肤和屏幕配置创建
一系列 AVD (Android Virtual Devices)。要执行此操作，可以使用
AVD Manager 创建 AVD 并使用图形界面启动它们。</p>

<p>要启动 Android SDK Manager，从您的 Android SDK 目录执行 <code>SDK Manager.exe</code>（仅在 Windows 上），或者从
<code>&lt;sdk&gt;/tools/</code> 目录执行 <code>android</code>（在所有平台上）。图 6 所示为用于测试不同屏幕配置的 AVD
Manager（选择了 AVD）。</p>

<p>表 3 所示为 Android SDK 中可用的各种模拟器皮肤，可用
以模拟某些最常见的屏幕配置。</p>

<p>如需了解有关创建和使用 AVD 测试应用的详细信息，请参阅<a href="https://developer.android.com/tools/devices/managing-avds.html">使用 AVD
Manager 管理 AVD</a>。</p>


<p class="table-caption" id="screens-table"><strong>表 3.</strong> Android SDK（粗体表示）及其他
代表性解决方案中模拟器皮肤提供的
各种屏幕配置</p>

  <table class="normal-headers">
    <tbody>
    <tr>
      <th></th>
      <th>
        <nobr>低密度 (120)，<em>ldpi</em></nobr>
      </th>
      <th>
        <nobr>中密度 (160)，<em>mdpi</em></nobr>
      </th>
      <th>
        <nobr>高密度 (240)，<em>hdpi</em></nobr><nobr>
      </nobr></th>
      <th>
        <nobr>超高密度 (320)，<em>xhdpi</em></nobr><nobr>
      </nobr></th>
    </tr>
    <tr>
      <th>
        <em>小</em>屏幕
      </th>
      <td><strong>QVGA (240x320)</strong></td>
      <td></td>
      <td>480x640</td>
      <td></td>
    </tr>
    <tr>
      <th>
        <em>正常</em>屏幕
      </th>
      <td><strong>WQVGA400 (240x400)</strong>
        <br><strong>WQVGA432 (240x432)</strong></td>
      <td><strong>HVGA (320x480)</strong></td>
      <td><strong>WVGA800 (480x800)</strong>
        <br><strong>WVGA854 (480x854)</strong>
        <br>600x1024</td>
      <td>640x960</td>
    </tr>
    <tr>
      <th>
        <em>大</em>屏幕
      </th>
      <td><strong>WVGA800** (480x800)</strong>
        <br><strong>WVGA854** (480x854)</strong></td>
      <td><strong>WVGA800* (480x800)</strong>
        <br><strong>WVGA854* (480x854)</strong>
        <br>600x1024</td>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <th>
        <em>超大</em>屏幕
      </th>
      <td>1024x600</td>
      <td><strong>WXGA (1280x800)</strong><sup>†</sup><br>
          1024x768<br>1280x768</td>
      <td>1536x1152<br>1920x1152
        <br>1920x1200</td>
      <td>2048x1536<br>2560x1536
        <br>2560x1600</td>
    </tr>
    <tr>
      <td colspan="5" style="border:none;font-size:85%;">* 要模拟此配置，在
创建使用 WVGA800 或 WVGA854 皮肤的 AVD 时请指定自定义密度 160。<br>
        ** 要模拟此配置，在创建
使用 WVGA800 或 WVGA854 皮肤的 AVD 时请指定自定义密度 120。<br>
        † 此皮肤可用于 Android 3.0 平台
      </td>
    </tr>
</tbody></table>

<p>要查看支持任何指定屏幕配置的活动设备的相对数量，请参阅
<a href="https://developer.android.com/resources/dashboard/screens.html">屏幕尺寸和密度</a>
仪表板。</p>

<div class="figure" style="width:204px">
  <img src="https://developer.android.com/images/screens_support/avd-start.png" alt="">
  <p class="img-caption"><strong>图 7.</strong>
  从 AVD
Manager 启动 AVD 时可以设置的尺寸和密度选项。</p>
</div>

<p>我们还建议您在
设置为以接近实际设备的物理尺寸运行的模拟器中测试应用。这样
更容易比较不同尺寸和密度时的结果。要
完成此操作，需要知道计算机显示器的大约密度 (dpi)，
例如 30 英寸 Dell 显示器的密度约为 96 dpi。从 AVD Manager 启动 AVD
时，可在 Launch Options 中指定用于模拟器和您的
显示器的屏幕尺寸 (dpi)，如图 7 所示。</p>

<p>如果要在使用内置皮肤
不支持的分辨率或密度的屏幕上测试应用，可以创建使用自定义分辨率或密度的
AVD。从 AVD Manager 创建 AVD 时，指定 Resolution，
而不要选择 Built-in Skin。</p>

<p>从命令行启动 AVD 时，可以使用 <code>-scale</code> 选项指定用于
模拟器的缩放比例。例如：</p>

<pre class="prettyprint"><span class="pln">emulator </span><span class="pun">-</span><span class="pln">avd </span><span class="str">&lt;avd_name&gt;</span><span class="pln"> </span><span class="pun">-</span><span class="pln">scale </span><span class="lit">96dpi</span></pre>

<p>要调整模拟器的大小，可使用 <code>-scale</code> 选项指定代表所需缩放系数的
0.1 至 3。</p>

<p>如需了解从命令行创建 AVD 的更多信息，请参阅<a href="https://developer.android.com/tools/devices/managing-avds-cmdline.html">从命令行管理
AVD</a>。</p>



    </div>