package com.example.capp;




import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;



public class MainActivity extends ListActivity {
	mydb db;
	ArrayList<String>questions;
	SQLiteDatabase arg0;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		arg0 = openOrCreateDatabase("mydbase", MODE_PRIVATE, null);
		String query="create table if not exists important(_id integer primary key autoincrement, question varchar(1000), answers varchar(3000))";
		
		
			arg0.execSQL(query);
		
		
		 //SQLiteDatabase mydb = db.openDatabase(this, "assets/mydbase.db");
		questions = new ArrayList<String>();
		fetchvalues();
		this.setListAdapter(new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,questions));
		
		
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		mydb obj = new mydb(this);
		obj.open();
		ArrayList<String> ids = obj.fetchids();
		obj.close();
		Intent myintent = new Intent(this,Solutions.class);
		myintent.putExtra("id", String.valueOf(ids.get(position)));
		startActivity(myintent);
		super.onListItemClick(l, v, position, id);
	}


	private void fetchvalues()
	{
		try
		{
			mydb obj = new mydb(this);
			obj.open();
			questions = obj.fetchquestion();
			obj.close();
		}
		catch(Exception e)
		{
			Toast.makeText(getBaseContext(), e.getMessage(), 2000).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
