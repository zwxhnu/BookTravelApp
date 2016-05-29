package com.application.booktravel.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.application.booktravel.register.RegisterActivity2;
import com.example.booktravel.R;

public class MyBook extends Activity{
	LinearLayout linearlayout1 = null;
	LinearLayout linearlayout2 = null;
	LinearLayout linearlayout3 = null;
	LinearLayout linearlayout4 = null;
	LinearLayout linearlayout5 = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mybook_layout);
	  linearlayout1 = (LinearLayout)findViewById(R.id.mybook_linearlayout1);
	  linearlayout2 = (LinearLayout)findViewById(R.id.mybook_linearlayout2);
	  linearlayout3 = (LinearLayout)findViewById(R.id.mybook_linearlayout3);
	  linearlayout4 = (LinearLayout)findViewById(R.id.mybook_linearlayout4);
	  linearlayout5 = (LinearLayout)findViewById(R.id.mybook_linearlayout5);
	  linearlayout1.setOnClickListener(onclicklistener);
	  linearlayout2.setOnClickListener(onclicklistener);
	  linearlayout3.setOnClickListener(onclicklistener);
	  linearlayout4.setOnClickListener(onclicklistener);
	  linearlayout5.setOnClickListener(onclicklistener);
	}
	
	public OnClickListener onclicklistener = new OnClickListener()
	{
		public void onClick(View v)
		{
			switch(v.getId())
			{
			case R.id.mybook_linearlayout1:
			
				Intent intent = new Intent();
				intent.setClass(MyBook.this,MyCollections.class);
				startActivity(intent);
				break;
			case R.id.mybook_linearlayout2:
			
				Intent intent2 = new Intent();
				intent2.setClass(MyBook.this,RaftingBook.class);
				startActivity(intent2);
				break;
			case R.id.mybook_linearlayout3:
			
				Intent intent3 = new Intent();
				intent3.setClass(MyBook.this,BookToEvaluate.class);
				startActivity(intent3);
				break;
			case R.id.mybook_linearlayout4:
			
				Intent intent4 = new Intent();
				intent4.setClass(MyBook.this,MyBookEvaluation.class);
				startActivity(intent4);
				break;
			case R.id.mybook_linearlayout5:
				Intent intent5 = new Intent();
				intent5.setClass(MyBook.this,RegisterActivity2.class);
				startActivity(intent5);
				break;
			default:
				break;
			}
		}
		
	};
}
