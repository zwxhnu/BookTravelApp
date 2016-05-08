package com.application.booktravel.login;

import com.application.booktravel.application.MyApplication;
import com.application.booktravel.common.Constants;
import com.application.booktravel.model.User;
import com.application.booktravel.register.RegisterActivity;
import com.application.booktravel.register.SmsActivity;
import com.application.booktravel.util.DialogFactory;
import com.application.booktravel.util.HttpUtil;
import com.application.booktravel.util.SharePreferenceUtil;
import com.example.booktravel.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
	private MyApplication application;
	private EditText userName, userPassword;
	private Button login;
	private TextView register;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.login_layout);
		application = (MyApplication) this.getApplicationContext();
		super.onCreate(savedInstanceState);
		initView();

		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String name = userName.getText().toString().trim();
				String password = userPassword.getText().toString().trim();
				if (name.equals("")) {
					Toast.makeText(LoginActivity.this, "�������ֻ���", 0).show();
				} else if (password.equals("")) {
					Toast.makeText(LoginActivity.this, "����������", 0).show();
				} else {
					showRequestDialog();
					User user = new User();
					user.setTel(userName.getText().toString().trim());
					user.setPassword(userPassword.getText().toString().trim());
					HttpUtil.login(LoginActivity.this, mDialog, user);
				}
			}
		});

		register.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
				Intent intent = new Intent(LoginActivity.this, SmsActivity.class);
				startActivity(intent);
			}
		});
	}

	public void initView() {
		SharePreferenceUtil util = new SharePreferenceUtil(this, Constants.SAVE_USER);
		userName = (EditText) findViewById(R.id.userName);
		userPassword = (EditText) findViewById(R.id.userPassword);
		login = (Button) findViewById(R.id.login);
		register = (TextView) findViewById(R.id.register);
		userName.setText(util.getTel());
		userPassword.setText(util.getPasswd());
		if (!isNetworkAvailable())
			toast(this);
	}

	private Dialog mDialog = null;

	/**
	 * ������֤�Ի���
	 */
	public void showRequestDialog() {
		if (mDialog != null) {
			mDialog.dismiss();
			mDialog = null;
		}
		mDialog = DialogFactory.creatRequestDialog(this, "������֤�˺š�����");
		mDialog.show();
	}

	/**
	 * �ж��ֻ������Ƿ����
	 * 
	 * @param context
	 * @return
	 */
	private boolean isNetworkAvailable() {
		ConnectivityManager mgr = (ConnectivityManager) getApplicationContext()
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo[] info = mgr.getAllNetworkInfo();
		if (info != null) {
			for (int i = 0; i < info.length; i++) {
				if (info[i].getState() == NetworkInfo.State.CONNECTED) {
					return true;
				}
			}
		}
		return false;
	}

	private void toast(Context context) {
		new AlertDialog.Builder(context).setTitle("��ܰ��ʾ").setMessage("�ף�������������δ��Ŷ")
				.setPositiveButton("ǰ����", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						Intent intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
						startActivity(intent);
					}
				}).setNegativeButton("ȡ��", null).create().show();
	}
}
