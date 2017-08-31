package it.sella.bg.core.im.action;

import it.sella.bg.im.dto.request.IMRequest;
import it.sella.bg.im.dto.response.IMResponse;

public interface IMAction {

	public void handleRequest(IMRequest imRequest);

	public void handleResponse(IMRequest imRequest,IMResponse imResponse);

	public IMResponse sendMessage(IMRequest imRequest);

	public IMResponse process(IMRequest imRequest);

	//	public HttpSession getSession();
}
