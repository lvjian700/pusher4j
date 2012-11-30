package com.dayang.pusher4j;

import lombok.Getter;
import lombok.Setter;

/**
 * 内部消息封装
 * @author lvjian
 *
 */
@Getter@Setter
public class PusherMessage {
	
	private String to = null;
	private String event = null;	
	
	/** json 格式的 string */
	private String body = null;
	
	public PusherMessage() {
		
	}

}
