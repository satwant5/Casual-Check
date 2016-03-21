package com.example.casualcheck;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class efficiency extends Activity{
	TextView mTextView;
	RelativeLayout rv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.efficiency_layout);
		mTextView=(TextView)findViewById(R.id.textView1_eff);
		rv=(RelativeLayout)findViewById(R.id.relative);
		Bundle mBundle=getIntent().getExtras();
		String efficiency=mBundle.getString("eff");
//		----------------------------------saving
		SharedPreferences visact_eff=getSharedPreferences("visualacuity", MODE_WORLD_READABLE);
		SharedPreferences.Editor ed=visact_eff.edit();
		ed.putString("visualacuity", efficiency);
		ed.commit();
//		----------------------------------------
		mTextView.setText(efficiency);
		rv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it= new Intent(efficiency.this, Grid.class);
				startActivity(it);
				
			}
		});
	}

}
