package it.sella.bg.core.im.action;

import javax.servlet.http.HttpSession;

import it.sella.bg.im.dto.request.IMRequest;
import it.sella.bg.im.dto.response.IMResponse;
import it.sella.bg.util.BGCONSTANT;

public class NewChat extends IMAbstractAction{

	@Override
	public void handleRequest(IMRequest imRequest) {

	}

	@Override
	public void handleResponse(IMRequest imRequest, IMResponse imResponse) {

		final HttpSession session = getSession();
		if(BGCONSTANT.OK.VALUE.equalsIgnoreCase(imResponse.getResult())){
			session.setAttribute(BGCONSTANT.CHATID.VALUE, imResponse.getChatid());
			session.setAttribute(BGCONSTANT.CHATURL.VALUE, imResponse.getChaturl());
		}

		System.out.println("Session Set -->"+session.getId()+" -- "+session.getAttribute(BGCONSTANT.CHATID.VALUE)+" -- "+session.getAttribute(BGCONSTANT.CHATURL.VALUE));

	}

}
