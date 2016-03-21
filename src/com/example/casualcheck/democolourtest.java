package com.example.casualcheck;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class democolourtest extends Activity {
	ImageView im;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ready);
		im=(ImageView)findViewById(R.id.ready);
		im.setBackgroundResource(R.drawable.ready);
		final AnimationDrawable anim=(AnimationDrawable)im.getBackground();
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		im.post(new Runnable(){
            @Override
         public void run() {
                anim.start();                
               
            }            
        }); 
			new Handler().postDelayed(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					String i="0";
					Intent in=new Intent(democolourtest.this,color_test1.class);
					in.putExtra("color_i2", i);
					startActivity(in);
					finish();
				}
			}, 4000); 
				
				
	}
}


