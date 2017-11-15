package com.example.capp;


import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class TutorialList extends ListActivity {
	TutorialDb tutdb;
	ArrayList<String> title;
	SQLiteDatabase arg0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tutorial_list);
		arg0 = openOrCreateDatabase("tutsdb", MODE_PRIVATE, null);
		String query="create table if not exists Tutorial(id integer primary key autoincrement, title varchar(1000), tutorial varchar(3000))";
		
		
			arg0.execSQL(query);
		
		title = new ArrayList<String>();
		fetchvalues();
		this.setListAdapter(new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,title));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		TutorialDb tutdb = new TutorialDb(this);
		tutdb.open();
		ArrayList<String> ids = tutdb.fetchids();
		tutdb.close();
		Intent myintent = new Intent(this,ShowTuts.class);
		myintent.putExtra("id", String.valueOf(ids.get(position)));
		startActivity(myintent);
		super.onListItemClick(l, v, position, id);
	}


	private void fetchvalues()
	{
		try
		{
			TutorialDb obj = new TutorialDb(this);
			obj.open();
			title = obj.fetchquestion();
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
		getMenuInflater().inflate(R.menu.tutorial_list, menu);
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
