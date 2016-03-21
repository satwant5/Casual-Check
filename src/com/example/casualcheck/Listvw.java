package com.example.casualcheck;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Listvw extends Activity{
	public database mDatabaseclass;
	ArrayList<String> listdata;
	public ArrayList<String> datalist;
	ArrayList<String> newlist;

	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		mDatabaseclass= new database(this);
		ListView lv=(ListView)findViewById(R.id.listView1);
		newlist =new ArrayList<String>();
		//listdata=new ArrayList<String>();
		mDatabaseclass.getdata(); 
		newlist=mDatabaseclass.datalist;
		ArrayAdapter<String> ad=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,newlist);
		lv.setAdapter(ad);
}
}