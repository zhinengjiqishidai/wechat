package com.example.wechat10.listview;

import java.util.List;


import android.content.Context;  
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;  
import android.widget.ArrayAdapter;  
import android.widget.ImageView;  
import android.widget.TextView;

import com.kcrason.highperformancefriendscircle.R;

public class MyAdapter extends ArrayAdapter<ItemBean>{  
  
    Context context;  
    int resource;  
    List<ItemBean> objects;  
    public MyAdapter(Context context, int resource, List<ItemBean> objects) {  
        super(context, resource, objects);  
        this.context=context;  
        this.resource=resource;  
        this.objects=objects;  
    }  
    @Override  
    public View getView(int position, View convertView, ViewGroup parent) {  
        View view;  
        ImageView imageView;  
        TextView title;  
        TextView content;  
        TextView time;  
          
        if(convertView!=null){  
            view=convertView;  
        }  
        else {  
            view=LayoutInflater.from(context).inflate(resource, null);  
        }  
        imageView=(ImageView)view.findViewById(R.id.item_img);
        title=(TextView)view.findViewById(R.id.item_title);  
        content=(TextView)view.findViewById(R.id.item_content);  
        time=(TextView)view.findViewById(R.id.item_time);  
        imageView.setImageResource(objects.get(position).getItemImageid());  
        title.setText(objects.get(position).getItenTitle());  
        content.setText(objects.get(position).getItemContent());  
        time.setText(objects.get(position).getTextTime());  
          
        return view;  
    }  
      
}  
