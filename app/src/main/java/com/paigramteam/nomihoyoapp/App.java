package com.paigramteam.nomihoyoapp;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.paigramteam.nomihoyoapp.utils.WebTools;

/**
 * @author jingbin
 * @data 2018/2/2
 */

public class App extends Application {

    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static App getInstance() {
        return app;
    }

    /**
     * 方法数超64k 解决 https://developer.android.com/studio/build/multidex?hl=zh-cn
     * 继承 MultiDexApplication 或 实现此方法。
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        WebTools.handleWebViewDir(base);
        MultiDex.install(this);
    }
}
