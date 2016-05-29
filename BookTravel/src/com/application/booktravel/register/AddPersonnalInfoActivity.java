package com.application.booktravel.register;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.application.booktravel.activity.FragmentMainActivity;
import com.example.booktravel.R;

public class AddPersonnalInfoActivity extends Activity{
	private AlertDialog alertDialog;
	private int RadioButtonID[] = { R.id.rb_setPhoto1, R.id.rb_setPhoto2,
			R.id.rb_setPhoto3 };
	private RadioButton rb_dialog[] = new RadioButton[3];

	private static final int PHOTO_REQUEST_TAKEPHOTO = 1;
	private static final int PHOTO_REQUEST_GALLERY = 2;
	private static final int PHOTO_REQUEST_CUT = 3;
	File tempFile = new File(Environment.getExternalStorageDirectory()
			+ "/brithPhoto/", getPhotoFileName());
	String path = Environment.getExternalStorageDirectory() + "/brithPhoto/";
	private ImageView ib_upphoto;
	Button reg_nextstepbtn2 = null;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		setContentView(R.layout.addperinfo);
		super.onCreate(savedInstanceState);
		reg_nextstepbtn2 = (Button)findViewById(R.id.reg_nextstepbtn2);
		  viewInit();
	        newCreateFile() ;
		//����һ������ť����
	        reg_nextstepbtn2.setOnClickListener(new OnClickListener()
		{	
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent();
				intent.setClass(AddPersonnalInfoActivity.this,FragmentMainActivity.class);
				startActivity(intent);
			}
		});}
	  public void newCreateFile() {
			File file1 = new File(path);
		
			if (!file1.exists()) {

				System.out.println("============" + file1.mkdirs());
			}
	    }
	    public void viewInit() 
	    {
	    	ib_upphoto = (ImageView) this.findViewById(R.id.reviseHead);
			ib_upphoto.setOnClickListener(onClickListener);
	    }
	    
	    OnClickListener onClickListener = new OnClickListener() {

			public void onClick(View v) {
				int id = v.getId();
				if(id==R.id.reviseHead)
				{	
						showSetPhotoDialog();
				}
				if (id == R.id.rb_setPhoto1) {
					alertDialog.dismiss();
					
					Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
					
					intent1.putExtra(MediaStore.EXTRA_OUTPUT,
							Uri.fromFile(tempFile));
					startActivityForResult(intent1, PHOTO_REQUEST_TAKEPHOTO);
				} else if (id == R.id.rb_setPhoto2) {
					alertDialog.dismiss();
					Intent intent2 = new Intent(Intent.ACTION_PICK, null);
					intent2.setDataAndType(
							MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
					startActivityForResult(intent2, PHOTO_REQUEST_GALLERY);
				} else if (id == R.id.rb_setPhoto3) {
				}

			
			}
			};
			private void showSetPhotoDialog() {
				
				LayoutInflater layoutInflater = getLayoutInflater();
				
				View customLayout = layoutInflater.inflate(
						R.layout.showsetphotodailog,
						(ViewGroup) findViewById(R.id.customDialog));

				for (int i = 0; i < rb_dialog.length; i++) {
					rb_dialog[i] = (RadioButton) customLayout
							.findViewById(RadioButtonID[i]);
					rb_dialog[i].setOnClickListener(onClickListener);
				}

				alertDialog = new AlertDialog.Builder(this).setView(customLayout)
						.show();

				Window window = alertDialog.getWindow();
				window.setGravity(Gravity.BOTTOM); 
			}
			
			@Override
			protected void onActivityResult(int requestCode, int resultCode, Intent data) {
				// TODO Auto-generated method stub

				switch (requestCode) {
			
				case PHOTO_REQUEST_TAKEPHOTO:
					startPhotoZoom(Uri.fromFile(tempFile), 150);
					//if (centerIndex == 100) {
						
//					}
//					data1.setBrithPer_photo(tempFile.getPath());
//					break;

				case PHOTO_REQUEST_GALLERY:
					if (data != null) {

						startPhotoZoom(data.getData(), 150);
						
//						if (centerIndex == 100) {
//							editor.putString("photo", data.getDataString());
//						}
//						data1.setBrithPer_photo(data.getDataString());
//						System.out.println("----2222222----------------->>"
//								+ data.getDataString());

					}
					break;

				case PHOTO_REQUEST_CUT:
					if (data != null)
						setPicToView(data);
					break;
				}
				super.onActivityResult(requestCode, resultCode, data);
				
			}

			private void startPhotoZoom(Uri uri, int size) {
				Intent intent = new Intent("com.android.camera.action.CROP");
				intent.setDataAndType(uri, "image/*");
				
				intent.putExtra("crop", "true");

			
				intent.putExtra("aspectX", 1);
				intent.putExtra("aspectY", 1);

				
				intent.putExtra("outputX", size);
				intent.putExtra("outputY", size);
				intent.putExtra("return-data", true);

				startActivityForResult(intent, PHOTO_REQUEST_CUT);
			}

			
			private void setPicToView(Intent picdata) {
				Bundle bundle = picdata.getExtras();

				if (bundle != null) {
					Bitmap photo = bundle.getParcelable("data");
					ByteArrayOutputStream stream = new ByteArrayOutputStream();
					photo.compress(Bitmap.CompressFormat.JPEG, 100, stream);
					// Drawable drawable = new BitmapDrawable(photo);
					ib_upphoto.setImageBitmap(photo);
				}
			}

			// 浣跨敤绯荤粺褰撳墠鏃ユ湡鍔犱互璋冩暣浣滀负鐓х墖鐨勫悕绉�
			private String getPhotoFileName() {
				Date date = new Date(System.currentTimeMillis());
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"'IMG'_yyyyMMdd_HHmmss");
				return dateFormat.format(date) + ".jpg";

			}
	    
	    
}
