package com.example.wechat10;


import java.util.ArrayList;
import java.util.List;

import com.example.wechat10.listview.ItemBean;
import com.example.wechat10.listview.MyAdapter;
import com.kcrason.highperformancefriendscircle.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

public class ChatMainTabFragment2 extends Fragment {
	private View view;
	private ListView listview;
	List<ItemBean> datalist=new ArrayList<ItemBean>();
	private int[] values={R.drawable.aaa,R.drawable.bbb,R.drawable.ccc,R.drawable.ddd,R.drawable.eee,R.drawable.fff};
	//private int[] imageResource={R.drawable.boat,R.drawable.boxing,R.drawable.football,R.drawable.equestrianism,R.drawable.golf,R.drawable.icehockey,R.drawable.javelin,R.drawable.surf,R.drawable.surfride,R.drawable.tennis,R.drawable.volleyball,R.drawable.weightlefting};
	private int[] imageResource={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l};
	private String[] textResource= {"易水寒","死神","不划水的易水寒","水流之下","矢泽妮可","一方通行","日向雏田","未闻花名","Another","路飞","路明非","阿尔明"};
	private String[] textCResource= {"今晚去上网？","不是","吃什么","几点？","你个笨蛋","无路赛","关于幂次方的三元求解问题我可以教你","直男是活的最自由的男人","死肥宅真恶心","去日本旅游吧","你挂了科？","你又挂科了？"};
	private String[] textTime= {"昨天","半个月前","三天前","一周前","4:10","9:20","22:35","1:15","7:09","6:48","9:11","12:15"};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return view=inflater.inflate(R.layout.tab01,container, false);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		ListView listview=(ListView)view.findViewById(R.id.wechat_listview);

		for (int i = 0; i <imageResource.length; i++) {
			datalist.add(new ItemBean(imageResource[i], textResource[i], textCResource[i],textTime[i]));
		}
		listview.setAdapter(new MyAdapter(this.getActivity(),R.layout.tab01_listview2, datalist));
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
									int position, long id) {
				ItemBean itemBean = datalist.get(position);
				Intent intent = new Intent(getActivity(), MsgActivity.class);
				startActivity(intent);

			}
		});
	}
}
