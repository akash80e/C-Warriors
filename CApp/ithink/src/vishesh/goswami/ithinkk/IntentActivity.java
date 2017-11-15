package vishesh.goswami.ithinkk;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class IntentActivity extends Activity implements OnClickListener{

		Button b1;
		EditText e1;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent);
		
		b1=(Button) findViewById(R.id.button1);
		e1=(EditText) findViewById(R.id.editText1);
		b1.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_intent, menu);
		return true;
		
	}

	@Override
	public void onClick(View v) {
		
		
		Intent myobj = new Intent(Intent.ACTION_CALL);
		myobj.setData(Uri.parse("tel:8195955140"));
		// TODO Auto-generated method stub
		startActivity(myobj);
	}

}
