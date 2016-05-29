package com.application.booktravel.application;

import android.app.Application;
import android.app.NotificationManager;

public class MyApplication extends Application {
	private NotificationManager mNotificationManager;
	private int newMsgNum = 0;
	private int recentNum = 0;

	@Override
	public void onCreate() {
		super.onCreate();
	}

	public NotificationManager getmNotificationManager() {
		return mNotificationManager;
	}

	public void setmNotificationManager(NotificationManager mNotificationManager) {
		this.mNotificationManager = mNotificationManager;
	}

	public int getNewMsgNum() {
		return newMsgNum;
	}

	public void setNewMsgNum(int newMsgNum) {
		this.newMsgNum = newMsgNum;
	}

	public int getRecentNum() {
		return recentNum;
	}

	public void setRecentNum(int recentNum) {
		this.recentNum = recentNum;
	}
}
