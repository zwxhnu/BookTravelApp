package com.application.booktravel.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.application.booktravel.activity.CopyRight;
import com.application.booktravel.constants.Constants;
import com.application.booktravel.util.SharePreferenceUtil;
import com.example.booktravel.R;

public class WelcomePageActivity extends Activity{
	private SharePreferenceUtil util;
	private Handler mHandler;
	private TextView welcome_text2;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.welcome_layout);
		util = new SharePreferenceUtil(this, Constants.SAVE_USER);
		initView();
		welcome_text2 = (TextView)findViewById(R.id.welcome_text2);
		welcome_text2.setOnClickListener(new OnClickListener()
	{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(WelcomePageActivity.this,CopyRight.class);
		}
			
		});
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
