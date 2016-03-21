package com.example.casualcheck;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SendBtn extends Activity {
	
	Button sendreport,sendmessage;
	private String viseff="nil",coloreff1="nil",eyescan="Test not taken";
	TextView tv1,tv2,tv3;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.report);
		tv1=(TextView)findViewById(R.id.viss);
		tv2=(TextView)findViewById(R.id.color);
		tv3=(TextView)findViewById(R.id.eyescan);
		//    ------------------------------------------
        SharedPreferences spf1=getSharedPreferences("visualacuity", MODE_WORLD_READABLE);
        viseff=spf1.getString("visualacuity",viseff);
        SharedPreferences spf2=getSharedPreferences("coloreff", MODE_WORLD_READABLE);
        coloreff1=spf2.getString("coloreff", coloreff1);
        SharedPreferences spf3=getSharedPreferences("eyescan", MODE_WORLD_READABLE);
        eyescan=spf3.getString("eyescan",eyescan);
        tv1.setText(viseff);
		tv2.setText(coloreff1);
		tv3.setText(eyescan);
		sendreport=(Button)findViewById(R.id.sendreport);
		sendreport.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent it = new Intent(SendBtn.this, email.class);
			startActivity(it);
			
			}
		});
		sendmessage=(Button)findViewById(R.id.sndmsg1);
		sendmessage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(SendBtn.this, Msg.class);
				startActivity(it);
			}
		});
	}
}
