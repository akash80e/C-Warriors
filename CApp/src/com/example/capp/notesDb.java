package com.example.capp;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class notesDb extends SQLiteOpenHelper {
	static int DBVERSION=2;
	static String Dbname="NotesDb";
	SQLiteDatabase db;
	

	public notesDb(Context context) {
		super(context, Dbname, null, DBVERSION);
 		
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
	String query="create table if not exists Notes(id integer primary key autoincrement, title varchar(1000) not null, note varchar(3000) not null)";
	try
	{
		arg0.execSQL(query);
	}
	catch(SQLException e)
	{
		Toast.makeText(null,"Date stored successfully", Toast.LENGTH_SHORT).show();
	}
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int oldversion, int newversion) {
		arg0.execSQL("drop table if exists Notes");
		onCreate(arg0);
		
	}
	public void open()
	{
		db = this.getWritableDatabase();
	}
	public void close()
	{
		db.close();
	}
	public long insertContact(String stitle, String snotes)
	{
		ContentValues myvalues = new ContentValues();
		myvalues.put("title", stitle);
		myvalues.put("note", snotes);
		
		return db.insert("Notes", null, myvalues);
	
	}
	public long deleteContact(int myid)
	{
		return db.delete("Notes", "id = " + myid, null);
	}
	public ArrayList<String> fetchtitle()
	{
		ArrayList<String>questions = new ArrayList<String>();
		Cursor mycursor = db.rawQuery("select title from Notes", null);
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
		Cursor mycursor = db.rawQuery("select id from Notes", null);
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
	


