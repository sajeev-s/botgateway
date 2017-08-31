package it.sella.bg.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import it.sella.bg.listener.util.SessionUtil;
import it.sella.bg.util.BGCONSTANT;

public class SessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent paramHttpSessionBindingEvent) {
		if(BGCONSTANT.CHATID.VALUE.equals(paramHttpSessionBindingEvent.getName())){
			final HttpSession session = paramHttpSessionBindingEvent.getSession(); 
			SessionUtil.activeSessionMap.put(session.getId(), session);
			System.out.println("Session Chat Id Added -->"+session.getId()+" -- "+paramHttpSessionBindingEvent.getValue());
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent paramHttpSessionBindingEvent) {

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent paramHttpSessionBindingEvent) {

	}

}
