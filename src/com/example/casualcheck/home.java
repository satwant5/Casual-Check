package com.example.casualcheck;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class home extends Activity{
	Button tktest, settings, demotest;
	String physian, patient;
	 AlertDialogManager alert = new AlertDialogManager();
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		tktest=(Button)findViewById(R.id.tktest);
		settings=(Button)findViewById(R.id.settings);
		demotest=(Button)findViewById(R.id.demotest);
		 SharedPreferences sp = getSharedPreferences("pat_login", MODE_WORLD_READABLE);
	        physian= sp.getString("PHYSIAN","physian");
	        patient=sp.getString("PATIENT","patient");     
	        tktest.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(home.this,Grid.class);
				startActivity(intent);
			}
		});
		     settings.setOnClickListener(new OnClickListener() {
			 @Override
			 public void onClick(View arg0) {
				// TODO Auto-generated method stub
			 Intent it= new Intent(home.this,LoginActivity.class);
			 startActivity(it);
			}
		});
		     demotest.setOnClickListener(new OnClickListener() {
			 @Override
			 public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(home.this,Demo_tour.class);
				startActivity(it);		
			}
		});
}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	    alert.showAlertDialog(home.this, "Warning", "All the information of the application will be lost. Do you wish to continue?", true);
	}
	
}