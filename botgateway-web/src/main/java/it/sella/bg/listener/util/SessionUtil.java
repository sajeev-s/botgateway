package it.sella.bg.listener.util;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpSession;

import it.sella.bg.util.BGCONSTANT;

public class SessionUtil {

	public static final Map<String, HttpSession> activeSessionMap = new Hashtable<String, HttpSession>();

	public static HttpSession getSession(String chatid){
		HttpSession session = null;
		final Collection<HttpSession> sessions = activeSessionMap.values();
		for (final HttpSession httpSession : sessions) {
			if(chatid.equals(httpSession.getAttribute(BGCONSTANT.CHATID.VALUE))){
				session = httpSession;
				break;
			}
		}

		return session;
	}

}
