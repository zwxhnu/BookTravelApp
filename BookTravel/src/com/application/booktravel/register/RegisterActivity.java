package com.application.booktravel.register;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

import com.application.booktravel.model.User;
import com.application.booktravel.util.DialogFactory;
import com.application.booktravel.util.HttpUtil;
import com.example.booktravel.R;

public class RegisterActivity extends Activity {
	private EditText reg_name, reg_phone,reg_password,reg_password2,reg_captcha;
	private Button reg_getcaptcha, reg_nextstepbtn;

	private static String APPKEY = "12e00aa6dcaf7";

	private static String APPSECRET = "8866ff3b6b7aafae3509259cbc57837c";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.register_layout);
		super.onCreate(savedInstanceState);

		reg_name = (EditText) findViewById(R.id.reg_name);
		reg_phone = (EditText) findViewById(R.id.reg_phone);
		reg_password = (EditText) findViewById(R.id.reg_password);
		reg_password2 = (EditText) findViewById(R.id.reg_password2);
		//reg_getcaptcha = (Button) findViewById(R.id.reg_getcaptcha);
		reg_nextstepbtn = (Button) findViewById(R.id.reg_nextstepbtn);

//		SMSSDK.initSDK(this, APPKEY, APPSECRET, true);
//		SMSSDK.registerEventHandler(eh); // ע����Żص�
	
//		reg_getcaptcha.setOnClickListener(new OnClickListener() {
//
//			@SuppressLint("ShowToast") @Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				String name = reg_name.getText().toString().trim();
//				String phone = reg_phone.getText().toString().trim();
//				String password = reg_password.getText().toString().trim();
//				String password2 = reg_password2.getText().toString().trim();
//				if(name.equals(""))
//				{
//					Toast.makeText(RegisterActivity.this, "�������ǳ�", Toast.LENGTH_SHORT).show();
//				}else if(phone.equals(""))
//				{
//					Toast.makeText(RegisterActivity.this,"������绰",Toast.LENGTH_SHORT).show();
//				}else if(!isMobileNO(phone))
//				{
//					Toast.makeText(RegisterActivity.this,"��������ȷ�ĵ绰����",Toast.LENGTH_SHORT).show();
//				}else if(password.equals(""))
//				{
//					Toast.makeText(RegisterActivity.this, "����������", Toast.LENGTH_SHORT).show();
//				}
//				else if(!(password.equals(password2)))
//				{
//					Toast.makeText(RegisterActivity.this, "������������벻һ��", Toast.LENGTH_SHORT).show();
//				}
//				else
//				{
//				SMSSDK.getVerificationCode("86", reg_phone.getText().toString());
//				}
//			}
//		});

		reg_nextstepbtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				SMSSDK.submitVerificationCode("86", reg_phone.getText().toString(),
//						reg_captcha.getText().toString());
				User user = new User();
				user.setTel(reg_phone.getText().toString().trim());
				user.setPassword(reg_password.getText().toString().trim());
				user.setUsername(reg_name.getText().toString().trim());
				HttpUtil.register(RegisterActivity.this, mDialog, user);
				Intent intent = new  Intent();
				intent.setClass(RegisterActivity.this,AddPersonnalInfoActivity.class);
				startActivity(intent);
			}
		});
		
		
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
	
	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {

			if (msg.arg1 == SMSSDK.RESULT_COMPLETE) {
				// �ص����
				if (msg.arg2 == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
					// �ύ��֤��ɹ�
					Toast.makeText(getApplicationContext(), "��֤�ɹ�",
							Toast.LENGTH_SHORT).show();
					Log.e("sms", "��֤�ɹ�");
				} else if (msg.arg2 == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
					// ��ȡ��֤��ɹ�
					Toast.makeText(getApplicationContext(), "��֤�뷢�ͳɹ�",
							Toast.LENGTH_SHORT).show();
					Log.e("sms", "��֤�뷢�ͳɹ�");
				} else if (msg.arg2 == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
					// ����֧�ַ�����֤��Ĺ����б�
				}
			} else {
				// ((Throwable)data).printStackTrace();
			}

		};
	};

	EventHandler eh = new EventHandler() {

		@Override
		public void afterEvent(int event, int result, Object data) {
			Log.e("sms", "" + result);
			Message msg = new Message();
			msg.arg1 = result;
			msg.arg2 = event;
			handler.sendMessage(msg);

		}
	};

}
