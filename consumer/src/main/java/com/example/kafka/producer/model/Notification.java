package com.example.kafka.producer.model;

public class Notification {
	String code;
	String source;
	String hostKey;
	String actor;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getHostKey() {
		return hostKey;
	}

	public void setHostKey(String hostKey) {
		this.hostKey = hostKey;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	@Override
	public String toString() {
		return "Notification [code=" + code + ", source=" + source + ", hostKey=" + hostKey + ", actor=" + actor + "]";
	}

}
