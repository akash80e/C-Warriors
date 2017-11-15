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
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ProjectDatabase extends SQLiteOpenHelper{

	  SQLiteDatabase databaseobject,db;
	  
	
		
		
	    
	    static int l=1;
	    static String DATABASE_NAME="projectdatabase";
	    String getquestion=null;
	    Context mycontext;
	   

	     ProjectDatabase(Context context)
	     {
	    	 super(context, DATABASE_NAME, null, l);
	    	this.mycontext =context;
	    }
    
	    @Override

	    public void onCreate(SQLiteDatabase db)

	    {


  String query="create table if not exists data (id integer primary key autoincrement, "

	        + "question text , option1 text ,option2 text ,option3 text,option4 text,correct text )";
  
  try{

     db.execSQL(query);
  		}

  catch (SQLException e)
 {
 	 Toast.makeText(null, "table not created", Toast.LENGTH_LONG).show();
     e.printStackTrace();

 }
  
 
  
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		  databaseobject.execSQL("DROP TABLE IF EXISTS data");

          onCreate(databaseobject);
		
	}
	
	public void open() 
    {
		databaseobject = this.getWritableDatabase();
    }

    public void close() {

        databaseobject.close();
        }

    public String fetchQuestion(int id){
    	
    	String getquestion=null;
    	
    	Cursor mycursor=  databaseobject.rawQuery("select question from data where id = "+ id ,null);
    	
    	if(mycursor!=null)
    	{
    		while(mycursor.moveToNext())
    		{
    		getquestion=mycursor.getString(mycursor.getColumnIndex("question"));
    		}
    	}
    	
    	return getquestion;
    }
public String fetchOption1(int id){
    	
    	String getquestion=null;
    	
    	Cursor mycursor=  databaseobject.rawQuery("select option1 from data where id = "+ id ,null);
    	
    	if(mycursor!=null)
    	{
    		while(mycursor.moveToNext())
    		{
    		getquestion=mycursor.getString(mycursor.getColumnIndex("option1"));
    		}
    	}
    	
    	return getquestion;
    }

	public String fetchOption2(int id){
    	
    	String getquestion=null;
    	
    	Cursor mycursor=  databaseobject.rawQuery("select option2 from data where id = "+ id ,null);
    	
    	if(mycursor!=null)
    	{
    		while(mycursor.moveToNext())
    		{
    		getquestion=mycursor.getString(mycursor.getColumnIndex("option2"));
    		}
    	}
    	
    	return getquestion;
    }
	
	public String fetchOption3(int id){
    	
    	
    	Cursor mycursor=  databaseobject.rawQuery("select option3 from data where id = "+ id ,null);
    	
    	if(mycursor!=null)
    	{
    		while(mycursor.moveToNext())
    		{
    		getquestion=mycursor.getString(mycursor.getColumnIndex("option3"));
    		}
    	}
    	
    	return getquestion;
    }
	
	public String fetchOption4(int id){
    	
    	
    	Cursor mycursor=  databaseobject.rawQuery("select option4 from data where id = "+ id ,null);
    	
    	if(mycursor!=null)
    	{
    		while(mycursor.moveToNext())
    		{
    		getquestion=mycursor.getString(mycursor.getColumnIndex("option4"));
    		}
    	}
    	
    	return getquestion;
    }    
public String fetchCorrect(int id){
    	
    	String getquestion=null;
    	
    	Cursor mycursor=  databaseobject.rawQuery("select correct from data where id = "+ id ,null);
    	
    	if(mycursor!=null)
    	{
    		while(mycursor.moveToNext())
    		{
    		getquestion=mycursor.getString(mycursor.getColumnIndex("correct"));
    		}
    	}
    	
    	return getquestion;
    }

public void dropTable(){
	
	databaseobject.execSQL("DROP TABLE IF EXISTS data");
	 onCreate(databaseobject);

}

	public long insertContact(String question, String option1, String option2,String option3,String option4,String correct)
{

    ContentValues initialValues = new ContentValues();

    try{
    	
    
    initialValues.put("question", question);

    initialValues.put("option1", option1);

    initialValues.put("option2", option2);
    initialValues.put("option3", option3);
    initialValues.put("option3", option3);
    initialValues.put("option4", option4);
    initialValues.put("correct", correct);
    }
    catch (Exception e) {
		// TODO: handle exception

   //	 Toast.makeText(null, "lppp", Toast.LENGTH_LONG).show();
    }
    return databaseobject.insert("data", null, initialValues);

}
	
	
	



}
