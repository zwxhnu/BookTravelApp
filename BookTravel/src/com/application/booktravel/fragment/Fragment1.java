package com.application.booktravel.fragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.application.booktravel.activity.MyBook;
import com.application.booktravel.register.RegisterActivity2;
import com.example.booktravel.R;
  
/** 
 * @描述 在Fragment中要使用ListView，就要用ListFragment 
 * */  
public class Fragment1 extends ListFragment   {  
  
    private String TAG = Fragment1.class.getName();  
    private ListView list ;  
    private SimpleAdapter adapter;  
//    LinearLayout linearLayout1 = null;
//    LinearLayout linearLayout2 = null;
    /** 
     * @描述 在onCreateView中加载布局 
     * */  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
       // b = savedInstanceState;  
        Log.i(TAG, "--------onCreate");  
        String[] list = {"Class 1","Class 2","class 3","Class 4","Class 5","Class 6","Class 7","Class 8","Class 9","Class 10","Class 11","Class 12","Class 13","Class 1","Class 2","class 3","Class 4","Class 5","Class 6","Class 7","Class 8","Class 9","Class 10","Class 11","Class 12","Class 13"};  
        adapter = new SimpleAdapter(getActivity(), getData(list), R.layout.fruit_item, new String[]{"title"}, new int[]{R.id.title});  
        setListAdapter(adapter);  
       
    }  
    
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
        View view = inflater.inflate(R.layout.setting_layout, container,false);  
        list = (ListView) view.findViewById(android.R.id.list);  
        Log.i(TAG, "--------onCreateView");  
        return view;  
    }  
    
  
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.linearLayout1).setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(getActivity(), RegisterActivity2.class);
				startActivity(intent);
			}
	
		} );   
        view.findViewById(R.id.linearLayout2).setOnClickListener(new OnClickListener()
        {
        	@Override
        	public void onClick(View arg0)
        	{
        		Intent intent = new Intent();
				intent.setClass(getActivity(), MyBook.class);
				startActivity(intent);
        	}
        });
        //or
//        getActivity().findViewById(R.id.yourId).setOnClickListener(this);

    }

	@Override  
    public void onListItemClick(ListView l, View v, int position, long id) {  
        super.onListItemClick(l, v, position, id);  
          
        System.out.println(l.getChildAt(position));  
        HashMap<String, Object> view= (HashMap<String, Object>) l.getItemAtPosition(position);  
        System.out.println(view.get("title").toString()+"+++++++++title");  
        Toast.makeText(getActivity(), TAG+l.getItemIdAtPosition(position), Toast.LENGTH_LONG).show();  
        System.out.println(v);  
          
        System.out.println(position);  
          
          
    }  
      
   
      
  
    private List<? extends Map<String, ?>> getData(String[] strs) {  
        List<Map<String ,Object>> list = new ArrayList<Map<String,Object>>();  
          
        for (int i = 0; i < strs.length; i++) {  
            Map<String, Object> map = new HashMap<String, Object>();  
            map.put("title", strs[i]);  
            list.add(map);  
              
        }  
          
        return list;  
    }  
  
    @Override  
    public void onActivityCreated(Bundle savedInstanceState) {  
        super.onActivityCreated(savedInstanceState);  
        Log.i(TAG, "--------onActivityCreated");  
  
    }  
      
    @Override  
    public void onAttach(Activity activity) {  
        super.onAttach(activity);  
        Log.i(TAG, "----------onAttach");  
    }  
  
}  