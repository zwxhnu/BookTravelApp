package com.application.booktravel.register;

import com.application.booktravel.model.User;
import com.application.booktravel.util.DialogFactory;
import com.application.booktravel.util.HttpUtil;
import com.example.booktravel.R;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	private EditText reg_name, reg_password, reg_password2, reg_phone;
	private Button register_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.register_layout);
		super.onCreate(savedInstanceState);
		initView();
		register_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name = reg_name.getText().toString().trim();
				String password = reg_password.getText().toString().trim();
				String password2 = reg_password2.getText().toString().trim();
				String phone = reg_phone.getText().toString().trim();
				if (name.equals("") || password.equals("") || phone.equals("")) {
					Toast.makeText(RegisterActivity.this, "带*为必填项", 0).show();
				} else if (!password.equals(password2)) {
					Toast.makeText(RegisterActivity.this, "两次输入的密码不一致!", 0).show();
				} else {
					showRequestDialog();
					User user = new User();
					user.setUsername(name);
					user.setPassword(password);
					user.setTel(phone);
					HttpUtil.register(RegisterActivity.this, mDialog, user);
				}
			}
		});
	}

	public void initView() {
		reg_name = (EditText) findViewById(R.id.reg_name);
		reg_password = (EditText) findViewById(R.id.reg_password);
		reg_password2 = (EditText) findViewById(R.id.reg_password2);
		reg_phone = (EditText) findViewById(R.id.reg_phone);
		register_btn = (Button) findViewById(R.id.register_btn);
	}

	private Dialog mDialog = null;

	/**
	 * 弹出验证对话框
	 */
	public void showRequestDialog() {
		if (mDialog != null) {
			mDialog.dismiss();
			mDialog = null;
		}
		mDialog = DialogFactory.creatRequestDialog(this, "注册中...");
		mDialog.show();
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		finish();
	}
}
