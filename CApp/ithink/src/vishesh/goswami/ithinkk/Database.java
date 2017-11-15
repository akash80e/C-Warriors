package vishesh.goswami.ithinkk;
/*
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;
*/
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Database extends Activity
{
	EditText edittext1,edittext2,edittext3;
	RadioButton radio1,radio2;
	Button button1,button2,button3;
	long id;
	SQLiteDatabase mydatabase;
	
    public void onCreate(Bundle savedInstanceState) {

       super.onCreate(savedInstanceState);

       setContentView(R.layout.activity_database);
       
       edittext1=(EditText) findViewById(R.id.editText1);
       edittext2=(EditText) findViewById(R.id.editText2);
       edittext3=(EditText) findViewById(R.id.editText3);
       radio1=(RadioButton) findViewById(R.id.radio0);
       radio2=(RadioButton) findViewById(R.id.radio1);
       button1=(Button) findViewById(R.id.button1);
       button2=(Button) findViewById(R.id.button2);
       button3=(Button) findViewById(R.id.button3);
         
       
       button1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
	       myclass db = new myclass(Database.this);

	       db.open();
	       if(radio1.isChecked()){
			 id = db.insertContact(edittext1.getText().toString(),edittext2.getText().toString(),edittext3.getText().toString(),"Male");
	       }
	       else if(radio2.isChecked())
	    	  id = db.insertContact(edittext1.getText().toString(),edittext2.getText().toString(),edittext3.getText().toString(),"Female");
	       
			Toast.makeText(getBaseContext(), String.valueOf(id), Toast.LENGTH_SHORT).show();
			Toast.makeText(getBaseContext(), "Succesfully Saved!!", Toast.LENGTH_SHORT).show();


		    
		       db.close();

		}
	});

       button3.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		
			Intent myintent =new Intent(Database.this,DatabaseList.class);
			startActivity(myintent);
		}
	});
     
       
       if(this.getIntent().getExtras()!=null)
       {
    	   
    	   
    	String id =   this.getIntent().getExtras().getString("id");
    	myclass object = new myclass(this);
    	mydatabase = object.getWritableDatabase();
    	
    	String Query = "select * from contacts2 where _id="+ id;
    	
    	Cursor mycursor = mydatabase.rawQuery(Query, null);
    	   if(mycursor.moveToNext())
    	   {
    		   
    		   edittext1.setText(mycursor.getString(1));
    		   edittext2.setText(mycursor.getString(2));
    		   edittext3.setText(mycursor.getString(3));
    		    if(mycursor.getString(4)== "Male")
    		    	radio1.setChecked(true);
    		    else
    		    	radio2.setChecked(true);
    		
    	   }
    		mydatabase.close();   
    	   
       }
       
       
    }
}

