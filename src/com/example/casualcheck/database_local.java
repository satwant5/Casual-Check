package com.example.casualcheck;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class database_local extends Activity {
public database mDatabaseclass;
EditText mEditText_uname, mEditText_doc_id;
Button mButton_insert;

public void onCreate(Bundle savedInstancestate)
{
	super.onCreate(savedInstancestate);
	setContentView(R.layout.activity_main);
	try{
		mDatabaseclass= new database(this);
		Log.d("created", "done");
		}
	catch(Exception e)
	{
		Log.d("not created", "not done yet"+e.getMessage());
	}
	mEditText_uname=(EditText)findViewById(R.id.edittext_patientid);
	mEditText_doc_id=(EditText)findViewById(R.id.edittext_physianemail);
	mButton_insert=(Button)findViewById(R.id.btnLogin);
	mButton_insert.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent mIntent=new Intent(database_local.this,home.class);
			startActivity(mIntent);
//		try{
//			mDatabaseclass.insertdata
//			(mEditText_uname.getText().toString().trim(),Integer.parseInt(mEditText_doc_id.getText().toString().trim()));
//			Log.d("table created","DONE");
//			Toast mToast= Toast.makeText(getApplicationContext(), "DATA IS SAVED", 1);
//			mToast.setGravity(Gravity.BOTTOM, 0, 0);
//			mToast.show();
//			refresh();
//		}
//		catch(Exception e)
//		{
//			Log.d("not created", "notdone");
//		}
		}
	});
}
public void refresh()
{
	mEditText_uname.setText("");
	mEditText_doc_id.setText("");
}
}
