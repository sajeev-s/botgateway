package it.sella.bg.util;

public enum BGCONSTANT {
	OK("OK"),
	CHATID("chatid"),
	USERDETAIL("userdetail"),
	CHATURL("chaturl"),
	POLLMESSAGE("pollmessage"),
	CLIENT("Client"),
	BOT("BOT"),
	MESSAGE("message");

	public String VALUE;

	private BGCONSTANT(final String value) {
		this.VALUE = value;
	}

}
