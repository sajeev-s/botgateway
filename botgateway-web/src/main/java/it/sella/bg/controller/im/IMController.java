package it.sella.bg.controller.im;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.sella.bg.core.im.IMActionHandler;
import it.sella.bg.hb.dto.UserDetail;
import it.sella.bg.im.dto.request.EventData;
import it.sella.bg.im.dto.request.IMRequest;
import it.sella.bg.im.dto.request.Parameter;
import it.sella.bg.im.dto.response.IMResponse;
import it.sella.bg.listener.util.SessionUtil;
import it.sella.bg.poll.dto.PollMessage;
import it.sella.bg.util.BGCONSTANT;

@RestController
@RequestMapping(value = "/im")
public class IMController {

	@Autowired
	IMActionHandler actionHandler; 


	@RequestMapping(value = "/syncuserdetail", method = {RequestMethod.POST})
	public @ResponseBody void syncEventData( @RequestBody UserDetail userDetail) {

		final HttpSession httpSession = SessionUtil.getSession(userDetail.getChatid());
		httpSession.setAttribute(BGCONSTANT.USERDETAIL.VALUE, userDetail);
		//		return BGCONSTANT.OK.VALUE;
	}

	@RequestMapping(value = "/chat", method = {RequestMethod.POST})
	public @ResponseBody IMResponse chat(@RequestBody IMRequest imRequest) {
		System.out.println("Inside chat -->");
		final IMResponse imResponse = this.actionHandler.process(imRequest);

		return imResponse;
	}

	@RequestMapping(value = "/poll", method = {RequestMethod.POST})
	public @ResponseBody List<PollMessage> pool(@RequestBody IMRequest imRequest,HttpSession session) {
		System.out.println("Inside poll -->");
		return (List<PollMessage>)session.getAttribute(BGCONSTANT.POLLMESSAGE.VALUE);
	}

	@RequestMapping(value = "/chatresult", method = {RequestMethod.POST})
	public void chatresult(@RequestBody IMRequest imRequest) throws Exception {

		System.out.println("inside chat result");
		System.out.println(imRequest.getAction() +" -- "+imRequest.getChatid()+" -- "+imRequest.getIdevent());
		if(imRequest.getEventdata()!=null){
			System.out.println("######### Event Data ###########");
			final List<EventData> eventDatas = imRequest.getEventdata();
			for (final EventData eventData : eventDatas) {
				System.out.println(eventData.getName()+ "="+eventData.getValue());
			}
		}

		if(imRequest.getParameters()!=null){
			System.out.println("######### Parameters ###########");
			final List<Parameter> parameters = imRequest.getParameters();
			for (final Parameter parameter : parameters) {
				System.out.println(parameter.getName()+"="+parameter.getName());
			}
		}

		for (final EventData eventData : imRequest.getEventdata()) {
			if(BGCONSTANT.MESSAGE.VALUE.equals(eventData.getName())){
				if(StringUtils.isNotEmpty(imRequest.getChatid())){
					final HttpSession session = SessionUtil.getSession(imRequest.getChatid());
					if(session!=null){
						final PollMessage pollMessage = new PollMessage();
						pollMessage.setSender(BGCONSTANT.BOT.VALUE);
						pollMessage.setMessage((String)eventData.getValue());
						final List<PollMessage> pollMessages = (List<PollMessage>)session.getAttribute(BGCONSTANT.POLLMESSAGE.VALUE);
						pollMessages.add(pollMessage);
					}else{
						throw new Exception("invalid session -->"+imRequest.getChatid());
					}

				}
			}

		}

	}
}
