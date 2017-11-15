package vishesh.goswami.ithinkk;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DatabaseList extends ListActivity {

	ArrayList<String> fetchnames= new ArrayList<String>();

	ArrayList<String> fetchids= new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_database_list);
		
		myclass obj=new myclass(this);
		obj.open();
		fetchnames =  obj.fetchValues();
		this.setListAdapter(new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1, fetchnames));
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_database_list, menu);
		return true;
	}


	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		myclass obj=new myclass(this);
		obj.open();
		fetchids =  obj.fetchIds();
		
		Toast.makeText(getApplicationContext(), fetchids.get(position), Toast.LENGTH_LONG).show();
		String idv= fetchids.get(position); 
		Intent myintent=new Intent(this,Database.class);
		myintent.putExtra("id",idv);
		startActivity(myintent);
		
		
	}

	
	
	
}
