package com.example.casualcheck;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class efficiency_color extends Activity{
	TextView mTextView;
	RelativeLayout rv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.efficiency_layout);
		mTextView=(TextView)findViewById(R.id.textView1_eff);
		Bundle mBundle=getIntent().getExtras();
		String value=mBundle.getString("eff_digit");
		mTextView.setText(value+"%");
		SharedPreferences color_eff=getSharedPreferences("coloreff", MODE_WORLD_READABLE);
		SharedPreferences.Editor ed=color_eff.edit();
		ed.putString("coloreff", value+"%");
		ed.commit();
		rv=(RelativeLayout)findViewById(R.id.relative);
		rv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent it= new Intent(efficiency_color.this, Grid.class);
				startActivity(it);
			};
		});
	}

}
