package vishesh.goswami.ithinkk;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class Sounds extends Activity {
	
	ImageButton i1,i2;
	Sounds obj;
	MediaPlayer player;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Toast.makeText(getBaseContext(), "created", Toast.LENGTH_LONG).show();
		
		setContentView(R.layout.activity_sounds);
		
		i1=(ImageButton) findViewById(R.id.imageButton1);
		i2=(ImageButton) findViewById(R.id.imageButton2);
	
		i1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			plays(R.raw.clap);
			}
		});
		i2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				plays(R.raw.pirate);
			}
		});
		
	}
	@Override
	protected void onDestroy() {
		Toast.makeText(getBaseContext(), "destroyed", Toast.LENGTH_LONG).show();
			// TODO Auto-generated method stub
		super.onDestroy();
	}
	@Override
	protected void onPause() {
		if(player!=null && player.isPlaying() )
			player.pause();
		
		super.onPause();
		Toast.makeText(getBaseContext(), "paused", Toast.LENGTH_LONG).show();
	}
	@Override
	protected void onRestart() {
		Toast.makeText(getBaseContext(), "restarted", Toast.LENGTH_LONG).show();	// TODO Auto-generated method stub
		super.onRestart();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		if(player!=null){
			player.start();
		}
		Toast.makeText(getBaseContext(), "resumed", Toast.LENGTH_LONG).show();
		super.onResume();
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		Toast.makeText(getBaseContext(), "started", Toast.LENGTH_LONG).show();
		super.onStart();
	}
	@Override
	protected void onStop() {
		Toast.makeText(getBaseContext(), "stopped", Toast.LENGTH_LONG).show();	// TODO Auto-generated method stub
		super.onStop();
	}
	void plays(int a){
			if(player!=null && player.isPlaying())
			{
				player.stop();
			}
			
			player=MediaPlayer.create(getBaseContext(), a);
			player.start();
			
		
	}


}
