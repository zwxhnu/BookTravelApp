package com.application.booktravel.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.booktravel.R;

public class BookToEvaluate extends Activity{
	private int []images = {R.drawable.gaiwancha,R.drawable.junshililun,R.drawable.linghuoyingbiandexiaoshou,R.drawable.lishitansuo,R.drawable.qiantu,
			R.drawable.sanguoyanyi,R.drawable.shuyunpiaoxiang,R.drawable.wulihuaxuecankao,R.drawable.yuedu,R.drawable.gaiwancha,R.drawable.junshililun,R.drawable.linghuoyingbiandexiaoshou,R.drawable.lishitansuo,R.drawable.qiantu,
			R.drawable.sanguoyanyi,R.drawable.shuyunpiaoxiang,R.drawable.wulihuaxuecankao,R.drawable.yuedu};
	private String[] text = {"�����","��������","���Ӧ�������","��ʷ̽��","Ǯ;","��������","����Ʈ��","����ѧ�ο�","�ö�","�����","��������","���Ӧ�������","��ʷ̽��","Ǯ;","��������","����Ʈ��","����ѧ�ο�","�ö�"};
	List<Map<String, Object>> list;  
	GridView gridview ;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.daipingshuji_layout);
		list = new ArrayList<Map<String,Object>> ();
		gridview = (GridView) findViewById(R.id.gridview);
		getData();
		String[] from = {"book_image","book_name"};
		int [] to = {R.id.book_image,R.id.book_name};
		SimpleAdapter adapter = new SimpleAdapter(this,list,R.layout.book_item2,from,to);
		gridview.setAdapter(adapter);
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
