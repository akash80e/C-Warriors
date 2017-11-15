package com.example.capp;

import com.example.capp.R;
import com.example.capp.R.layout;
import com.example.capp.R.menu;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ImageView;
	
 
public class Score extends Activity {

	EditText editText;
	ImageView imageView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score);
		
		
		editText = (EditText) findViewById(R.id.editText1);
		imageView = (ImageView) findViewById(R.id.imageView1);
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int score = Score.this.getIntent().getExtras().getInt("score");
				editText.setText(String.valueOf(score));
				
				
			}
		}, 0);
		
		
		
	}


	
}
