package com.example.httpclient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.location.GpsStatus.Listener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.TextureView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listen();
		
	}


	private void listen(){
		new AsyncTask<Void, String, Void>() {

			@Override
			protected Void doInBackground(Void... params) {
				// TODO Auto-generated method stub
				
				try {
					ServerSocket ss = new ServerSocket(12345);
					while(true){
						
						Socket sk = ss.accept();
						
						publishProgress("connection comes");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return null;
			}

			@Override
			protected void onProgressUpdate(String... values) {
				// TODO Auto-generated method stub\
				
				//Toast.makeText(MainActivity.this, values[0], 1000).show();
				TextView tView = (TextView) findViewById(R.id.tvContent);
				tView.setText(values[0]);
				
				super.onProgressUpdate(values);
			}
			
			
		}.execute();
	}
}
