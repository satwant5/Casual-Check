package com.example.casualcheck;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class color_test1 extends Activity{
	public static int i;
	Integer images[]={R.drawable.ic_launcher,R.drawable.img,R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9};
	ImageView mImageView;
	public String value;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.color_layout1);
		mImageView=(ImageView)findViewById(R.id.imageView1);
		Bundle mBundle=getIntent().getExtras();
		 String value=mBundle.getString("color_i2");
		 //Toast.makeText(getApplicationContext(), "value"+value, 0).show();
		 i=Integer.parseInt(value);
		//Toast.makeText(getApplicationContext(), "value"+i, 0).show();
		i=i+1;
		if(i<=8)
		{
		
		mImageView.setImageResource(images[i]);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent mintent= new Intent();
				mintent.setClass(color_test1.this, color_test2.class);
				String i1=String.valueOf(i);
				mintent.putExtra("color_i", i1);
				startActivity(mintent);
				
				
			}
		} , 2000);
		
		
		}///if close
		else
		{
			Intent mIntent=new Intent(color_test1.this,efficiency_color.class);
	}
	
//		LinearLayout layout = new LinearLayout(this);
//		ImageView imageView = new ImageView(this);
//		imageView.setBackgroundResource(R.drawable.image2);
//		imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//		layout.addView(imageView);
//		this.setContentView(layout);
		
		
		
		

		
	}
	}




/*@Override

protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    // TODO Auto-generated method stub

    super.onActivityResult(requestCode, resultCode, data);

    //if(data.getExtras().containsKey("widthInfo")){

        //width.setText(data.getStringExtra("widthInfo"));
//i=Integer.parseInt(data.getStringExtra("widthinfo"));


    //}

    //if(data.getExtras().containsKey("heightInfo")){

      //  height.setText(data.getStringExtra("heightInfo"));

    //}

}
}*/