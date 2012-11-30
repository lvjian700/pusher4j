package com.dayang.pusher4j;

/**
 * 内部消息封装
 * @author lvjian
 *
 */
public class PusherMessage {
	
	private String to = null;
	private String event = null;	
	
	/** json 格式的 string */
	private String body = null;
	
	public PusherMessage() {
		
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
