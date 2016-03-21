package com.example.casualcheck;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class home0 extends Activity {
	
	public static int i=1;
	TextView mTextView,mTextView2,mTextView3,mTextView4,mTextView5_s;
	EditText mEditText;
	Button mButton;
	public static String mleter;
	public static String text="G";
	@Override

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.abc);
		super.onCreate(savedInstanceState);
		mButton=(Button)findViewById(R.id.button_color);
		mEditText=(EditText)findViewById(R.id.editText1);
		mTextView5_s=(TextView)findViewById(R.id.textView1_score);
		mTextView=(TextView)findViewById(R.id.textView_eff);
		mTextView2=(TextView)findViewById(R.id.textView2);
		mTextView3=(TextView)findViewById(R.id.textView3);
		mTextView4=(TextView)findViewById(R.id.textView4);
		mTextView.setText("C");
		mTextView2.setText("Q");
		mTextView3.setText("O");
		mTextView4.setText("G");
		
		mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
			mleter=mEditText.getText().toString();
//			Toast.makeText(getApplicationContext(), "gud"+ mleter, 0).show();
			
				if(text.equalsIgnoreCase(mleter))
				{
					String i1=Integer.toString(i);
					mTextView5_s.setText(i1);
					Intent mIntent=new Intent(home0.this,home12.class);
					mIntent.putExtra("score",i1 );///////only string can sent not integer so we write i1 not i
					startActivity(mIntent);
				}
				else
				{
					Intent mIntent=new Intent(home0.this,efficiency.class);
					String eff1="2%";
					mIntent.putExtra("eff", eff1);
					startActivity(mIntent);
					//Toast.makeText(getApplicationContext(), "bd", 0).show();
				}
			}
		});
		
	}

}
