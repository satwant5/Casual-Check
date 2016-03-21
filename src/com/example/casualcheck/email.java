package com.example.casualcheck;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class email extends Activity {
    Button send;
    EditText  subject, emailbody;
    TextView address;
    String phys,viseff="Test not Taken",coloreff1="Test not Taken",patient;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_email);
//        ------------------------------------------
        SharedPreferences spf1=getSharedPreferences("visualacuity", MODE_WORLD_READABLE);
        viseff=spf1.getString("visualacuity",viseff);
        SharedPreferences spf2=getSharedPreferences("coloreff", MODE_WORLD_READABLE);
        coloreff1=spf2.getString("coloreff", coloreff1);
        //        -------------------------------------------
        address = (TextView) findViewById(R.id.address1);
        subject = (EditText) findViewById(R.id.subject);
        emailbody = (EditText) findViewById(R.id.body);
        send = (Button) findViewById(R.id.send);
        
        SharedPreferences spf = getSharedPreferences("pat_login", MODE_WORLD_READABLE);
    	 phys= spf.getString("PHYSIAN","phys");
   	    patient=spf.getString("PATIENT", patient);	
    	 address.setText(phys);
         subject.setText(patient);
    	 send.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }
 
    public void sendEmail(){
       
        if(!address.getText().toString().trim().equalsIgnoreCase("")){
          final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
          emailIntent.setType("plain/text");
          emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{ address.getText().toString()});
          emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject.getText());
          emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, emailbody.getText()+"\n---------x---------\n VISUALACUITY_efficiency="+viseff+"\n COLOR_BLINDNESS_TEST_efficiency="+coloreff1);
          email.this.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        }
        else{
            Toast.makeText(getApplicationContext(), "Please enter an email address..", Toast.LENGTH_LONG).show();
        }
      }
    }