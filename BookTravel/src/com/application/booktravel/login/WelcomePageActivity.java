package com.application.booktravel.login;

import com.application.booktravel.common.Constants;
import com.application.booktravel.util.SharePreferenceUtil;
import com.example.booktravel.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class WelcomePageActivity extends Activity {
	private SharePreferenceUtil util;
	private Handler mHandler;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.welcome_layout);
		util = new SharePreferenceUtil(this, Constants.SAVE_USER);
		initView();
	}

	public void initView() {
		// if (util.getIsStart()) {// 如果是首次运行
		mHandler = new Handler();
		mHandler.postDelayed(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				goLoginActivity();
			}
		}, 1000);
		// }
	}

	/**
	 * 进入登陆界面
	 */
	public void goLoginActivity() {
		Intent intent = new Intent();
		intent.setClass(this, LoginActivity.class);
		startActivity(intent);
		finish();
	}
}
