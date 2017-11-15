package vishesh.goswami.ithinkk;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MyActivity extends Activity {
TextView t1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);
		t1=(TextView) findViewById(R.id.textView1);
		ProjectDatabase obj=new ProjectDatabase(MyActivity.this);
		obj.open();
		t1.setText(obj.fetchQuestion(1));
		obj.close();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_my, menu);
		return true;
	}

}
