package com.application.booktravel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

public class MyListView extends ListView{
	
	/**
	 * pull state,pull up or pull down;PULL_UP_STATE or PULL_DOWN_STATE
	 */	
	int mLastMotionY ;
	
	boolean bottomFlag;
	
	public MyListView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public MyListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	public MyListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		//��ֹ���������¼�
		if(bottomFlag){
			getParent().requestDisallowInterceptTouchEvent(true);
		}
		
		return super.onInterceptTouchEvent(ev);
	}
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		int y = (int) ev.getRawY();
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			// ��������down�¼�,��¼y����
			mLastMotionY = y;
			break;
		case MotionEvent.ACTION_MOVE:
			// deltaY > 0 �������˶�,< 0�������˶�
			int deltaY = y - mLastMotionY;
			
			if(deltaY>0){
				View child = getChildAt(0);
				if(child!=null){
					
				
					if (getFirstVisiblePosition() == 0
							&& child.getTop() == 0) {
							bottomFlag = false;
							getParent().requestDisallowInterceptTouchEvent(false); 
						}
					
					int top = child.getTop();
					int padding = getPaddingTop();
					if (getFirstVisiblePosition() == 0
							&& Math.abs(top - padding) <= 8) {//����֮ǰ��3�����ж�,�����ڲ���,��û�ҵ�ԭ��
							bottomFlag = false;
							getParent().requestDisallowInterceptTouchEvent(false); 
				
						}
				}
			}
			break;
		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_CANCEL:
			break;
		}
		
		
	
		return super.onTouchEvent(ev);
	}
	
	public void setBottomFlag(boolean flag){
		bottomFlag = flag;
	}
}
