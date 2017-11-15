package  com.example.capp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


	
	import java.io.IOException;

	import android.os.Bundle;
	import android.app.Activity;
	import android.content.Intent;
	import android.database.SQLException;
	import android.view.Menu;
	
	public class Tcheck extends Activity {

	@Override
		protected void onCreate(Bundle savedInstanceState) 
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_tcheck);
			Classs obj=new Classs(getBaseContext());
			try
			{
				obj.createDataBase();
			}
			catch(Exception e)
			{
				throw new Error("Unable to create database");
			}
			Intent myintent=new Intent(Tcheck.this,Project.class);
		    this.finish();
		    startActivity(myintent);
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.activity_tcheck, menu);
			return true;
		}

	}
