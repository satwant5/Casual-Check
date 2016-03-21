package com.example.casualcheck;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Msg extends Activity {
    Button send;
    EditText  emailbody;
    String phys,viseff="Test not Taken",coloreff1="Test not Taken",patient;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sndmsg);
//        ------------------------------------------
        SharedPreferences spf1=getSharedPreferences("visualacuity", MODE_WORLD_READABLE);
        viseff=spf1.getString("visualacuity",viseff);
        SharedPreferences spf2=getSharedPreferences("coloreff", MODE_WORLD_READABLE);
        coloreff1=spf2.getString("coloreff", coloreff1);
        //        -------------------------------------------
        emailbody = (EditText) findViewById(R.id.msgbody);
        send = (Button) findViewById(R.id.sendmsg);
        
        SharedPreferences spf = getSharedPreferences("pat_login", MODE_WORLD_READABLE);
    	 phys= spf.getString("PHYSIAN","phys");
   	    patient=spf.getString("PATIENT", patient);	
    	    send.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                sendmsg();
            }
        });
    }
 
    public void sendmsg(){
       
    	try {
			
			 Intent sendIntent = new Intent(Intent.ACTION_VIEW);
		     sendIntent.putExtra("sms_body",emailbody.getText()+"\nVISUALefficiency="+viseff+"\n COLOR efficiency="+coloreff1); 
		     sendIntent.setType("vnd.android-dir/mms-sms");
		     startActivity(sendIntent);
		        
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(),
					"SMS faild, please try again later!",
					Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}        
    }
      } 

