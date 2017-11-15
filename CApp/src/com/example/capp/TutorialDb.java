package com.example.capp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class TutorialDb extends SQLiteOpenHelper{

	static int DBVERSION=2;
	static String Dbname="tutsDB";
	SQLiteDatabase db;
	private static String DB_PATH = ""; 
	 private final Context mContext;

	

	public TutorialDb(Context context) {
		super(context, Dbname, null, DBVERSION);
		 if(android.os.Build.VERSION.SDK_INT >= 17){
	         DB_PATH = context.getApplicationInfo().dataDir + "/databases/";         
	      }
	      else
	      {
	         DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
	      }
		
		
		this.mContext = context;
		
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
	String query="create table if not exists Tutorial(id integer primary key autoincrement, title varchar(1000), tutorial varchar(3000))";
	try
	{
		arg0.execSQL(query);
	}
	catch(SQLException e)
	{
		Toast.makeText(null,"Date stored successfully", Toast.LENGTH_SHORT).show();
	}
	try {
		copyDataBase();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	 public void copyDataBase() throws IOException
     {
         InputStream mInput = mContext.getAssets().open(Dbname);
         String outFileName = DB_PATH + Dbname;
         OutputStream mOutput = new FileOutputStream(outFileName);
         byte[] mBuffer = new byte[1024];
         int mLength;
         while ((mLength = mInput.read(mBuffer))>0)
         {
             mOutput.write(mBuffer, 0, mLength);
         }
         mOutput.flush();
         mOutput.close();
         mInput.close();
     }

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int oldversion, int newversion) {
		arg0.execSQL("drop table if exists Tutorial");
		onCreate(arg0);
		
	}
	public void open()
	{
		try {
			copyDataBase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db = this.getWritableDatabase();
	}
	public void close()
	{
		db.close();
	}
	public long insertContact(String stitle, String stutorial)
	{
		ContentValues myvalues = new ContentValues();
		myvalues.put("title", stitle);
		myvalues.put("tutorial", stutorial);
		
		return db.insert("Tutorial", null, myvalues);
	
	}
	public ArrayList<String> fetchquestion()
	{
		ArrayList<String>questions = new ArrayList<String>();
		Cursor mycursor = db.rawQuery("select title from Tutorial", null);
		if(mycursor!=null)
		{
			if(mycursor.moveToNext())
			{
				do
				{
					questions.add(mycursor.getString(mycursor.getColumnIndex("title")));
				}
				while(mycursor.moveToNext());
				return questions;
			}
		}
		return questions;
		
	}
	public ArrayList<String> fetchids()
	{
		ArrayList<String>ids = new ArrayList<String>();
		Cursor mycursor = db.rawQuery("select id from Tutorial", null);
		if(mycursor!=null)
		{
			if(mycursor.moveToNext())
			{
				do
				{
					ids.add(mycursor.getString(mycursor.getColumnIndex("id")));
				}
				while(mycursor.moveToNext());
				return ids;
			}
		}
		return ids;	
	}
}
