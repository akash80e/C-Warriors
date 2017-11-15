package com.example.capp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Options extends Activity {
	Button b1,b2,b3,b4,b5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_options);
		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		b3 = (Button) findViewById(R.id.button3);
		b4 = (Button) findViewById(R.id.button4);
		b5 = (Button) findViewById(R.id.button5);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent myintent = new Intent(getBaseContext(),Behind.class);
			
				startActivity(myintent);
				
			}
		});
	b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent myintent = new Intent(getBaseContext(),Choice.class);
				startActivity(myintent);
				
			}
		});
	b3.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent myintent = new Intent(getBaseContext(),Project.class);
			startActivity(myintent);
			
		}
	});
	b5.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent myintent = new Intent(getBaseContext(),Notes.class);
			startActivity(myintent);
			
		}
	});
	b4.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Toast.makeText(getBaseContext(), "You cannot start the war without unlocking the weapons", Toast.LENGTH_LONG).show();
			
		}
	});
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.options, menu);
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
