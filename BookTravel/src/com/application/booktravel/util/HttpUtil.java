package com.application.booktravel.util;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.application.booktravel.activity.FragmentMainActivity;
import com.application.booktravel.constants.Constants;
import com.application.booktravel.model.User;

public class HttpUtil extends Activity{

	/**
	 * 用户登录请求
	 * 
	 * @param mcontext
	 * @param mdialog
	 * @param user
	 */
	public static void login(final Context mcontext, final Dialog mdialog, final User user) {
		String url = Constants.URL + "UserLogin.action";
		AjaxParams params = new AjaxParams();
		params.put("userphone", user.getTel());
		params.put("password", user.getPassword());
		FinalHttp fh = new FinalHttp();
		fh.post(url, params, new AjaxCallBack<String>() {
			@Override
			public void onSuccess(String t) {
				// TODO Auto-generated method stub
				try {
					JSONObject json = new JSONObject(t);
					int code = json.getInt("code");
					if (code == 100) {
						Toast.makeText(mcontext, "手机号未被注册", 0).show();
					} else if (code == 500) {
						Toast.makeText(mcontext, "密码错误", 0).show();
					} else if (code == 200) {
						JSONObject user = json.getJSONObject("user");
						Toast.makeText(mcontext, "登录成功", 0).show();
						SharePreferenceUtil share = new SharePreferenceUtil(mcontext, Constants.SAVE_USER);
						share.setId(user.getString("userid"));
						share.setName(user.getString("username"));
						share.setPasswd(user.getString("password"));
						share.setPhoto(user.getString("photo"));
						share.setTel(user.getString("tel"));
						Toast.makeText(mcontext, share.getId() + "-" + share.getName() + "-" + share.getTel() + "-"
								+ share.getPasswd() + "-" + share.getPhoto(), 0).show();
						Intent intent = new Intent();
						Bundle bundle = new Bundle();
						bundle.putString("tel", share.getTel());
						intent.putExtras(bundle);
						intent.setClass(mcontext, FragmentMainActivity.class);
						mcontext.startActivity(intent);
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Toast.makeText(mcontext, e.getMessage(), 0).show();
				} finally {
					if (mdialog.isShowing())
						mdialog.dismiss();
				}
			}

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// TODO Auto-generated method stub
				Toast.makeText(mcontext, "请确认网络状况", 0).show();
				super.onFailure(t, errorNo, strMsg);
			}
		});
	}

	/**
	 * 用户注册请求
	 * 
	 * @param mcontext
	 * @param user
	 */
	public synchronized static  void register(final Context mcontext, final Dialog mDialog, final User user) {
		String url = Constants.URL + "UserRegister.action";
		AjaxParams params = new AjaxParams();
		params.put("userphone", user.getTel());
		params.put("userpassword", user.getPassword());
		params.put("username", user.getUsername());
		FinalHttp fh = new FinalHttp();
		fh.post(url, params, new AjaxCallBack<String>() {
			@Override
			public void onSuccess(String t) {
				// TODO Auto-generated method stub
				try {
					JSONObject json = new JSONObject(t);
					int code = json.getInt("code");
					if (code == 100) {
						Toast.makeText(mcontext, "手机号已被注册", 0).show();
//						gotoLogin(mcontext);
						} else if (code == 200) {
						Toast.makeText(mcontext, "注册成功", 0).show();
					} else {
						Toast.makeText(mcontext, "注册失败", 0).show();
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (mDialog.isShowing()) {
						mDialog.dismiss();
					}
				}
			}
			
			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// TODO Auto-generated method stub
				Toast.makeText(mcontext, "请确认网络状况", 0).show();
				super.onFailure(t, errorNo, strMsg);
			}
		});
	}
//	public static void gotoLogin(Context mContext)
//	{
//		 
//		Intent intent = new Intent();  
//		intent.setAction("com.xiazdong.action");  
//		intent.addCategory("com.xiazdong.category");  
//		intent.setData(Uri.parse("xiazdong://www.xiazdong.com/xia"));  
//		mContext.startActivity(intent);      //此方法中调用intent.addCategory("android.intent.category.DEFAULT");  
//	}
}
