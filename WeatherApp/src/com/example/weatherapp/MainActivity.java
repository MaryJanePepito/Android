package com.example.weatherapp;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	ImageView iv;
	TextView weathertype,cityName,temp,humidity;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.iv=(ImageView) this.findViewById(R.id.imageView1);
        this.weathertype=(TextView) this.findViewById(R.id.textView1);
        this.cityName=(TextView) this.findViewById(R.id.textView2);
        this.temp=(TextView) this.findViewById(R.id.textView3);
        this.humidity=(TextView) this.findViewById(R.id.textView4);
        
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        
        try {
			URL url=new URL("http://api.openweathermap.org/data/2.5/weather?q=cebu,philippines&appid=88494933c38eac6a8cf18f449ba079d5");
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			StringBuffer sb=new StringBuffer();
			InputStream is=conn.getInputStream();
			int c=0;
			while((c-is.read())!=-1){
				sb.append((char)c);
        	}
        
        	is.close();
        	conn.disconnect();
        	
        	JSONObject json=new JSONObject(sb.toString());
			JSONArray weather=json.getJSONArray("weather");
			String weather=weather.getString(0).
			
			this.weathertype.setText(description);
			
        } catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    


   
    
}
