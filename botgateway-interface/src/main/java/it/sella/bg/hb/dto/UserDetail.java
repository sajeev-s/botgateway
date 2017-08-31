package it.sella.bg.hb.dto;

import java.util.List;

import it.sella.bg.im.dto.request.Alias;

public class UserDetail {

	List<Alias> alias;
	String userId;
	String chatid;


	public List<Alias> getAlias() {
		return this.alias;
	}
	public void setAlias(List<Alias> alias) {
		this.alias = alias;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getChatid() {
		return this.chatid;
	}
	public void setChatid(String chatid) {
		this.chatid = chatid;
	}



}
