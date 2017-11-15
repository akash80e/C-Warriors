package com.example.capp;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Solutions extends Activity {
	TextView t1,t2;
	SQLiteDatabase newdb;
	mydb obj;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_solutions);
		t1 = (TextView) findViewById(R.id.textView1);
		t2 = (TextView) findViewById(R.id.textView2);
		try{
		 String id=this.getIntent().getExtras().getString("id");
		 obj = new mydb(this);
		newdb = obj.getWritableDatabase();
		
			
		Cursor myresult = newdb.rawQuery("select * from important where int= " + id, null);
		if(myresult.moveToNext())
		{
			t1.setText(myresult.getString(myresult.getColumnIndex("question")));
			t2.setText(myresult.getString(myresult.getColumnIndex("answers")));
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
		getMenuInflater().inflate(R.menu.solutions, menu);
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
