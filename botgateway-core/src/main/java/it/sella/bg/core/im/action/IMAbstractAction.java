package it.sella.bg.core.im.action;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import it.sella.bg.external.im.IMserviceImpl;
import it.sella.bg.im.dto.request.IMRequest;
import it.sella.bg.im.dto.response.IMResponse;
import it.sella.bg.util.BGCONSTANT;


public abstract class IMAbstractAction implements IMAction{

	@Autowired
	IMserviceImpl imService;



	@Override
	public void handleRequest(IMRequest imRequest) {
		final HttpSession session = getSession();
		System.out.println("Session Set -->"+session.getId()+" -- "+session.getAttribute(BGCONSTANT.CHATID.VALUE)+" -- "+session.getAttribute(BGCONSTANT.CHATURL.VALUE));
		if(StringUtils.isNotEmpty((String)session.getAttribute(BGCONSTANT.CHATURL.VALUE))){
			//			imRequest.setChatid((String)session.getAttribute(BGCONSTANT.CHATID.VALUE));
			imRequest.setChaturl((String)session.getAttribute(BGCONSTANT.CHATURL.VALUE));
		}

	}

	public static HttpSession getSession() {
		final ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getSession(true); 
	}

	@Override
	public IMResponse sendMessage(IMRequest imRequest) {
		final IMResponse imResponse = this.imService.message(imRequest);
		return imResponse;
	}

	@Override
	public IMResponse process(IMRequest imRequest) {
		handleRequest(imRequest);
		final IMResponse imResponse = sendMessage(imRequest);
		handleResponse(imRequest, imResponse);
		return imResponse;
	}






}
