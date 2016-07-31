package com.example.servicedemo;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends Activity
{
	EditText editData;
	Button buttonStart,buttonStop;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		editData = (EditText) findViewById(R.id.editText1);
		buttonStart = (Button) findViewById(R.id.button1);
		buttonStop = (Button) findViewById(R.id.button2);
		
		buttonStart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String str = editData.getText().toString();
				Intent in = new Intent(HomeActivity.this,FileService.class);
				in.putExtra("data", str);
				startService(in);	//this intent will go -->OS			
				
			}
		});
		
		buttonStop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(HomeActivity.this, FileService.class);
				stopService(in);
				
			}
		});
		
		
	}
}
