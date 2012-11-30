package com.dayang.pusher4j;

public class PusherMessage {
	
	private String to = null;
	private String event = null;	
	
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
