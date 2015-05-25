package com.sancang.httpget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button btnGet;
	TextView tvContent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnGet = (Button) findViewById(R.id.btnGet);
		tvContent = (TextView) findViewById(R.id.tvContent);
		
		btnGet.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				httpGetContent("http://www.baidu.com");
			}
		});
	}

	
	private void httpGetContent(String url){
		
		new AsyncTask<String, Float, String>(){

			@Override
			protected void onPreExecute() {
				// TODO Auto-generated method stub
				super.onPreExecute();
			}

			@Override
			protected void onPostExecute(String result) {
				// TODO Auto-generated method stub
				
				tvContent.setText(result);
				super.onPostExecute(result);
			}

			@Override
			protected void onProgressUpdate(Float... values) {
				// TODO Auto-generated method stub
				super.onProgressUpdate(values);
			}

			@Override
			protected void onCancelled(String result) {
				// TODO Auto-generated method stub
				super.onCancelled(result);
			}

			@Override
			protected void onCancelled() {
				// TODO Auto-generated method stub
				super.onCancelled();
			}

			@Override
			protected String doInBackground(String... params) {
				// TODO Auto-generated method stub
				try {
					URL url = new URL(params[0]);
					
					URLConnection connection = url.openConnection();
					InputStream is = connection.getInputStream();
					InputStreamReader isr = new InputStreamReader(is, "utf-8");
					BufferedReader br = new BufferedReader(isr);
					
					String line;
					StringBuilder sbBuilder = new StringBuilder();
					
					while((line = br.readLine()) != null){
						sbBuilder.append(line).append('\n');
						
						setProgress(20);
					}
					
					br.close();
					isr.close();
					is.close();
					
					return sbBuilder.toString();
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				return null;
			}
			
		}.execute(url);
		
	}
}
