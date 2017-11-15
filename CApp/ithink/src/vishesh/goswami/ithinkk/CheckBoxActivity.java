package vishesh.goswami.ithinkk;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CheckBoxActivity extends Activity {

	CheckBox c1,c2,c3,c4;
	TextView t1,t2,t3,t4,W;
	EditText t5,t6,t7,t8;
	int q1=0,q2=0,q3=0,q4=0;
	int total;
	Button b1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_box);
		b1=(Button) findViewById(R.id.button1);
		t1=(TextView) findViewById(R.id.textView2);
		t2=(TextView) findViewById(R.id.textView3);
		t3=(TextView) findViewById(R.id.textView4);
		t4=(TextView) findViewById(R.id.textView5);
		t5=(EditText) findViewById(R.id.editText1);
		t6=(EditText) findViewById(R.id.editText2);
		t7=(EditText) findViewById(R.id.editText3);
		t8=(EditText) findViewById(R.id.editText4);
		W=(TextView) findViewById(R.id.textView7);
		c1=(CheckBox) findViewById(R.id.checkBox1);
		c2=(CheckBox) findViewById(R.id.checkBox2);
		c3=(CheckBox) findViewById(R.id.checkBox3);
		c4=(CheckBox) findViewById(R.id.checkBox4);
		
		
		
		t1.setVisibility(View.INVISIBLE);
		t2.setVisibility(View.INVISIBLE);
		t3.setVisibility(View.INVISIBLE);
		t4.setVisibility(View.INVISIBLE);
		
		t5.setVisibility(View.INVISIBLE);
		t6.setVisibility(View.INVISIBLE);
		t7.setVisibility(View.INVISIBLE);
		t8.setVisibility(View.INVISIBLE);
		
		c1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				if(c1.isChecked())
				{
					
					t5.setVisibility(View.VISIBLE);
					t1.setVisibility(View.VISIBLE);
					t1.setText("100");
				
					
				}
				else{
				
				t5.setVisibility(View.INVISIBLE);
				t1.setVisibility(View.INVISIBLE);
				
				}
				}});
		
		c2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				if(c2.isChecked())
				{
					t2.setText("50");
					t6.setVisibility(View.VISIBLE);
					t2.setVisibility(View.VISIBLE);
							
					
					}
				else{
				
				t2.setVisibility(View.INVISIBLE);
				
				t6.setVisibility(View.INVISIBLE);
				}
				}});

		c3.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				if(c3.isChecked())
				{
					t3.setText("150");
					t7.setVisibility(View.VISIBLE);
					t3.setVisibility(View.VISIBLE);
				
				}
				else{
			
				t3.setVisibility(View.INVISIBLE);
						
				t7.setVisibility(View.INVISIBLE);
				}
				}});

		c4.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				if(c4.isChecked())
				{
					t4.setText("40");
					t8.setVisibility(View.VISIBLE);
					t4.setVisibility(View.VISIBLE);
					
					
				}
				else{
				
				t4.setVisibility(View.INVISIBLE);
				
				t8.setVisibility(View.INVISIBLE);
				}
				}});
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			if(t5.getVisibility()==0)
			{	
				if(t5.getText().toString().equals(""))
				{	q1=0;
				
				}else
					q1=Integer.parseInt(t5.getText().toString());
			
			}
			else{
				q1=0;
			}
			if(t6.getVisibility()==0)
			{if(t6.getText().toString().equals(""))
				q2=0;
				else
					q2=Integer.parseInt(t6.getText().toString());
			}
			else
				q2=0;
			if(t7.getVisibility()==0)
			{if(t7.getText().toString().equals(""))
				q3=0;
				else
					q3=Integer.parseInt(t7.getText().toString());
			}
			else
				q3=0;
			if(t8.getVisibility()==0)
			{if(t8.getText().toString().equals(""))
				q4=0;
				else
					q4=Integer.parseInt(t8.getText().toString());
			}
			else
				q4=0;
			
			
	total=(100*q1)+(50*q2)+(150*q3)+(40*q4);
			W.setText(String.valueOf(total));
				
				
		}});
		
		
		

	}
	}
		
		