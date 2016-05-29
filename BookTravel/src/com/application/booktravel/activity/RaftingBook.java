package com.application.booktravel.activity;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.application.booktravel.adapter.DetailImgListAdapter;
import com.application.booktravel.widget.MyScrollView;
import com.application.booktravel.widget.MyScrollView.OnGetBottomListener;
import com.example.booktravel.R;

public class RaftingBook extends Activity implements OnGetBottomListener{

	private int []images = {R.drawable.gaiwancha,R.drawable.junshililun,R.drawable.linghuoyingbiandexiaoshou,R.drawable.lishitansuo,R.drawable.qiantu,
			R.drawable.sanguoyanyi,R.drawable.shuyunpiaoxiang,R.drawable.wulihuaxuecankao,R.drawable.yuedu,R.drawable.gaiwancha,R.drawable.junshililun,R.drawable.linghuoyingbiandexiaoshou,R.drawable.lishitansuo,R.drawable.qiantu,
			R.drawable.sanguoyanyi,R.drawable.shuyunpiaoxiang,R.drawable.wulihuaxuecankao,R.drawable.yuedu};
	private String[] text = {"盖碗茶","军事理论","灵活应变的销售","历史探索","钱途","三国演义","书韵飘香","物理化学参考","悦读","盖碗茶","军事理论","灵活应变的销售","历史探索","钱途","三国演义","书韵飘香","物理化学参考","悦读"};
	List<Map<String, Object>> list;  
	GridView gridview3 ;
	 MyScrollView mMainScroll;
	// MyListView mDetailImgList ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.raftingbook_layout);
		
	    LinearLayout linear = (LinearLayout)findViewById(R.id.linearLayout);
		
		final DisplayMetrics displayMetrics = new DisplayMetrics();
	        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
	    final int height = displayMetrics.heightPixels;      //获取手机高度
		
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,height*2);
		
		linear.setLayoutParams(lp);
		
		TextView textview = (TextView)findViewById(R.id.textview);
		lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,height+10);
				
		textview.setLayoutParams(lp);
		
	    mMainScroll = (MyScrollView)findViewById(R.id.main_scroll);
		
		mMainScroll.setBottomListener(this);
		
		list = new ArrayList<Map<String,Object>> ();
		gridview3 = (GridView) findViewById(R.id.gridview3);
		getData();
		String[] from = {"book_image","book_name"};
		int [] to = {R.id.book_image,R.id.book_name};
		SimpleAdapter adapter = new SimpleAdapter(this,list,R.layout.raftingbook_item,from,to);
		gridview3.setAdapter(adapter);
	}
	
	@Override
	public void onBottom() {
		// TODO Auto-generated method stub
	//	mDetailImgList.setBottomFlag(true);
		 
	}
	public List<Map<String,Object>> getData()
	{
		for(int i=0;i<images.length;i++)
		{
			 Map<String,Object> map = new HashMap<String,Object> ();
			 map.put("book_name",text[i]);
			 map.put("book_image", images[i]);
			 list.add(map);
		}
		return list;
	}
}
