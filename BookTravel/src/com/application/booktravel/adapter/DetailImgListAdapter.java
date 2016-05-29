package com.application.booktravel.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.example.booktravel.R;

public class DetailImgListAdapter extends BaseAdapter{

	private Context mContext;
	public DetailImgListAdapter(Context context) {
		// TODO Auto-generated constructor stub
		mContext =context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub		 
		 ImageView img = new ImageView(mContext);
		 img.setPadding(10, 10, 10, 10);
		 img.setScaleType(ScaleType.CENTER_CROP);
		   if(position%4 ==0){ 
			   img.setImageResource(R.drawable.gooda);
		        }else if(position%4 ==1){
		        	img.setImageResource(R.drawable.gooda);
		        }else if(position%4 ==2){
		        	img.setImageResource(R.drawable.goodc);
		        }else if(position%4 ==3){
		        	img.setImageResource(R.drawable.goodd);
		        }
		   return img;
	}

}
