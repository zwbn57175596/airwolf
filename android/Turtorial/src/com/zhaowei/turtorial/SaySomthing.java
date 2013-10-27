package com.zhaowei.turtorial;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SaySomthing extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_say_somthing);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.say_somthing, menu);
		return true;
	}

}
