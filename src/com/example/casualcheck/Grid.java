package com.example.casualcheck;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class Grid extends Activity {
	private String[] tips;
	private static final Random rgenerate=new Random();
	protected void onCreate(Bundle savedInstanceState) 
	{
		GridView gv;
		final TextView tv;
		Button b;
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid);
		tv=(TextView)findViewById(R.id.text_tip);
		Resources res=getResources();
		tips=res.getStringArray(R.array.tips);
		String q=tips[rgenerate.nextInt(tips.length)];
		tv.setText(q);
		gv=(GridView)findViewById(R.id.gridView1);
		gv.setAdapter(new ImageAdapter(this));
		gv.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				if(arg2==0)
					{
					Intent mIntent=new Intent(Grid.this,Demovisual.class);	
					startActivity(mIntent);
					}
					else if(arg2==1)
					{
						
					Intent mIntent=new Intent(Grid.this,democolourtest.class);	
					
					startActivity(mIntent);
					}
					else if(arg2==2)
					{
		 				Intent mIntent=new Intent(Grid.this,MakePhotoActivity.class);
						startActivity(mIntent);
					}
					else if(arg2==3)
					{
						Intent mIntent=new Intent(Grid.this,LoginActivity.class);
						startActivity(mIntent);
					}
					else if(arg2==4)
					{
						Intent mIntent=new Intent(Grid.this,SendBtn.class);
						startActivity(mIntent);
					}
					else if(arg2==5)
					{
						Intent mIntent=new Intent(Grid.this,Demo_tour.class);
						startActivity(mIntent);
					}
			}
		});
		
		b=(Button)findViewById(R.id.btn_tip);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String q=tips[rgenerate.nextInt(tips.length)];
				tv.setText(q);
			}
		});
	}
	
	public class ImageAdapter extends BaseAdapter {

		
		private Context mContext;
		public ImageAdapter(Context c) {
	        mContext = c;
	    }

		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mThumbIds.length;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		public View getView(int position, View convertView, ViewGroup parent)
	    {
		// TODO Auto-generated method stub
			if(convertView==null)
			{
				LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = inflater.inflate(R.layout.grid_item,null);
	
			}
			TextView test_text1=(TextView) convertView.findViewById(R.id.grid_item_text);
			ImageView test_img=(ImageView) convertView.findViewById(R.id.grid_item_image);
			test_text1.setText(text[position]);
			test_img.setImageResource(mThumbIds[position]);
			return convertView;
	   }

	    // references to our images
	    private Integer[] mThumbIds = {
	            R.drawable.visualacuity,R.drawable.clrblnd,
	           R.drawable.tkpic ,
	           R.drawable.setting,R.drawable.report1,R.drawable.help
	            
	    };
	
	    private String[] text={
			"Visual Acuity","Colour Test","Eye Scan","Settings","Report","Help"
			};
			
}
	}
