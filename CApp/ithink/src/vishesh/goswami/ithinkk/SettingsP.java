package vishesh.goswami.ithinkk;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.app.Activity;
import android.view.Menu;

public class SettingsP extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
			
addPreferencesFromResource(R.xml.wantsound);
		
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_settings_p, menu);
		return true;
	}

}
	