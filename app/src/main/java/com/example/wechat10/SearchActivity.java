package com.example.wechat10;



import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;

import com.kcrason.highperformancefriendscircle.R;


public class SearchActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.search);
		}
	public void doClick(View v) {
		switch (v.getId()) {
		case R.id.id_back:
			finish();
			break;
	
		}
	}

}


