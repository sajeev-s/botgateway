package it.sella.bg.core.im.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import it.sella.bg.im.dto.request.EventData;
import it.sella.bg.im.dto.request.IMRequest;
import it.sella.bg.im.dto.response.IMResponse;
import it.sella.bg.poll.dto.PollMessage;
import it.sella.bg.util.BGCONSTANT;

public class ChatMessage extends IMAbstractAction {

	@Override
	public void handleRequest(IMRequest imRequest) {


		final List<EventData> eventDatas = imRequest.getEventdata();
		if(eventDatas!=null){
			for (final EventData eventData : eventDatas) {
				if(eventData.getName().equals(BGCONSTANT.MESSAGE.VALUE)){
					final HttpSession session = getSession();
					final PollMessage pollMessage = new PollMessage();
					pollMessage.setSender(BGCONSTANT.CLIENT.VALUE);
					pollMessage.setMessage((String)eventData.getValue());
					final List<PollMessage> pollMessages = (List<PollMessage>)session.getAttribute(BGCONSTANT.POLLMESSAGE.VALUE);
					pollMessages.add(pollMessage);

				}
			}

		}
		super.handleRequest(imRequest);

	}

	@Override
	public void handleResponse(IMRequest imRequest, IMResponse imResponse) {
		// TODO Auto-generated method stub

	}

}
