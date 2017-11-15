package vishesh.goswami.ithinkk;

import java.sql.NClob;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class Miniapp extends Activity implements OnClickListener{

	RadioGroup radioGroup;
	TextView t1,t2;
	
	Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_miniapp);
		
		radioGroup=(RadioGroup) findViewById(R.id.radioGroup1);
		
	t1=(TextView) findViewById(R.id.textView8);
	t2=(TextView) findViewById(R.id.textView9);
	
		b= (Button) findViewById(R.id.button1);
		
		b.setOnClickListener(this);
		//Log.d("up", "up");
		t1.setOnClickListener(this);
		t2.setOnClickListener(this);
	
		
		//Toast.makeText(getApplicationContext(), "Herre"+m, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent obj;
		if(radioGroup.getCheckedRadioButtonId()==R.id.radio0)
		{
			obj=new Intent(this,Net.class);
			startActivity(obj);
		}
		else if(radioGroup.getCheckedRadioButtonId()==R.id.radio1)
		{
			obj=new Intent(this,Qcall.class);
			startActivity(obj);
		}
		/*else if(gp.getCheckedRadioButtonId()==R.id.radio2)
		{
			obj=new Intent(this,Dictionary.class);
			startActivity(obj);
		}*/
		
		else if(radioGroup.getCheckedRadioButtonId()==R.id.radio6)
			
		{
			obj=new Intent(this,Call.class);
			startActivity(obj);
		}
		
			else if(radioGroup.getCheckedRadioButtonId()==R.id.radio4)
			
		{
			obj=new Intent(this,Sms.class);
			startActivity(obj);
			
		}
		else if(v.getId()==R.id.textView8){
			obj=new Intent(Intent.ACTION_DIAL);
			obj.setData(Uri.parse("tel: 8195955140"));
			startActivity(obj);
			
		}
		else if(v.getId()==R.id.textView9){
			obj=new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+
		
					
					
					t2.getText().toString()));
		
			
			startActivity(obj);
			
		}	
		else
			Toast.makeText(getApplicationContext(), "Herre", Toast.LENGTH_SHORT).show();
		
		
	}
}

/*class RadioGroupListener implements OnClickListener
{

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Log.d("here", "here");
	}
	}*/