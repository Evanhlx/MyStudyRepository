package com.hlx.accountbook;

import android.app.Application;

/**
 * Created by huanglx on 2018/6/2.
 */

public class App extends Application {

    private static App mInstance ;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static App getInstance(){
        return mInstance;
    }
}
