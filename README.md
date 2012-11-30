##Pusher4j

node-pusher 推送服务器的 Java 客户端。

###1.编译&打包项目

需求:	
1. JDK 1.6+
2. Ant 1.8.x

或者直接使用 eclipse	

__编译打包__	

	ant jar
	
执行后在 __bin/jar__ 目录下会生成

	pusher4j-client.${version}.jar
	
__生成文档__

	ant doc
	
文档生成在 __doc__ 目录下

###2.简单使用

需求:	

1.node.js 0.8.x+ 环境
2.node-pusher 服务器
3.log4j.jar, log4j.properties

__1 开启node-pusher 服务器__	

	cd node-pusher
	node app.js
	

__2 可以直接看 Sample__	

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
	


