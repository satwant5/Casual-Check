package com.example.casualcheck;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class color_test extends Activity{
	Button mButton;
	public static String i="0";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.color_layout2);
		mButton=(Button)findViewById(R.id.button_color);
		mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent=new Intent(color_test.this,color_test1.class);
				mIntent.putExtra("color_i2", i);
				startActivity(mIntent);
				
			}
		});
	}

}
