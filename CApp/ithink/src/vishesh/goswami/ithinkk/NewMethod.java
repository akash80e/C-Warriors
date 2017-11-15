package vishesh.goswami.ithinkk;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewMethod extends Activity implements OnClickListener{
	
	Button b1,b2,b3,b4;
	EditText e1,e2;
	TextView e3,e4,e5,e6;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		e3=(TextView)findViewById(R.id.textView2);
		e4=(TextView)findViewById(R.id.textView3);
		e5=(TextView)findViewById(R.id.textView4);
		e6=(TextView)findViewById(R.id.textView5);
		

		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		b3=(Button)findViewById(R.id.button3);
		b4=(Button)findViewById(R.id.button4);
		
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);

	}

	@Override
	public void onClick(View obj) {
		// TODO Auto-generated method stub
		
		
		
			int a,b;
			a=Integer.parseInt( e1.getText().toString());
			b=Integer.parseInt( e2.getText().toString());

			if(obj.getId()==R.id.button1)
			{
				e3.setText(String.valueOf(a+b));
			}
			else if(obj.getId()==R.id.button2)
			{
				e4.setText(String.valueOf(a-b));
			}
			else if(obj.getId()==R.id.button3)
			{
				e5.setText(String.valueOf(a*b));
			}
			else
			{
				e6.setText(String.valueOf(a/b));
				
			}
	}
	
}
