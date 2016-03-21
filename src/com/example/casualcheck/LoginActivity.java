package com.example.casualcheck;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	Button submit; 
	  EditText patient_id, phys_email;
	
	 AlertDialogManager alert = new AlertDialogManager();
	//TextView doctorlogin;
	 public final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
             "[a-zA-Z0-9+._%-+]{1,256}" +
             "@" +
             "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" +
             "(" +
             "." +
             "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" +
             ")+"
         );
	 public final Pattern userPattern = Pattern.compile(
	    		"[a-zA-z]{3,30}"
	    		);
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_login);
		patient_id=(EditText)findViewById(R.id.edittext_patientid);
		phys_email=(EditText)findViewById(R.id.edittext_physianemail);
		submit=(Button)findViewById(R.id.btnLogin);
		submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			String pat= patient_id.getText().toString().trim();
			String phys= phys_email.getText().toString().trim();
		
					try
					{
						  if(checkEmail(phys) && checkptientid(pat))
	                 	 {
	                       Toast.makeText(LoginActivity.this,"ALL VALID DATA", Toast.LENGTH_SHORT).show();
	               		SharedPreferences spf= getSharedPreferences("pat_login", MODE_MULTI_PROCESS);

					SharedPreferences.Editor spfe= spf.edit();
					spfe.putString("PATIENT", pat);
					spfe.putString("PHYSIAN", phys);
					spfe.commit();
				//	phys_email.setError("Field cant be blank");
					//patient_id.setError("Field cant be blank");
					Toast mToast= Toast.makeText(getApplicationContext(), "DATA IS SAVED", 0);
					mToast.setGravity(Gravity.CENTER, 0, 0);
					mToast.show();
					Intent mIntent =new Intent(LoginActivity.this, Grid.class);	
					startActivity(mIntent);
	                 	 }
						  else
	                      {
	                   alert.showAlertDialog(LoginActivity.this, "Registeration failed...", "Please enter valid data", false);
	                      }
				}
				catch(Exception e)
				{
					Log.d("Exception", e.getMessage());
				}
				
			}
		});
//		doctorlogin=(TextView)findViewById(R.id.txtdoclog);
//		doctorlogin.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//			Intent intent=new Intent(LoginActivity.this, doctr_login.class);	
//			startActivity(intent);
//			}
//		});
}
		
		private boolean checkEmail(String email) {
	         return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
	     }
		  private boolean checkptientid(String patientid)
	      {
	      	return userPattern.matcher(patientid).matches();
	      }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

}
