package com.example.casualcheck;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class color_test2 extends Activity {
	Button mButton;
	EditText mEditText;
	public String edit_value;
	public static int i,k;
	public static int edit_value2;
	public static int eff_digits;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.color_layout2);
		mButton=(Button)findViewById(R.id.button_color);
		mEditText=(EditText)findViewById(R.id.editText_color);
		Bundle mBundle=getIntent().getExtras();
		String value=mBundle.getString("color_i");
		i=Integer.parseInt(value);
		

		mButton.setOnClickListener(new OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				edit_value=mEditText.getText().toString();
				
				edit_value2=Integer.parseInt(edit_value);
				// TODO Auto-generated method stub
				if(i==1)
				{
					if(edit_value2==5)
					{
						k=1;
						
					}
					else
					{
						k=2;
						eff_digits=0;
					}
				}
				
				if(i==2)
				{
					if(edit_value2==16)
					{
						k=1;
					}
					else
					{
						k=2;
						eff_digits=15;
					}
				}
				
				if(i==3)
				{
					if(edit_value2==2)
					{
						k=1;
					}
					else
					{
						k=2;
						eff_digits=25;
					}
				}
				
				if(i==4)
				{
					if(edit_value2==5)
					{
						k=1;
					}
					else
					{
						k=2;
						eff_digits=40;
					}
				}
				
				if(i==5)
				{
					if(edit_value2==42)
					{
						k=1;
					}
					else
					{
						k=2;
						eff_digits=55;
					}
				}
				
				if(i==6)
				{
					if(edit_value2==7)
					{
						k=1;
					}
					else
					{
						k=2;
						eff_digits=65;
					}
				}
				
				if(i==7)
				{
					if(edit_value2==29)
					{
						k=1;
					}
					else
					{
						k=2;
						eff_digits=80;
					}
				}
				
				if(i==8)
				{
					if(edit_value2==6)
					{
						k=1;
					}
					else
					{
						k=2;
						eff_digits=90;
					}
				}
				
				if(i==9)
				{
					if(edit_value2==57)
					{
						k=1;
					}
					else
					{
						k=2;
						eff_digits=100;
					}
				}
				
				if(k==1)
				{
				Intent mIntent1=new Intent(color_test2.this,color_test1.class);
				String i1=String.valueOf(i);
				mIntent1.putExtra("color_i2",i1 );
				startActivity(mIntent1);
				}
				else
				{
					String eff_digits1=String.valueOf(eff_digits);
					Intent mIntent1=new Intent(color_test2.this,efficiency_color.class);
					mIntent1.putExtra("eff_digit", eff_digits1);
					startActivity(mIntent1);
				}
			}
		});
		
	}

}
