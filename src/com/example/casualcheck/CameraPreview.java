package com.example.casualcheck;

import java.io.IOException;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class CameraPreview extends SurfaceView implements Callback {
	public SurfaceHolder mSurfaceHolder;
	public Camera mCamera;
	boolean previewing=false;
	int id;
	// Constructor that obtains context and camera
	@SuppressWarnings("deprecation")
	public CameraPreview(Context context, Camera camera, int id) {
		super(context);
		this.mCamera = camera;
		this.mSurfaceHolder = this.getHolder();
		this.mSurfaceHolder.addCallback(this);
		this.mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		this.id=id;
	}

	@Override
	public void surfaceCreated(SurfaceHolder surfaceHolder) {
		try {

			mCamera.setDisplayOrientation(90);
			mCamera.setPreviewDisplay(surfaceHolder);
			mCamera.startPreview();
		} catch (IOException e) {
			// left blank for now
			Log.d("MY Tag", "Debug message");
		}
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
		mCamera.stopPreview();
		mCamera.release();
		mCamera=null;
		previewing=false;
	}

	@Override
	public void surfaceChanged(SurfaceHolder surfaceHolder, int format,
			int width, int height) {
		// start preview with new settings
		if(previewing)
		{
			mCamera.stopPreview();
			previewing=false;
		}
		if(mCamera!=null)
		{
		try {
			mCamera.setPreviewDisplay(surfaceHolder);
			mCamera.startPreview();
			previewing=true;
		} catch (Exception e) {
			// intentionally left blank for a test
			e.printStackTrace();
		}
		}	}

}
