package com.application.booktravel.activity;

/**
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import com.example.booktravel.R;

/**
 * @author allin
 * 
 */
public class MyBookEvaluation extends ListActivity {
	private int []images = {R.drawable.gaiwancha,R.drawable.junshililun,R.drawable.linghuoyingbiandexiaoshou,R.drawable.lishitansuo,R.drawable.qiantu,
			R.drawable.sanguoyanyi,R.drawable.shuyunpiaoxiang,R.drawable.wulihuaxuecankao,R.drawable.yuedu,R.drawable.gaiwancha,R.drawable.junshililun,R.drawable.linghuoyingbiandexiaoshou,R.drawable.lishitansuo,R.drawable.qiantu,
			R.drawable.sanguoyanyi,R.drawable.shuyunpiaoxiang,R.drawable.wulihuaxuecankao,R.drawable.yuedu};
	private String[] text1 = {"�����","��������","���Ӧ�������","��ʷ̽��","Ǯ;","��������","����Ʈ��","����ѧ�ο�","�ö�","�����","��������","���Ӧ�������","��ʷ̽��","Ǯ;","��������","����Ʈ��","����ѧ�ο�","�ö�"};
	private String[] text2 = {"20150903","20150903","20150903","20150903","20150903","20150903","20150903","20150903","�ö�","�����","��������","���Ӧ�������","��ʷ̽��","Ǯ;","��������","����Ʈ��","����ѧ�ο�","�ö�"};
	private String[] text3 = {"��������","��������","��������","��������","��������","��������","��������","��������","��������","��������","��������","���Ӧ�������","��ʷ̽��","Ǯ;","��������","����Ʈ��","����ѧ�ο�","�ö�"};

	// private List<String> data = new ArrayList<String>();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.vlist,
				new String[]{"title","info","mycontent","img"},
				new int[]{R.id.title,R.id.info,R.id.mycontent,R.id.img});
		setListAdapter(adapter);
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map;
		for(int i=0;i<images.length;i++)
		{
			map = new HashMap<String, Object>();
			map.put("title", text1[i]);
			map.put("info", text2[i]);
			map.put("mycontent",text3[i]);
			map.put("img", images[i]);
			list.add(map);
		}
		
		return list;
	}
}

