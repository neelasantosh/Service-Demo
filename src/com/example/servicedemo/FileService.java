package com.example.servicedemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.widget.Toast;

public class FileService extends Service {
	
	String filePath = "";
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Toast.makeText(FileService.this, "on create ", 5).show();
		File sdcardFile = Environment.getExternalStorageDirectory();
		filePath = sdcardFile.getAbsolutePath()+"/data.txt";
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub

		Toast.makeText(FileService.this, "on start command " + startId, 5)
				.show();
		
		try{
			String str = intent.getStringExtra("data");
			FileWriter writer = new FileWriter(filePath,true);
			writer.write(str);
			writer.flush();
			writer.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		/*try {
			FileReader reader = new FileReader(filePath);
			while(true){
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		super.onDestroy();
		Toast.makeText(FileService.this, "on Destroy ", 5).show();
	}
}
