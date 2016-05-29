package com.application.booktravel.register;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.application.booktravel.model.User;
import com.application.booktravel.util.DialogFactory;
import com.application.booktravel.util.HttpUtil;
import com.example.booktravel.R;

public class RegisterActivity2 extends Activity {
	private EditText reg_name, reg_password, reg_password2, reg_phone;
	private Button reg_nextstepbtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.register_layout);
		super.onCreate(savedInstanceState);
		initView();
		reg_nextstepbtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name = reg_name.getText().toString().trim();
				String password = reg_password.getText().toString().trim();
				String password2 = reg_password2.getText().toString().trim();
				String phone = reg_phone.getText().toString().trim();
				if (name.equals("") ) {
					Toast.makeText(RegisterActivity2.this, "请输入昵称", 0).show();
				} else if(!isMobileNO(phone))
				{
					Toast.makeText(RegisterActivity2.this,"请输入正确的电话号码",Toast.LENGTH_SHORT).show();
				}else if(password.equals(""))
				{
					Toast.makeText(RegisterActivity2.this, "请输入密码", Toast.LENGTH_SHORT).show();
				}
					else if (!password.equals(password2)) {
					Toast.makeText(RegisterActivity2.this, "两次输入的密码不一致!", 0).show();
				} else {
					showRequestDialog();
					User user = new User();
					user.setUsername(name);
					user.setPassword(password);
					user.setTel(phone);
					HttpUtil.register(RegisterActivity2.this, mDialog, user);
					Intent intent = new  Intent();
					intent.setClass(RegisterActivity2.this,AddPersonnalInfoActivity.class);
					startActivity(intent);
				}
			}
		});
	}

	public void initView() {
		reg_name = (EditText) findViewById(R.id.reg_name);
		reg_password = (EditText) findViewById(R.id.reg_password);
		reg_password2 = (EditText) findViewById(R.id.reg_password2);
		reg_phone = (EditText) findViewById(R.id.reg_phone);
		reg_nextstepbtn = (Button) findViewById(R.id.reg_nextstepbtn);
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

	public static boolean isMobileNO(String mobiles) {
        /*
			        移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
			        联通：130、131、132、152、155、156、185、186
			        电信：133、153、180、189、（1349卫通）
			        总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
        */
        String telRegex = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		finish();
	}
}
