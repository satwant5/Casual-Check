package com.example.casualcheck;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Demo_tour extends Activity

{
	Button btnNext;
	Button btnPrevious;
	ImageView demoImage;
	int count = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo_tour);
		btnNext = (Button) findViewById(R.id.btn_next);
		btnPrevious = (Button) findViewById(R.id.btn_previous);
		final ImageView iv = (ImageView) findViewById(R.id.imageView1);
		btnNext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				count++;
				switch (count) {
				case 1:
					iv.setImageResource(R.drawable.step_2);
					break;
				case 2:
					iv.setImageResource(R.drawable.step_3);
					break;
				case 3:
					iv.setImageResource(R.drawable.step_5);
					break;
				

				default:
					break;
				}
			}
		});
		btnPrevious.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				count--;
				switch (count) {
				case 1:
					iv.setImageResource(R.drawable.step_2);
					break;
				case 0:
					iv.setImageResource(R.drawable.step_1);
					break;
						
				case 2:
					iv.setImageResource(R.drawable.step_3);
					break;
				case 3:
					iv.setImageResource(R.drawable.step_5);
					break;
				
				default:
					break;
				}
			}
		});

	}
}