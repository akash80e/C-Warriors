package vishesh.goswami.ithinkk;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Sms extends Activity implements OnClickListener {

	EditText e1,e2;
	Button b1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms);
		e1=(EditText) findViewById(R.id.editText1);

		e2=(EditText) findViewById(R.id.editText2);
		b1=(Button) findViewById(R.id.button1);
		
		b1.setOnClickListener(this);
		
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent myobj=new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:"+e2.getText().toString()));
		myobj.putExtra("sms_body",e1.getText().toString());
		startActivity(myobj);
	}

}
