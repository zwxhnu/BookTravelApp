package com.application.booktravel.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import android.R.color;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.booktravel.R;
import com.readystatesoftware.viewbadger.BadgeView;
/**
 * 话题圈
 * image_mail为消息按钮4
 * image_pulsh为右边的加号按钮
 */

@SuppressLint("NewApi")
public class ContactsFragment extends Fragment {
	private ImageView image_mail;
	private ImageView image_pulsh;
	private ListView lv;
	private String topic_neirong="hahahhhhhhhhhhhhhahahhahahhahah"
			+ "hahahahahahahahahahahahhahahaahahahhaahahahah"
			+ "hahahah";
	private int lovenum=0;
	private int commentnum=0;
	ArrayList<HashMap<String, Object>>listitem;
	View image_mail1;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.contacts_layout, container, false);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		image_mail=(ImageView)getView().findViewById(R.id.image_mail);
		image_pulsh=(ImageView)getView().findViewById(R.id.image_pulsh);
		lv=(ListView) getView().findViewById(R.id.lv);
		image_mail1=image_mail;
		BadgeView bage=new BadgeView(getActivity(), image_mail1);
		bage.setText("0");
		bage.setTextColor(color.holo_red_dark);
		bage.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);
		bage.setBadgeMargin(0,0);
		bage.setAlpha(1f);
		bage.show();
		Myadapter madapter=new Myadapter(getActivity());
		lv.setAdapter(madapter);
	}
	private ArrayList<HashMap<String, Object>> getDate(){
	    ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,Object>>();
	    /*为动态数组添加数据*/    
	    for(int i=0;i<30;i++)  
	         {  
	             HashMap<String, Object> map = new HashMap<String, Object>();  
	             map.put("username", "第"+i+"行");  
	             map.put("bookname", "这是第"+i+"行");
	             map.put("userphoto", R.drawable.ass);
	             map.put("title", "话题标题");
	             map.put("topicnrirong", topic_neirong);
	             map.put("dianzanshu",lovenum);
	             map.put("pinglunshu", commentnum);
	             listItem.add(map);  
	         } 
	        return listItem;
	    
	    }
public final class ViewHolder{
	public TextView username;
	public TextView book_name;
	public ImageView image;
	public TextView topic_title;
	public TextView neirong;
	public Button dianzhan;
	public TextView dianzanshu;
	public Button pinglun;
	public TextView pinglunshu;
}
private class Myadapter extends BaseAdapter{
	private LayoutInflater minflater;

	public Myadapter(Context context) {
		// TODO Auto-generated constructor stub
		this.minflater=LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return getDate().size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(final int position, View convertView, ViewGroup aparentr) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		 if (convertView == null) {
             convertView = minflater.inflate(R.layout.topiclistitem,null);
              holder = new ViewHolder();
         /*得到各个控件的对象*/                    
             holder.username = (TextView) convertView.findViewById(R.id.user_nickname);
             holder.book_name = (TextView) convertView.findViewById(R.id.bookname);
             holder.image=(ImageView)convertView.findViewById(R.id.user_photo);
             holder.topic_title=(TextView)convertView.findViewById(R.id.text_title);
             holder.neirong=(TextView)convertView.findViewById(R.id.text_neirong);
             holder.dianzhan=(Button)convertView.findViewById(R.id.button_dianzan);
             holder.dianzanshu=(TextView)convertView.findViewById(R.id.text_dianzajn);
             holder.pinglun=(Button)convertView.findViewById(R.id.button_pinglun);
             holder.pinglunshu=(TextView)convertView.findViewById(R.id.text_pinglun);
             convertView.setTag(holder);//绑定ViewHolder对象                
             }
             else{
             holder = (ViewHolder)convertView.getTag();//取出ViewHolder对象        
             }
     		/*设置TextView显示的内容，即我们存放在动态数组中的数据*/             
             holder.username.setText(getDate().get(position).get("username").toString());
             holder.book_name.setText(getDate().get(position).get("bookname").toString());
             holder.image.setImageResource(Integer.parseInt(getDate().get(position).get("userphoto").toString()));
             holder.topic_title.setText(getDate().get(position).get("title").toString());	
             holder.neirong.setText(getDate().get(position).get("topicnrirong").toString());
             holder.dianzanshu.setText(getDate().get(position).get("dianzanshu").toString());
             holder.pinglunshu.setText(getDate().get(position).get("pinglunshu").toString());
             /*为Button添加点击事件*/            
     return convertView;
 }
}

}
