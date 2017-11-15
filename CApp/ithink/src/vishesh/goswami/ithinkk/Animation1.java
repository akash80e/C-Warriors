package vishesh.goswami.ithinkk;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Animation1 extends Activity {
	
	ImageView image1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animation1);
		image1=(ImageView) findViewById(R.id.imageView1);
	
		image1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Animation my=AnimationUtils.loadAnimation(getBaseContext(), R.anim.animation_tween);
			image1.startAnimation(my);	
			my.setFillAfter(true);
			
			}
		});
		
	
	}


}
