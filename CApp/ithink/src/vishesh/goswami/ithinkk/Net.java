package vishesh.goswami.ithinkk;

import android.os.Bundle;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class Net extends Activity implements OnClickListener {
	Button b1;
	EditText e1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_net);
		
		e1=(EditText) findViewById(R.id.editText2);
		b1=(Button) findViewById(R.id.button1);
		
		b1.setOnClickListener(this);
		
		Classs object = new Classs(this);
		object.open();
		
		
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent myobj=new Intent(Intent.ACTION_WEB_SEARCH);
		myobj.putExtra(SearchManager.QUERY,e1.getText().toString());
		startActivity(myobj);
	}

}
