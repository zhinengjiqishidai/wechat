package com.example.wechat10;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidwechat.util.MyDatabaseHelper;
import com.kcrason.highperformancefriendscircle.R;

@SuppressLint("NewApi")
public class HomePage extends FragmentActivity {
	private EditText name;
	private EditText password;
	private CheckBox chexBox;
	private SharedPreferences sharedPreferences;
	private SharedPreferences.Editor editor;
	private String failureUri = "https://mp.weixin.qq.com/";
	private StringBuffer sb;
	private MyDatabaseHelper dbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		dbHelper = new MyDatabaseHelper(this, "PersonStore.db", null, 1);
		name = (EditText) findViewById(R.id.name);
		password = (EditText) findViewById(R.id.userpassword);
		chexBox = (CheckBox) findViewById(R.id.checkbox1);
		sharedPreferences = getSharedPreferences("rememberpassword", Context.MODE_PRIVATE);
		boolean isRemember = sharedPreferences.getBoolean("rememberpassword", false);
		if (isRemember) {
			String Name = sharedPreferences.getString("name", "");
			String Password = sharedPreferences.getString("password", "");
			name.setText(Name);
			password.setText(Password);
			chexBox.setChecked(true);
		}

	}

	public void doClick(View v) {
		switch (v.getId()) {
		case R.id.login:
			if (queryName(name.getText().toString(), password.getText().toString())) {
				SharedPreferences.Editor editor = sharedPreferences.edit();
				if (chexBox.isChecked()) {
					editor.putBoolean("rememberpassword", true);
					editor.putString("name", name.getText().toString());
					editor.putString("password", password.getText().toString());
				} else {
					editor.clear();
				}
				editor.apply();
				Intent intent = new Intent(HomePage.this, Main.class);
				startActivity(intent);
				finish();
			} else if (name.getText().toString().equals("")) {
				Toast.makeText(HomePage.this, "用户名不能为空  ", Toast.LENGTH_SHORT).show();
			} else if (password.getText().toString().equals("")) {
				Toast.makeText(HomePage.this, "密码不能为空  ", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(HomePage.this, "登录失败，用户名或密码不正确  ", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.cannotRegister:
			Uri uri1 = Uri.parse(failureUri);
			Intent intent2 = new Intent(Intent.ACTION_VIEW, uri1);
			startActivity(intent2);
			break;
		default:
			break;
		}
	}



	public boolean queryName(String name, String password) {
		sb = new StringBuffer();
		sb.append("select * from person where username=").append("'" + name + "'");
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		// 查询Book表中所有的数据
		Cursor c = db.rawQuery(sb.toString(), null);

		for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
		{
			String Name = c.getString(0);
			String Password = c.getString(1);
			if(Name.equals(name)&&Password.equals(password)) {
				return true;
			}
		}

		c.close();
		return false;
	}

}
