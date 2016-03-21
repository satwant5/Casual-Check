package com.example.casualcheck;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class database extends SQLiteOpenHelper {
	public ArrayList<String> datalist;
	public static String fnam, lnam, eml, addr;
	public static final String DB_NAME = "PATIENT";
//	public static final String DB_TABLENAME = "PATIENT_RECORD";
	public static final String DB_TABLENAME1 = "PATIENT_ENTRY";
	// public static String KEY_NAME="Uname";
	// public static String KEY_ID="Doc_id";
	//public String t_name = "create table " + DB_TABLENAME
	//		+ " (Uname Text,Doc_id Integer)";
	public String t_name1 = "create table "
			+ DB_TABLENAME1
			+ " ( fname Text, lname Text, email Text, address Text)";

	public database(Context context) {
		super(context, DB_NAME, null, 1);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

		try {
		//	db.execSQL(t_name);
			db.execSQL(t_name1);
			Log.d("Table Exceoption",
					"Table Createeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		} catch (Exception e) {
			// TODO: handle exception
			Log.d("Table Exceoption", e.toString());
		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS" + DB_TABLENAME1);
		onCreate(db);
	}

//	public void insertdata(String name, int e_id) {
//		SQLiteDatabase mdb = this.getWritableDatabase();
//		ContentValues mvalues = new ContentValues();
//		mvalues.put("Uname", name);
//		mvalues.put("Doc_id", e_id);
//		mdb.insert(DB_TABLENAME, null, mvalues);
//		mdb.close();
//	}

	public void save(String fnm, String lnm, String em, String add) {
		SQLiteDatabase mdb1 = this.getWritableDatabase();
		ContentValues mvalues1 = new ContentValues();
		// mvalues1.put("pat_id", p_id);
		try {

			mvalues1.put("fname", fnm);
			mvalues1.put("lname", lnm);
			mvalues1.put("email", em);
			mvalues1.put("address", add);
			mdb1.insert(DB_TABLENAME1, null, mvalues1);
			mdb1.close();
			Log.d("InsetionException",
					"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		} catch (Exception e) {
			// TODO: handle exception
			Log.d("InsetionException", e.toString());
		}
	

	}

	public void getdata() {
		SQLiteDatabase mdb = this.getReadableDatabase();
		datalist = new ArrayList<String>();
		Cursor cr1 = mdb.rawQuery("SELECT * FROM " + DB_TABLENAME1, null);
		cr1.moveToFirst();
		while (!cr1.isAfterLast()) {
			int ci = cr1.getColumnIndexOrThrow("fname");
			int ci1 = cr1.getColumnIndexOrThrow("lname");
			int ci2 = cr1.getColumnIndexOrThrow("email");
			int ci3 = cr1.getColumnIndexOrThrow("address");

			fnam = cr1.getString(ci);
			lnam = cr1.getString(ci1);
			eml = cr1.getString(ci2);
			addr = cr1.getString(ci3);
			datalist.add(fnam + "  " + lnam + "  " + eml + "  "
					+ addr);
			cr1.moveToNext();
		}
		mdb.close();
	}

}
