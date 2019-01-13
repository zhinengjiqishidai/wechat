package com.example.wechat10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.wechat10.msg.Msg;
import com.example.wechat10.msg.MsgAdapter;
import com.kcrason.highperformancefriendscircle.R;

public class MyInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);
    }

    public void doClick(View v) {
        switch (v.getId()) {
            case R.id.MI_back:
                finish();
                break;

        }
    }
}
