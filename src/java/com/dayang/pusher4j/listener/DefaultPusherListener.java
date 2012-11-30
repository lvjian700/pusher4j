package com.dayang.pusher4j.listener;

import lombok.extern.log4j.Log4j;

import org.json.JSONException;
import org.json.JSONObject;

import io.socket.IOAcknowledge;
import io.socket.IOCallback;
import io.socket.SocketIOException;

/**
 * 默认的推送事件监听器，只将push server推送的信息记录到日志<br />
 * 如果需要对push server做监听， 需要重写这个类。<br/>
 * 在创建Pusher时，需要采用带有IOCallback参数的构造方法: <br />
 * {@link com.dayang.pusher4j.Pusher#Pusher(String, IOCallback)}
 * @author lvjian
 *
 */
@Log4j
public class DefaultPusherListener implements IOCallback {
	
	
	@Override
	public void onMessage(JSONObject json, IOAcknowledge ack) {
		try {
			log.info("Server said:" + json.toString(2));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onMessage(String data, IOAcknowledge ack) {
		log.info("Server said: " + data);
	}

	@Override
	public void onError(SocketIOException socketIOException) {
		log.info("an Error occured");
		socketIOException.printStackTrace();
	}

	@Override
	public void onDisconnect() {
		log.info("Connection terminated.");
	}

	@Override
	public void onConnect() {
		log.info("Connection established");
	}

	@Override
	public void on(String event, IOAcknowledge ack, Object... args) {
		log.info("Server triggered event '" + event + "'");
	}
}
