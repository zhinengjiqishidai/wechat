package com.example.wechat10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.wechat10.listview.ItemBean;
import com.example.wechat10.listview.MyAdapter;
import com.kcrason.highperformancefriendscircle.R;

public class MeMainTabFragment3 extends Fragment {
	private View view,view2;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view=inflater.inflate(R.layout.tab04,container, false);
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		RelativeLayout ll = (RelativeLayout) view.findViewById(R.id.re_myinfo);
		ll.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), MyInfo.class);
				startActivity(intent);
			}
		});
	}
}
