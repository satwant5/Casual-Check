package com.example.casualcheck;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class home23 extends Activity {
	TextView mTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main1);
		mTextView=(TextView)findViewById(R.id.text_id);
		mTextView.setText("E");
		mTextView.setTextSize(40);
		
		
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent mintent= new Intent();
				mintent.setClass(home23.this, home3.class);
				startActivity(mintent);
				finish();
				
			}
		} , 3000);
	}

		
	

}
