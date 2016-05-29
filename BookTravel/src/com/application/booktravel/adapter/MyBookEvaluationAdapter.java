package com.application.booktravel.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.booktravel.model.MyBook_model;
import com.example.booktravel.R;

/*
 * ÈßÓàjavaÎÄ¼þ,@author wangcao
 */
public class MyBookEvaluationAdapter extends ArrayAdapter<MyBook_model> {

	private int resourceId;

	public MyBookEvaluationAdapter(Context context, int textViewResourceId,
			List<MyBook_model> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		MyBook_model mybook_model = getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.mybookevaluation_image = (ImageView) view.findViewById(R.id.mybookevaluation_image);
			viewHolder.mybookevaluation_name = (TextView) view.findViewById(R.id.mybookevaluation_name);
			viewHolder.mybookevaluation_data = (TextView) view.findViewById(R.id.mybookevaluation_data);
			viewHolder.mybookevaluation_content= (TextView) view.findViewById(R.id.mybookevaluation_content);
			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
//		viewHolder.mybookevaluation_image.setImageResource(book.getImageId());
//		viewHolder.mybookevaluation_name.setText(book.getName());
//		viewHolder.mybookevaluation_data.setText(book.getName());
//		viewHolder.mybookevaluation_content.setText(book.getName());
		return view;
	}
	
	class ViewHolder {
		
		ImageView mybookevaluation_image;
		
		TextView mybookevaluation_name;
		
		TextView mybookevaluation_data;		
		
		TextView mybookevaluation_content;
	}

}
