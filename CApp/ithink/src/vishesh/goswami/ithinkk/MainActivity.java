package vishesh.goswami.ithinkk;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener {

	 EditText et1,et2,et3;
	 TextView t1;
	 Button b, b2;
		
		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       
//		et1= (EditText)findViewById(R.id.editText1);
//		et2= (EditText)findViewById(R.id.editText2);
//		et3= (EditText)findViewById(R.id.editText3);
//		
//		t1= (TextView)findViewById(R.id.textView2);
//		
//		b = (Button)findViewById(R.id.button1);
//		b2 = (Button)findViewById(R.id.button2);
		
//		b.setOnClickListener(this);
//		b2.setOnClickListener(this);
    }

	@Override
	public void onClick(View obj) {
		
		if(obj.getId()==R.id.button1)
		{
		
		int a,b,c,d,temp;
		a= Integer.parseInt(et1.getText().toString());
		b= Integer.parseInt(et2.getText().toString());
		c= Integer.parseInt(et3.getText().toString());
		temp=a;
		if(a<b)
		temp=b;
		if(c>temp)
			temp=c;
		
		t1.setText(String.valueOf(temp));
		}
		// TODO Auto-generated method stub
		
		else
		{
			Intent my = new Intent(MainActivity.this,NewMethod.class);
			startActivity(my);
			this.finish();
			
		}
		}
	}

  
    