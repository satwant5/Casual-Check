package com.example.casualcheck;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class home45 extends Activity {
	TextView mTextView;
		@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main1);
		mTextView=(TextView)findViewById(R.id.text_id);
		mTextView.setText("U");
		//mTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
		mTextView.setTextSize(10);
		
		
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent mintent= new Intent();
				mintent.setClass(home45.this, home5.class);
				
				startActivity(mintent);
				finish();
				
			}
		} , 3000);
	}

}
