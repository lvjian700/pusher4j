package com.dayang.pusher4j;

import io.socket.IOCallback;
import io.socket.SocketIO;

import java.net.MalformedURLException;

import org.json.JSONObject;

import com.dayang.pusher4j.listener.DefaultPusherListener;

/**
 * 
 * @author lvjian
 *
 */
public class Pusher {
	
	private SocketIO socket = null;		
	
	private final static String PUSHER_EVENT = "push";
	
	/**
	 * 构造Pusher, 采用默认的DefauotPusherListener
	 * {@link DefaultPusherListener}
	 * @param url node-pusher 服务器地址, e.g: http://localhost:3000/
	 */
	public Pusher(String url) {
		try {
			socket = new SocketIO(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		DefaultPusherListener callbackListener 
			= new DefaultPusherListener();
		
		socket.connect(callbackListener);
	}
	
	/**
	 * 执行IOCallback
	 * @param url {@link #Pusher(String)}
	 * @param callbackListner
	 */
	public Pusher(String url, IOCallback callbackListner) {
		try {
			socket = new SocketIO(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		if(callbackListner == null) {
			throw new NullPointerException("The callbackListner can not be null in this constructor. You should use Pusher(String url).");
		}
		
		socket.connect(callbackListner);
	}
	
	/**
	 * 
	 * @param to
	 * @param event
	 * @param json
	 * @return
	 */
	public Pusher pub(String to, String event, String json) {
		PusherMessage message = new PusherMessage();
		message.setTo(to);
		message.setEvent(event);
		message.setBody(json);
		
		socket.emit(PUSHER_EVENT, new JSONObject(message));
		return this;
	}
	
}
