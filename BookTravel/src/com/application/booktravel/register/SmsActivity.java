package com.application.booktravel.register;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

import com.application.booktravel.model.User;
import com.application.booktravel.util.DialogFactory;
import com.application.booktravel.util.HttpUtil;
import com.example.booktravel.R;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsActivity extends Activity {
	private EditText phone, code;
	private Button reg, send;

	private static String APPKEY = "127ff32f00db6";

	private static String APPSECRET = "2353e8833ac3e94c039014e388df2a14";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.sms_layout);
		super.onCreate(savedInstanceState);

		phone = (EditText) findViewById(R.id.reg_phone);
		code = (EditText) findViewById(R.id.reg_password2);
		send = (Button) findViewById(R.id.send_btn);
		reg = (Button) findViewById(R.id.register_btn);

		SMSSDK.initSDK(this, APPKEY, APPSECRET, true);
		SMSSDK.registerEventHandler(eh); // ע����Żص�

		send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SMSSDK.getVerificationCode("86", phone.getText().toString());

			}
		});

		reg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SMSSDK.submitVerificationCode("86", phone.getText().toString(),
						code.getText().toString());
			}
		});
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
