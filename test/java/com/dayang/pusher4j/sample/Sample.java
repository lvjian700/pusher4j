package com.dayang.pusher4j.sample;

import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.dayang.pusher4j.Pusher;


public class Sample {
	
	static String to = "/column";
	static String event = "news";
	
	public static void main(String[] args) throws MalformedURLException, JSONException {
		
		Pusher pusher = new Pusher("http://127.0.0.1:3000/");

		// This line is cached until the connection is establisched.
		for(int i = 0; i < 10; i++) {
			JSONObject json = new JSONObject();
			json.put("msg", "haha");
			
			pusher.pub(to, event, json.toString());
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
						
		}
		
		System.exit(0);
	}

}
