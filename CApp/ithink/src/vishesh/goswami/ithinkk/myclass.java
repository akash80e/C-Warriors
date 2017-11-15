package vishesh.goswami.ithinkk;

/*import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

*/
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class myclass extends SQLiteOpenHelper

{

    SQLiteDatabase mdb;
    
    static int l=2;
    static String DATABASE_NAME="new_db";

   

     myclass(Context context)

    {

        super(context, DATABASE_NAME, null, l);

        
    }

    @Override

    public void onCreate(SQLiteDatabase db)

    {


        String query="create table if not exists contacts2 (_id integer primary key autoincrement, "

                + "ename text not null, email text not null, salary text not null,gender text not null)";

        try

         {

            db.execSQL(query);

        }

         catch (SQLException e)

         {
        	 Toast.makeText(null, "llll", Toast.LENGTH_LONG).show();
            e.printStackTrace();

        }

       

    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    	  db.execSQL("DROP TABLE IF EXISTS contacts2");

          onCreate(db);

       

    }

     public void open() 
        {

            mdb = this.getWritableDatabase();

           

        }

        public void close()

        {

            mdb.close();

        }

        public long insertContact(String name, String email, String sal,String genderv)
        {

            ContentValues initialValues = new ContentValues();

            try{
            	
            
            initialValues.put("ename", name);

            initialValues.put("email", email);

            initialValues.put("salary", sal);
            initialValues.put("gender", genderv);
            
            }
            catch (Exception e) {
				// TODO: handle exception

           	 Toast.makeText(null, "lppp", Toast.LENGTH_LONG).show();
            }
            return mdb.insert("contacts2", null, initialValues);

        }
/*
        public long updateContact(String name, String email, String sal,String genderv)
        {

            ContentValues initialValues = new ContentValues();

        	try{
            	
                
            initialValues.put("ename", name);

            initialValues.put("email", email);

            initialValues.put("salary", sal);
            initialValues.put("gender", genderv);
            
            }
            catch (Exception e) {
				// TODO: handle exception

           	 Toast.makeText(null, "lppp", Toast.LENGTH_LONG).show();
            }
          
        
        return mdb.update("contacts2", initialValues, whereClause, null);
        }*/
        public ArrayList<String> fetchValues(){
        	
        	ArrayList<String> fetchnames= new ArrayList<String>();
        	
        	
        	Cursor mycursor=  mdb.rawQuery("select ename from contacts2  "  ,null);
        	
        	if(mycursor!=null)
        	{
        		while(mycursor.moveToNext())
        		{
        		fetchnames.add(mycursor.getString(mycursor.getColumnIndex("ename")));
        		
        		}
        	}
        	
        	return fetchnames;
        }
        
        public ArrayList<String> fetchIds(){
        	
        	ArrayList<String> fetchids= new ArrayList<String>();
        	
        	
        	Cursor mycursor=  mdb.rawQuery("select _id from contacts2  "  ,null);
        	
        	if(mycursor!=null)
        	{
        		while(mycursor.moveToNext())
        		{
        		fetchids.add(mycursor.getString(mycursor.getColumnIndex("_id")));
        		
        		}
        	}
        	
        	return fetchids;
        }
        
        
        
        
        
        
        
}

