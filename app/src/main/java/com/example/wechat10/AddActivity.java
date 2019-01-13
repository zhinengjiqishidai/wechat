package com.example.wechat10;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.kcrason.highperformancefriendscircle.R;

public class AddActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_addfriends);
    }
    public void doClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;

        }
    }

}
