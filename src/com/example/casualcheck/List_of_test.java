package com.example.casualcheck;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class List_of_test extends Activity {
	
	public int[] mimages={R.drawable.aimg,R.drawable.mimg,R.drawable.color_test,R.drawable.casualeye};
	public String[] mtext1={"Visual Acuity","Motor Test","Color Blindness Test","Take pictures of eye"};
	public ListView mListView;
	Button sendreport;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list1);
		
		ListView mListView=(ListView)findViewById(R.id.listView1);
		list_base mBase=new list_base(mimages, mtext1);
		mListView.setAdapter(mBase);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
			if(arg2==0)
			{
			Intent mIntent=new Intent(List_of_test.this,MainActivity.class);	
			startActivity(mIntent);
			}
			
			else if(arg2==1)
			{
			Intent mIntent=new Intent(List_of_test.this,color_test.class);	
			startActivity(mIntent);
			}
			else if(arg2==2)
			{
				String i="0";
			Intent mIntent=new Intent(List_of_test.this,color_test1.class);	
			mIntent.putExtra("color_i2", i);
			startActivity(mIntent);
			}
			else if(arg2==3)
			{
				Intent mIntent=new Intent(List_of_test.this,MakePhotoActivity.class);
				startActivity(mIntent);
			}
			}
		});
	
	sendreport=(Button)findViewById(R.id.report);
	sendreport.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		Intent it = new Intent(List_of_test.this, email.class);
		startActivity(it);
		
		}
	});
	}
	private class list_base extends BaseAdapter
{
	
	
	 	 int[] m_images;
		 String[] m_text;
		public list_base(int[] mimages_e,String[] mtext1_e) 
		{
			// TODO Auto-generated constructor stub
			m_images=mimages_e;
			m_text=mtext1_e;
			
		}


	@Override
	public int getCount() 
	{
		// TODO Auto-generated method stub
		return mimages.length;
		
	}

	@Override
	public Object getItem(int arg0) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	    {
		// TODO Auto-generated method stub
			if(convertView==null)
			{
				LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = inflater.inflate(R.layout.items,null);
	
			}
			TextView test_text1=(TextView) convertView.findViewById(R.id.textView_items);
			ImageView test_img=(ImageView) convertView.findViewById(R.id.imageView_items);
			test_text1.setText(m_text[position]);
			test_img.setImageResource(m_images[position]);
			return convertView;
	   }
	}

}
