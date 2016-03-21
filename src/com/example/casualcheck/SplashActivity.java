package com.example.casualcheck;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends Activity {
	String patient_id="";
	String physian_mail="";
	static boolean value = false;
	ImageView splashimg;
	ImageView logo;
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		splashimg=(ImageView)findViewById(R.id.imageView1);
		splashimg.setBackgroundResource(R.drawable.eyeanim);
		logo=(ImageView)findViewById(R.id.imageView2); 
		final Animation animBounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
		final AnimationDrawable anim=(AnimationDrawable)splashimg.getBackground();
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		splashimg.post(new Runnable(){
            @Override
         public void run() {
                anim.start();                
            	logo.startAnimation(animBounce);
            }            
        }); 
		/* myPrefs id the object and "pat_login" is the name of sharedpreference */
		SharedPreferences myPrefs = this.getSharedPreferences("pat_login", MODE_WORLD_READABLE);
		
		/* if physian_mail or patient_id does not exists then null will be assigned in the variable patient_id */
		patient_id = myPrefs.getString("PATIENT", null); 
		physian_mail = myPrefs.getString("PHYSIAN", null);
		
		new Handler().postDelayed(new Runnable() {
			public void run() {
				
				if (patient_id == null || physian_mail == null) {
					/* if both patient_id and physian_mail are null then go to LoginActivity to get these values */
				Intent j = new Intent(SplashActivity.this,LoginActivity.class);
				startActivity(j);
				finish();
				
				}
				else if (patient_id != null && physian_mail != null) {
					
					Intent i = new Intent(SplashActivity.this,Grid.class);
					startActivity(i);
					finish();
					
				}

			}
		}, 3000);

		
	}

}
