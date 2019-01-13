package com.example.wechat10;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.kcrason.highperformancefriendscircle.R;

public class MainActivity extends FragmentActivity {
    private Button register;
    private Button login;
    private String regsterUri="https://mp.weixin.qq.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.loginfirst);
    }
    public void doClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.login:
                Intent intent1 =new Intent(MainActivity.this, HomePage.class);
                startActivity(intent1);
                break;
        }
    }

}