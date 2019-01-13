package com.example.wechat10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;

import com.kcrason.highperformancefriendscircle.R;

public class MyInfo_d extends AppCompatActivity {

    private ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinfo);
    }

    public void doClick(View v){
        switch (v.getId())
        {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
