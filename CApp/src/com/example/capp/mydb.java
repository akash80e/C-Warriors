package com.example.capp;
import java.io.File;
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
import android.util.Log;
import android.widget.Toast;


public class mydb extends SQLiteOpenHelper{
	static int DBVERSION=1;
	static String Dbname="mydbase";
	SQLiteDatabase db;
	 private static String DB_PATH = ""; 
	 private final Context mContext;


	public mydb(Context context) {
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
		
	String query="create table if not exists important(_id integer primary key autoincrement, question varchar(1000), answers varchar(3000))";
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

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int oldversion, int newversion) {
		arg0.execSQL("drop table if exists important");
		onCreate(arg0);
		
	}
	 public void createDataBase() throws IOException
	  {
	      //If database not exists copy it from the assets

	      boolean mDataBaseExist = checkDataBase();
	      if(!mDataBaseExist)
	      {
	          this.getReadableDatabase();
	          this.close();
	          try 
	          {
	              //Copy the database from assets
	              copyDataBase();
	             // Log.e(TAG, "createDatabase database created");
	          } 
	          catch (IOException mIOException) 
	          {
	              throw new Error("ErrorCopyingDataBase");
	          }
	      }
	  }
	 private boolean checkDataBase()
     {
         File dbFile = new File(DB_PATH + Dbname);
         //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
         return dbFile.exists();
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
	public long insertContact(String squestion, String sanswers)
	{
		ContentValues myvalues = new ContentValues();
		myvalues.put("question", squestion);
		myvalues.put("answers", sanswers);
		
		return db.insert("important", null, myvalues);
	
	}
	public ArrayList<String> fetchquestion()
	{
		ArrayList<String>questions = new ArrayList<String>();
		Cursor mycursor = db.rawQuery("select question from important", null);
		if(mycursor!=null)
		{
			if(mycursor.moveToNext())
			{
				do
				{
					questions.add(mycursor.getString(mycursor.getColumnIndex("question")));
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
		Cursor mycursor = db.rawQuery("select int from important", null);
		if(mycursor!=null)
		{
			if(mycursor.moveToNext())
			{
				do
				{
					ids.add(mycursor.getString(mycursor.getColumnIndex("int")));
				}
				while(mycursor.moveToNext());
				return ids;
			}
		}
		return ids;
		
	}
	

}
