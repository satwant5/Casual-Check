package com.example.casualcheck;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

public class MakePhotoActivity extends Activity {

	private Camera mCamera;
	private CameraPreview mCameraPreview;
	LayoutInflater controlInflater,controlInflater1;
	int stepno=0;
	FrameLayout preview;
	View viewControl;
	ProgressDialog mDialog;
	Boolean clicked=false;
	String picname="";
	int id=0;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_make_photo);
		preview = (FrameLayout) findViewById(R.id.frame1);
		mCamera = getCameraInstance();
		mCameraPreview = new CameraPreview(this, mCamera,id);
		preview.addView(mCameraPreview);
		controlInflater = LayoutInflater.from(getBaseContext());

//-------------------------------------initial overlay------------------------------------------		
		viewControl = controlInflater.inflate(R.layout.demo_camera, null);
		preview.addView(viewControl);
//---------------------------------------------------------------------------------------------		


		preview.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(stepno==0) 
				{	
					stepno++;
					overlay();
				}
				else if(!clicked)
					{
					mDialog=new ProgressDialog(v.getContext());
					mDialog.setCancelable(false);
					mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
					mDialog.show();
					mCamera.takePicture(null, null, mPicture);
					clicked=true;
					}
				
			}

		});

		

		Button retake=(Button)findViewById(R.id.btn_retake);
		retake.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(clicked)
				{
					try {
						mCameraPreview.mCamera.setPreviewDisplay(mCameraPreview.mSurfaceHolder);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mCameraPreview.mCamera.startPreview();
					clicked=false;
				}	
			}

		});
		Button ok = (Button) findViewById(R.id.btn_ok);
		ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(clicked)
				{
					try {
						mCameraPreview.mCamera.setPreviewDisplay(mCameraPreview.mSurfaceHolder);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mCameraPreview.mCamera.startPreview();
					stepno++;
					overlay();
					clicked=false;
				}}
		});
	}
	//---------------------------------------------opening camera function----------------------------------------------

	private Camera getCameraInstance() {
		Camera camera = null;
		try 
		{
			camera = Camera.open(getFrontCameraId());
		} 
		catch (Exception e) {
			// cannot get camera or does not exist
			Log.d(" camera", "no camera");
			Camera.open();
		}
		return camera;
	}

	//-----------------------------on capturing picture--------------------------------------------------------
	PictureCallback mPicture = new PictureCallback() {
		@Override
		public void onPictureTaken(byte[] data, Camera camera) {


			File pictureFile = getOutputMediaFile();
			if (pictureFile == null) {
				return;
			}
			try {
				FileOutputStream fos = new FileOutputStream(pictureFile);
				fos.write(data);
				fos.close();
				mDialog.dismiss();
			} catch (FileNotFoundException e) {

			} catch (IOException e) {
			}
		}
	};

	private File getOutputMediaFile() {

		File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"CasualCheck");
		if (!mediaStorageDir.exists()) {
			if (!mediaStorageDir.mkdirs()) {
				Log.d("CasualCheck", "failed to create directory");
				return null;
			}
		}

		//--------------- Create a media file name------------------------
		switch (stepno) {
		case 1:
			picname="Botheyes";
			break;
		case 2:
			picname="Righteye";
			break;
		case 3:
			picname="Lefteye";
			break;
		case 4:
			picname="pills";
			break;
		case 5:
			break;
		default:
			picname="";
		}

		//		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
		//		.format(new Date());
		File mediaFile;
		mediaFile = new File(mediaStorageDir.getPath() + File.separator
				+ "Img" + picname + ".jpg");
		return mediaFile;
	}
	//------------------------front camera coding------------------------

	public int getFrontCameraId() {
		CameraInfo ci = new CameraInfo();
		for (id = 0 ; id<Camera.getNumberOfCameras(); id++) {
			Camera.getCameraInfo(id, ci);
			if (ci.facing == CameraInfo.CAMERA_FACING_FRONT) 
				return id;
		}
		Log.d("no front", "camera");
		return -1; // No front-facing camera found
	}
	//-------------------------------------------------------------------
	//------------------------------inflating views----------------------------------
	public void overlay()
	{

		switch (stepno) {
		case 1:
			preview.removeView(viewControl);	
			controlInflater = LayoutInflater.from(getBaseContext());
			viewControl = controlInflater.inflate(R.layout.btheye, null);
			preview.addView(viewControl);
			break;
		case 2:
			preview.removeView(viewControl);
			controlInflater = LayoutInflater.from(getBaseContext());
			viewControl = controlInflater.inflate(R.layout.righteye, null);
			preview.addView(viewControl);
			break;
		case 3:
			preview.removeView(viewControl);
			controlInflater = LayoutInflater.from(getBaseContext());
			viewControl = controlInflater.inflate(R.layout.lefteye, null);
			preview.addView(viewControl);
			break;
		case 4:
			preview.removeView(viewControl);
			controlInflater = LayoutInflater.from(getBaseContext());
			viewControl = controlInflater.inflate(R.layout.pills, null);
			preview.addView(viewControl);
			break;
		case 5:
			
			Intent it= new Intent(MakePhotoActivity.this,Grid.class );
			SharedPreferences color_eff=getSharedPreferences("eyescan", MODE_WORLD_READABLE);
			SharedPreferences.Editor ed=color_eff.edit();
			ed.putString("eyescan","Test Taken");
			ed.commit();
			startActivity(it);
			break;
		default:
			finish();
		}	

	}

	//-------------------------------------------------------------------------------
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

}
