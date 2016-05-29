package com.application.booktravel.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreferenceUtil {
	private SharedPreferences sp;
	private SharedPreferences.Editor editor;

	public SharePreferenceUtil(Context context, String file) {
		sp = context.getSharedPreferences(file, context.MODE_PRIVATE);
		editor = sp.edit();
	}

	public void setTel(String tel) {
		editor.putString("tel", tel);
		editor.commit();
	}

	public String getTel() {
		return sp.getString("tel", "");
	}

	public void setPhoto(String photo) {
		editor.putString("photo", photo);
		editor.commit();
	}

	public String getPhoto() {
		return sp.getString("photo", "");
	}

	public void setPasswd(String passwd) {
		editor.putString("passwd", passwd);
		editor.commit();
	}

	public String getPasswd() {
		return sp.getString("passwd", "");
	}

	public void setId(String id) {
		editor.putString("id", id);
		editor.commit();
	}

	public String getId() {
		return sp.getString("id", "");
	}

	public String getName() {
		return sp.getString("name", "");
	}

	public void setName(String name) {
		editor.putString("name", name);
		editor.commit();
	}
}
