package com.hlx.view.evanhlxcustomview.hybird;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.hlx.view.evanhlxcustomview.R;

public class WebActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        if (null != getSupportActionBar()) {
            getSupportActionBar().hide();
        }
        mWebView = (WebView) findViewById(R.id.web);
        initWebView();

        mWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
                    // 返回键退回
                    mWebView.goBack();
                    return true;
                } else
                    return false;
            }
        });
    }

    /**
     * //多窗口
     * supportMultipleWindows();
     * //获取触摸焦点
     * webview.requestFocusFromTouch();
     * //允许访问文件
     * setAllowFileAccess(true);
     * //开启javascript
     * setJavaScriptEnabled(true);
     * //支持通过JS打开新窗口
     * setJavaScriptCanOpenWindowsAutomatically(true);
     * //提高渲染的优先级
     * webSettings.setRenderPriority(RenderPriority.HIGH);
     * //支持内容重新布局
     * setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
     * //关闭webview中缓存
     * setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
     */
    private void initWebView() {
        initWebSetting();
        mWebView.loadUrl("http://www.gcssloop.com/customview/CustomViewIndex/");
        mWebView.setWebChromeClient(new MyWebChromeClient());
        mWebView.setWebViewClient(new MyWebClient());
    }

    /**
     * setCacheMode 设置缓存的模式 eg: settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
     * setJavaSciptEnabled 设置是否支持Javascript eg: settings.setJavaScriptEnabled(true);
     * setDefaultTextEncodingName 设置在解码时使用的默认编码 eg: settings.setDefaultTextEncodingName(“utf-8”);
     * setAllowFileAccess 启用或禁止WebView访问文件数据
     * setBlockNetworkImage 是否显示网络图像
     * setBuiltInZoomControls 设置是否支持缩放
     * setDefaultFontSize 设置默认的字体大小
     * setFixedFontFamily 设置固定使用的字体
     * setLayoutAlgorithm 设置布局方式
     * setLightTouchEnabled 设置用鼠标激活被选项
     * setSupportZoom 设置是否支持变焦
     */
    private void initWebSetting() {
        WebSettings webSettings = mWebView.getSettings();
        //支持缩放，默认为true。
        webSettings.setSupportZoom(false);
        //调整图片至适合webview的大小
        webSettings.setUseWideViewPort(true);
        // 缩放至屏幕的大小
        webSettings.setLoadWithOverviewMode(true);
        //设置默认编码
        webSettings.setDefaultTextEncodingName("utf-8");
        //设置自动加载图片
        webSettings.setLoadsImagesAutomatically(true);
    }


    /**
     * onProgressChanged 加载进度条改变
     * onJsPrompt 用在解决4.2以下addJavascriptInterface漏洞问题
     * onCloseWindow 关闭WebView
     * onCreateWindow 创建WebView
     * onJsAlert 处理Javascript中的Alert对话框
     * onJsConfirm处理Javascript中的Confirm对话框
     * onJsPrompt处理Javascript中的Prompt对话框
     * onReceivedlcon 网页图标更改
     * onReceivedTitle 网页Title更改
     * onRequestFocus WebView显示焦点
     * onConsoleMessage 在Logcat中输出javascript的日志信息
     */
    class MyWebChromeClient extends WebChromeClient {

    }

    /**
     * onPageStarted 网页开始加载
     * onReceivedError 报告错误信息
     * onLoadResource 加载指定地址提供的资源
     * shouldOverrideUrlLoading 控制新的连接在当前WebView中打开
     * onPageFinished 网页加载完毕，此方法并没有方法名表现的那么美好，调用时机很不确定。如需监听网页加载完成可以使用onProgressChanged，当int progress返回100时表示网页加载完毕。
     * doUpdate VisitedHistory 更新历史记录
     * onFormResubmission 应用程序重新请求网页数据
     * onScaleChanged WebView发生改变
     */
    class MyWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;   //返回true， 立即跳转，返回false,打开网页有延时
        }

      /*  @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

            return shouldOverrideUrlLoading(view, request.getUrl().toString());
        }*/
    }


    @Override
    protected void onDestroy() {
        if (mWebView != null) {
            mWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWebView.clearHistory();
            ((ViewGroup) mWebView.getParent()).removeView(mWebView);
            mWebView.destroy();
            mWebView = null;
        }
        super.onDestroy();
    }

}
