package com.example.wechat10;

import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.kcrason.highperformancefriendscircle.R;

@SuppressLint("NewApi")
public class Main extends FragmentActivity {
	private ViewPager viewpager;
	private FragmentPagerAdapter mAdapter;
	private List<Fragment> mDatas;
	private TextView mChatTextView;
	private TextView mFriendTextView;
	private TextView mContactTextView;
	private TextView mMeTextView;
	private int mScreen1_3;
	private ImageView mTabline;
	private int mCurrentPageindex;
	private int mPositionTop = 0;
	private boolean flag = true;
	private boolean flag1 = true;
	private ImageView weichat;
	private ImageView category;
	private ImageView find;
	private ImageView mine;
	private ImageView add_icon;
	private PopupWindow add_icon_popWindow;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main1);
		initTabline();
		initView();

	}

	private void initTabline() {
		mTabline = (ImageView) findViewById(R.id.id_tabline);
		weichat=(ImageView) findViewById(R.id.weichat);
		category=(ImageView) findViewById(R.id.category);
		find=(ImageView) findViewById(R.id.find);
		mine=(ImageView) findViewById(R.id.mine);
		add_icon = (ImageView) findViewById(R.id.add_icon);
		add_icon.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				View view =getLayoutInflater().inflate(R.layout.add_icon_popwindow,null);
				TextView tv1 = view.findViewById(R.id.tv2);
				tv1.setOnClickListener(new View.OnClickListener(){
					public void onClick(View v)
					{
						Intent intent1=new Intent(Main.this, AddActivity.class);
						startActivity(intent1);
					}
				});
				add_icon_popWindow = new PopupWindow(view,500,550);
				add_icon_popWindow.setOutsideTouchable(true);
				add_icon_popWindow.setFocusable(true);
				add_icon_popWindow.showAsDropDown(add_icon);
			}
		});
		Display display = getWindow().getWindowManager().getDefaultDisplay();
		DisplayMetrics outMetrics = new DisplayMetrics();
		display.getMetrics(outMetrics);
		mScreen1_3 = outMetrics.widthPixels / 4;
		LayoutParams lp = (LayoutParams) mTabline.getLayoutParams();
		lp.width = mScreen1_3;
		mTabline.setLayoutParams(lp);
	}

	public void doClick(View v) {
		switch (v.getId()) {
		case R.id.chat:
		case R.id.lin_chat:
			viewpager.setCurrentItem(0);
			resetImageViewBack();
			weichat.setBackgroundResource(R.drawable.home_selected);
			break;
		case R.id.friend:
		case R.id.lin_friend:
			viewpager.setCurrentItem(1);
			resetImageViewBack();
			category.setBackgroundResource(R.drawable.category_selected);
			break;
		case R.id.contact:
		case R.id.lin_find:
			viewpager.setCurrentItem(2);
			resetImageViewBack();
			find.setBackgroundResource(R.drawable.find_selected);
			break;
		case R.id.me:
		case R.id.lin_me:
			viewpager.setCurrentItem(3);
			resetImageViewBack();
			mine.setBackgroundResource(R.drawable.mine_selected);
			break;	
		case R.id.search_bar:
			Intent intent=new Intent(Main.this, SearchActivity.class);
			startActivity(intent);
			break;
		case R.id.add_icon:
			//Intent intent1=new Intent(Main.this, AddActivity.class);
			//startActivity(intent1);
			break;
		}
	}

	public void initView() {
		viewpager = (ViewPager) findViewById(R.id.viewpager);
		mChatTextView = (TextView) findViewById(R.id.chat);
		mFriendTextView = (TextView) findViewById(R.id.friend);
		mContactTextView = (TextView) findViewById(R.id.contact);
		mMeTextView=(TextView) findViewById(R.id.me);
		mDatas = new ArrayList<Fragment>();
		ChatMainTabFragment2 tab01 = new ChatMainTabFragment2();
		FriendMainTabFragment2 tab02 = new FriendMainTabFragment2();
		ContactMainTabFragment2 tab03 = new ContactMainTabFragment2();
		MeMainTabFragment3 tab04=new MeMainTabFragment3();
		mDatas.add(tab01);
		mDatas.add(tab02);
		mDatas.add(tab03);
		mDatas.add(tab04);
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mDatas.size();
			}

			@Override
			public Fragment getItem(int position) {
				// TODO Auto-generated method stub
				return mDatas.get(position);
			}
		};
		viewpager.setAdapter(mAdapter);
		viewpager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				resetTextViewColor();
				switch (position) {
				case 0:
					mChatTextView.setTextColor(Color.parseColor("#008000"));
					resetImageViewBack();
					weichat.setBackgroundResource(R.drawable.home_selected);
					break;
				case 1:
					mFriendTextView.setTextColor(Color.parseColor("#008000"));
					resetImageViewBack();
					category.setBackgroundResource(R.drawable.category_selected);
					break;
				case 2:
					mContactTextView.setTextColor(Color.parseColor("#008000"));
					resetImageViewBack();
					find.setBackgroundResource(R.drawable.find_selected);
					break;
				case 3:
					mMeTextView.setTextColor(Color.parseColor("#008000"));
					resetImageViewBack();
					mine.setBackgroundResource(R.drawable.mine_selected);
					break;
				}
				mCurrentPageindex = position;
			}
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPx) {
				// TODO Auto-generated method stub
				LayoutParams layoutParams = (LayoutParams) mTabline.getLayoutParams();
				if (mCurrentPageindex == 0 && position == 0) {
					layoutParams.leftMargin = (int) (positionOffset * mScreen1_3 + mCurrentPageindex * mScreen1_3);

				} else if (mCurrentPageindex == 1 && position == 0) {
					layoutParams.leftMargin = (int) ((positionOffset - 1) * mScreen1_3
							+ mCurrentPageindex * mScreen1_3);
				} else if (mCurrentPageindex == 1 && position == 1) {
					layoutParams.leftMargin = (int) (positionOffset * mScreen1_3 + mCurrentPageindex * mScreen1_3);
				} else if (mCurrentPageindex == 2 && position == 1) {
					layoutParams.leftMargin = (int) ((positionOffset - 1) * mScreen1_3
							+ mCurrentPageindex * mScreen1_3);
				}else if (mCurrentPageindex == 2 && position == 2) {
					layoutParams.leftMargin = (int) (positionOffset * mScreen1_3 + mCurrentPageindex * mScreen1_3);
				}else if (mCurrentPageindex == 3 && position == 2) {
					layoutParams.leftMargin = (int) ((positionOffset - 1) * mScreen1_3
							+ mCurrentPageindex * mScreen1_3);
				}
				mTabline.setLayoutParams(layoutParams);
			}
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
			}
		});
	}
	public void resetImageViewBack() {
		weichat.setBackgroundResource(R.drawable.home_normal);
		category.setBackgroundResource(R.drawable.category_normal);
		find.setBackgroundResource(R.drawable.find_normal);
		mine.setBackgroundResource(R.drawable.mine_normal);
	}
	public void resetTextViewColor() {
		mChatTextView.setTextColor(Color.BLACK);
		mFriendTextView.setTextColor(Color.BLACK);
		mContactTextView.setTextColor(Color.BLACK);
	}

}
