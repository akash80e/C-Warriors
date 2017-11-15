package com.example.capp;


import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ShowNotes extends Activity {
	TextView t1,t2;
	notesDb obj;
	SQLiteDatabase newdb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_notes);
		t1 = (TextView) findViewById(R.id.textView1);
		t2 = (TextView) findViewById(R.id.textView2);
		try{
		 String id=this.getIntent().getExtras().getString("id");
		 obj = new notesDb(this);
		newdb = obj.getWritableDatabase();
		
			
		Cursor myresult = newdb.rawQuery("select * from Notes where id = " + id, null);
		if(myresult.moveToNext())
		{
			t1.setText(myresult.getString(myresult.getColumnIndex("title")));
			t2.setText(myresult.getString(myresult.getColumnIndex("note")));
		}
		myresult.close();
		newdb.close();
		}
		catch(Exception e)
		{
			Log.d(e.getMessage(),null);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_notes, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
