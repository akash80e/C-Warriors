package com.example.capp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.example.capp.ProjectDatabase;
import com.example.capp.R;
import com.example.capp.R.id;
import com.example.capp.R.layout;
import com.example.capp.R.menu;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Project extends Activity{
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.activity_project, menu);
		return true;
	}
	
	
	
	@Override
	protected void onPause() {
		
		if(player !=null && player.isPlaying())
		{
			player.pause();
		}
		super.onPause();
	}
	@Override
	protected void onResume() {
	
		if(player !=null )
		{
			player.start();
		}
		super.onResume();
	}


	long startTime=0L;
	int i=0;
	Handler custom=new Handler();
	long timeInMilliseconds=0L;
	long timeSwapBuff=0L;
	long updateTime=0L;
	 boolean checked;
	
	  TextView textview,textview2 ;
	  RadioGroup radiogroup;
	  RadioButton radiobutton;
	  RadioButton radio0,radio1,radio2,radio3;
	  int id=1;
	  int answer=0;
	String correctanswer=null,temp=null,questionget;
	 ProjectDatabase object;
	  SQLiteDatabase mydatabase;
	  Button timerText,index;
	  ArrayList<String> fetcheddata=new ArrayList<String>();
	
	MediaPlayer player;
	  
	  @Override
	protected void onCreate(Bundle savedInstanceState) 
	  {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_project);
		timerText=(Button) findViewById(R.id.button2);
		
		
		initialise();
		
		
		
	 
		
		plays( R.raw.pirate);
		player.setLooping(true);
			callDatabase( id);

		radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup rg, int clickedid) {
				
				stopTimerfn();
				id++;
				
			//	Toast.makeText(getBaseContext(),String.valueOf(id), Toast.LENGTH_SHORT).show();
				
				radiobutton=(RadioButton)findViewById(clickedid);
				temp=(String) radiobutton.getText();
				
				//Toast.makeText(getApplicationContext(),temp , Toast.LENGTH_SHORT).show();	
			
				if(temp.equals(correctanswer))
						{
				//	Toast.makeText(getBaseContext(),"it worked", Toast.LENGTH_SHORT).show();
					answer++;

					plays( R.raw.clap);
					
						}
				
				else
				{

					plays( R.raw.wrong);
				
			//		Toast.makeText(getBaseContext(),"it not worked worked", Toast.LENGTH_SHORT ).show();
					
				}
				
			
				if(id<11)
				{
				
				callDatabase( id);
				}
				else
				{
				//	Toast.makeText(getBaseContext(),"khtammmm!!!", Toast.LENGTH_SHORT ).show();
			//	if all the answers are right then this will work and work in the end when ques. are over
				
					
							// TODO Auto-generated method stub
							callIntent(answer);
				
					
				
					
					
					
					
				/*	if(answer>7)
					{
						answer=0;
						Toast.makeText(getBaseContext(),"BRAVOOOO!!!!", Toast.LENGTH_SHORT ).show();
					}
					
					else
					{
						id=1;
						callDatabase(id);
					answer=0;	
					}
					*/
				}
				
			
			}
		});
		
		
		}
	  @Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// TODO Auto-generated method stub
			
			Intent myintent = null;
			if(item.toString().equals("Share"))
			{
				Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
				sharingIntent.setType("text/plain");
				String shareBody = questionget;
				sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Hey Dear , Help me out to Solve this VAPLAB's question\n");
				sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
				startActivity(Intent.createChooser(sharingIntent, "Share via"));
			}
		
			
			return super.onOptionsItemSelected(item);
		}


		
	private void callDatabase(int id) {
	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timerText.setTextColor(Color.GRAY);
		
		startTimerfn();

		plays( R.raw.pirate);
	player.setLooping(true);
	
		radio0.setChecked(false);
		radio1.setChecked(false);
		radio2.setChecked(false);
		radio3.setChecked(false);
		
		   object =new ProjectDatabase(this);
		object.open();
		index.setText(id + " / 10");
		textview2.setText(String.valueOf(answer));
		questionget= object.fetchQuestion(id) ;
		textview.setText("Ques." + id + " " + object.fetchQuestion(id)); 
		radio0.setText(object.fetchOption1(id));
		radio1.setText(object.fetchOption2(id));
		radio2.setText(object.fetchOption3(id));
		radio3.setText(object.fetchOption4(id));
		correctanswer=object.fetchCorrect(id);
		//Toast.makeText(getBaseContext(),String.valueOf(correctanswer), Toast.LENGTH_SHORT ).show();
		object.close();
		
		
	}

	void plays(int a)
	{
		
			if(player!=null && player.isPlaying())
			{
				player.stop();
			}
			
			player=MediaPlayer.create(getBaseContext(), a);
			player.start();
	
		
		}
		
	
	private void initialise() {
		

		textview = (TextView) findViewById(R.id.textView1);
		textview2 = (TextView) findViewById(R.id.textView3);
		
		radiogroup=(RadioGroup) findViewById(R.id.radioGroup1);
		radio0 = (RadioButton) findViewById(R.id.radio0);
		radio1 = (RadioButton) findViewById(R.id.radio1);
		radio2 = (RadioButton) findViewById(R.id.radio2);
		radio3 = (RadioButton) findViewById(R.id.radio3);
		index=(Button) findViewById(R.id.button3);
		
	}

/*	@Override
/*	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu., menu);
		return true;
	}*/
	
public void startTimerfn(){
		
	
		timerVariables();
		
		startTime=SystemClock.uptimeMillis();
		custom.postDelayed(updateTimerThread,0);

	}

private void timerVariables() {
	// TODO Auto-generated method stub
	startTime=0L;
	 timeInMilliseconds=0L;
	 timeSwapBuff=0L;
	 updateTime=0L;
	// timerText.setText("10 : 00 : 000");	
}




public void stopTimerfn(){
		
	timeSwapBuff+=timeInMilliseconds;
	
	custom.removeCallbacks(updateTimerThread);
	// TODO Auto-generated method stub
	
	}

	
	private Runnable updateTimerThread=new Runnable() {
		
		@Override
		public void run() {
		
			
			timeInMilliseconds=SystemClock.uptimeMillis() - startTime;
			updateTime =timeSwapBuff + timeInMilliseconds;
			 
			int sec=(int)(updateTime/1000);
			int mins = sec/60;
		//	Toast.makeText(getBaseContext(),String.valueOf(sec)+ id, Toast.LENGTH_SHORT ).show();
			
			mins= 2-(mins+1);
			if(mins == 0)
			{
				timerText.setTextColor(Color.RED);
			}
			if(mins == -1 )
			{
				
				if(id>10)
				{
					callIntent(answer);
				}
				else
				{
				callDatabase(id);
				}
				
			}
			
			
			sec=sec%60;
			sec=60-(sec+1);
			int milliseconds = (int)(updateTime %1000);
			milliseconds=1000-milliseconds;
			timerText.setText("" + mins + ":" + String.format("%02d", sec) );
			custom.postDelayed(this,0);
			
		}
	};

	protected void callIntent(int answer2) {
		// TODO Auto-generated method stub
		stopTimerfn();
		Intent intent = new Intent(Project.this,Score.class);
		intent.putExtra("score", answer);
		
		startActivity(intent);
		
	}

}
