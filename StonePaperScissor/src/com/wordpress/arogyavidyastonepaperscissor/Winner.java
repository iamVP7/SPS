package com.wordpress.arogyavidyastonepaperscissor;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Winner extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_winner);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.winner, menu);
		return true;
	}
	
	public void exits(View view)
	{
		Intent intent = new Intent(this,MainActivity.class);
		startActivity(intent);
	}

}
