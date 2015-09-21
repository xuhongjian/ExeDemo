package com.example.exedemo.activity;

import com.example.exedemo.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class WelComeActivity extends Activity {

	private CountDownTimer time;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		time = new CountDownTimer(2000,1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				Intent intent = new Intent(WelComeActivity.this,LoginActivity.class);
				startActivity(intent);
				finish();
			}
		}.start();
	}

	
	
}
