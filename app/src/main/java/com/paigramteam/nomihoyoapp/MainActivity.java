package com.paigramteam.nomihoyoapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.paigramteam.nomihoyoapp.ui.ByWebViewActivity;
import com.paigramteam.nomihoyoapp.utils.StatusBarUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 是否开启了主页，没有开启则会返回主页
    public static boolean isLaunch = false;
    private int state = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary), 0);
        initView();
        isLaunch = true;
    }

    private void initView() {
        findViewById(R.id.bt_openUrl).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_openUrl) {
            openUrl();
        }
    }

    /**
     * 打开网页
     */
    private void openUrl() {
        state = 0;
        loadUrl("https://user.mihoyo.com", "MiHoYo");
    }

    private void loadUrl(String mUrl, String mTitle) {
        ByWebViewActivity.loadUrl(this, mUrl, mTitle, state);
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isLaunch = false;
    }
}
