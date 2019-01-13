package com.example.wechat10;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
public class RegisterActivity extends FragmentActivity {
	private EditText name;
	private EditText password,password1;
	private CheckBox chexBox;
	private SharedPreferences sharedPreferences;
	private StringBuffer sb;
	private MyDatabaseHelper dbHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.register);
		name=(EditText) findViewById(R.id.name);
		password=(EditText) findViewById(R.id.userpassword);
		password1=(EditText) findViewById(R.id.userpassword1);
		dbHelper = new MyDatabaseHelper(this, "PersonStore.db", null, 1);
	}
	public boolean queryName(String name) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		// 查询Book表中所有的数据
		Cursor c = db.query("person", null, null, null, null, null, null);

		if(c!=null) {
			String[] cols=c.getColumnNames();
			while(c.moveToNext()) {
				for(String columnName:cols) {
					Log.i("info", c.getString(c.getColumnIndex(columnName)));
					if(c.getString(c.getColumnIndex(columnName)).equals(name)) {						
						return false;
					}
				}
			}
		}
		c.close();
		return true;
	}
	public boolean confirm(String passwd,String passwd1) {
		if(!passwd.equals(passwd1)) {
			Toast.makeText(RegisterActivity.this, "两次输入密码不相同，请重新输入", Toast.LENGTH_SHORT).show();
			return false;
		}
		return true;
	}
	public void insertUser(String name,String password) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		// 开始组装第一条数据
		values.put("username", name);
		values.put("userpasswd", password);
		db.insert("person", null, values); // 插入一条数据
	}
	public void doClick(View v) {
		switch (v.getId()) {
		case R.id.login:
			if(!name.getText().toString().equals("")&&!password.getText().toString().equals("")&&!password1.getText().toString().equals("")) {
				if(queryName(name.getText().toString())) {
					if(confirm(password.getText().toString(),password1.getText().toString())) {
						insertUser(name.getText().toString(), password.getText().toString());
						Toast.makeText(RegisterActivity.this, "用户"+name.getText().toString()+"注册成功", Toast.LENGTH_SHORT).show();
						Intent intent=new Intent(RegisterActivity.this, HomePage.class);
						startActivity(intent);
						finish();
					}
					
				}else {
					Toast.makeText(RegisterActivity.this, "注册失败,用户名已存在", Toast.LENGTH_SHORT).show();
				}
			}else if(name.getText().toString().equals("")) {
				Toast.makeText(RegisterActivity.this, "用户名不能为空 ", Toast.LENGTH_SHORT).show();
			}
			else if(password.getText().toString().equals("")) {
				Toast.makeText(RegisterActivity.this, "密码不能为空  ", Toast.LENGTH_SHORT).show();
			}
			else {
				Toast.makeText(RegisterActivity.this, "登录失败，用户名或密码不正确  ", Toast.LENGTH_SHORT).show();
			}
			break;
		}
	}

}
