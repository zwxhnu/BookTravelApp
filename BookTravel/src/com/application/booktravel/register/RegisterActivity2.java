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
					Toast.makeText(RegisterActivity2.this, "�������ǳ�", 0).show();
				} else if(!isMobileNO(phone))
				{
					Toast.makeText(RegisterActivity2.this,"��������ȷ�ĵ绰����",Toast.LENGTH_SHORT).show();
				}else if(password.equals(""))
				{
					Toast.makeText(RegisterActivity2.this, "����������", Toast.LENGTH_SHORT).show();
				}
					else if (!password.equals(password2)) {
					Toast.makeText(RegisterActivity2.this, "������������벻һ��!", 0).show();
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
	 * ������֤�Ի���
	 */
	public void showRequestDialog() {
		if (mDialog != null) {
			mDialog.dismiss();
			mDialog = null;
		}
		mDialog = DialogFactory.creatRequestDialog(this, "ע����...");
		mDialog.show();
	}

	public static boolean isMobileNO(String mobiles) {
        /*
			        �ƶ���134��135��136��137��138��139��150��151��157(TD)��158��159��187��188
			        ��ͨ��130��131��132��152��155��156��185��186
			        ���ţ�133��153��180��189����1349��ͨ��
			        �ܽ��������ǵ�һλ�ض�Ϊ1���ڶ�λ�ض�Ϊ3��5��8������λ�õĿ���Ϊ0-9
        */
        String telRegex = "[1][358]\\d{9}";//"[1]"�����1λΪ����1��"[358]"����ڶ�λ����Ϊ3��5��8�е�һ����"\\d{9}"��������ǿ�����0��9�����֣���9λ��
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
