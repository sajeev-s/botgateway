package it.sella.bg.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import it.sella.bg.listener.util.SessionUtil;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent paramHttpSessionEvent) {
		System.out.println("SessionCreated -->"+paramHttpSessionEvent.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent paramHttpSessionEvent) {
		SessionUtil.activeSessionMap.remove(paramHttpSessionEvent.getSession().getId());
		System.out.println("SessionDestroyed -->"+paramHttpSessionEvent.getSession().getId());
	}

}
