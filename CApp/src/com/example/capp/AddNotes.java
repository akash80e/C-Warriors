package com.example.capp;


import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNotes extends Activity {
	EditText et1,et2;
	Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_notes);
		et1 = (EditText) findViewById(R.id.editText1);
		et2 = (EditText) findViewById(R.id.editText2);
		b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			       notesDb db = new notesDb(getBaseContext());
			       db.open();
			       if(et1.getText().toString().trim().length()!=0 && et2.getText().toString().trim().length()!=0)
			       {
			    	  
			       long id = db.insertContact(et1.getText().toString(),et2.getText().toString());
			       

			       db.close();
			       Intent myintent = new Intent(getBaseContext(),Notes.class);
			       AddNotes.this.finish();
			       startActivity(myintent);
			       }
			       else
			    	   Toast.makeText(getBaseContext(), "Please Enter Both the Fields", Toast.LENGTH_LONG).show();
	
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_notes, menu);
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
