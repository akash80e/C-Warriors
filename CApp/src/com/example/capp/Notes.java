package com.example.capp;


import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Notes extends ListActivity {


	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		String a;
		notesDb obj = new notesDb(this);
		obj.open();
		ArrayList<String> ids = obj.fetchids();
		
		a = String.valueOf(ids.get(info.position));
		
		if(item.getItemId()==R.id.delete_button)
		{
		
		//Toast.makeText(getBaseContext(), a, Toast.LENGTH_LONG).show();
		obj.deleteContact(Integer.parseInt(a));
		
		Intent myintent = new Intent(this,Notes.class);
		this.finish();
		startActivity(myintent);
		}
		else if(item.getItemId()==R.id.update_button)
		{
			Intent myintent = new Intent(this,AddNotes.class);
			myintent.putExtra("id", String.valueOf(a));
			startActivity(myintent);
					
		}
		obj.close();
		
		return super.onContextItemSelected(item);
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		getMenuInflater().inflate(R.menu.notes, menu);
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	ArrayList<String> title;
	notesDb db;
	Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notes);
		title = new ArrayList<String>();
		b1 = (Button) findViewById(R.id.button1);
		fetchtitle();
		this.setListAdapter(new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,title));
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent myintent = new Intent(getBaseContext(),AddNotes.class);
				Notes.this.finish();
				startActivity(myintent);
				
			}
		});
		this.registerForContextMenu(getListView());
		
		
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		notesDb obj = new notesDb(this);
		obj.open();
		ArrayList<String> ids = obj.fetchids();
		obj.close();
		Intent myintent = new Intent(this,ShowNotes.class);
		myintent.putExtra("id", String.valueOf(ids.get(position)));
		startActivity(myintent);
		super.onListItemClick(l, v, position, id);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.notes, menu);
		return true;
	}
	private void fetchtitle()
	{
		db = new notesDb(this);
		db.open();
		title = db.fetchtitle();
		db.close();
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
