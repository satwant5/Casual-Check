package com.example.casualcheck;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView mTextView;
	EditText mEditText;
	//public static String text="A";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main1);
		mTextView=(TextView)findViewById(R.id.text_id);
		mTextView.setText("G");
		mTextView.setTextSize(140);
		
				
		//mTextView.setText('A');
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent mintent= new Intent();
				mintent.setClass(MainActivity.this, Khome0.class);
				startActivity(mintent);
				finish();
				
			}
		} , 1000);
	}

	
}
