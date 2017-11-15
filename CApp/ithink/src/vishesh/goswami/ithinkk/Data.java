
package vishesh.goswami.ithinkk;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Data extends SQLiteOpenHelper
{
  SQLiteDatabase databaseobject; 
	  
	  static String DB_PATH = "/data/data/vishesh.goswami.ithinkk/databases/";
	    static String DB_NAME = "project_db";
	    SQLiteDatabase db;
	   private  Context mContext=null;

	
	    
	    static int l=1;
	    static String DATABASE_NAME="project_db";
	    String getquestion=null;
	   

	  Data(Context context)
	     {
	    	 super(context, DATABASE_NAME, null, l);
	    	 this.mContext=context;
	    }
	     
	  public void createDataBase() throws IOException {
	 	    boolean mDataBaseExist = checkDataBase();
	 	    if (!mDataBaseExist) {
	 	        this.getReadableDatabase();
	 	        try {
	 	            copyDataBase();
	 	        } catch (IOException mIOException) {
	 	            mIOException.printStackTrace();
	 	            throw new Error("Error copying database");
	 	        } finally {
	 	            this.close();
	 	        }
	 	    }
	 	}

	 	/** This method checks whether database is exists or not **/
	 	private boolean checkDataBase() {
	 	    try {
	 	        final String mPath = DB_PATH + DB_NAME;
	 	        db=SQLiteDatabase.openDatabase(mPath, null,SQLiteDatabase.OPEN_READONLY);
	 	        
	 	        // File file = new File(mPath);
	 	        //if (file.exists())
	 	          //  return true;
	 	       // else
	 	         //   return false;
	 	    } catch (SQLiteException e) {
	 	        e.printStackTrace();
	 	        return false;
	 	    }
	 	    if(db!=null){
	 	    	db.close();
	 	    }
	 	    return db!=null?true :false;
	 	}

	 	/**
	 	 * This method will copy database from /assets directory to application
	 	 * package /databases directory
	 	 **/
	 	private void copyDataBase() throws IOException {
	 	    try {

	 	        InputStream mInputStream = mContext.getAssets().open(DB_NAME);
	 	        String outFileName = DB_PATH + DB_NAME;
	 	        OutputStream mOutputStream = new FileOutputStream(outFileName);
	 	        byte[] buffer = new byte[1024];
	 	        int length;
	 	        while ((length = mInputStream.read(buffer)) > 0) {
	 	            mOutputStream.write(buffer, 0, length);
	 	        }
	 	        mOutputStream.flush();
	 	        mOutputStream.close();
	 	        mInputStream.close();
	 	    } catch (Exception e) {
	 	        e.printStackTrace();
	 	    }
	 	}

	 	/** This method open database for operations **/
	 	public boolean openDataBase() throws SQLException {
	 	    String mPath = DB_PATH + DB_NAME;
	 	    databaseobject = SQLiteDatabase.openDatabase(mPath, null,
	 	            SQLiteDatabase.CREATE_IF_NECESSARY);
	 	    return databaseobject!=null;
	 	}

	 	/** This method close database connection and released occupied memory **/
	 	@Override
	 	public synchronized void close() {
	 	    if (databaseobject != null)
	 	        databaseobject.close();
	 	    SQLiteDatabase.releaseMemory();
	 	    super.close();
	 	}

	     


	@Override
	public void onCreate(SQLiteDatabase arg0) {
		 String query="create table if not exists data (id integer primary key autoincrement, "

	        + "question text , option1 text ,option2 text ,option3 text,option4 text )";
  
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

    public void close1() {

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

}
