package it.sella.bg.core.im;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sella.bg.core.im.action.ChatMessage;
import it.sella.bg.core.im.action.ChatTyping;
import it.sella.bg.core.im.action.CheckLicense;
import it.sella.bg.core.im.action.EndChat;
import it.sella.bg.core.im.action.IMAction;
import it.sella.bg.core.im.action.NewChat;
import it.sella.bg.im.dto.request.IMRequest;
import it.sella.bg.im.dto.response.IMResponse;

@Component
public class IMActionHandler {

	Map<String, IMAction> actions;

	@Autowired
	CheckLicense checkLicense;
	@Autowired
	NewChat newChat;
	@Autowired
	ChatMessage chatMessage;
	@Autowired
	ChatTyping chatTyping;
	@Autowired
	EndChat endChat;


	public IMActionHandler(){

	}

	public void intialize(){
		this.actions = new HashMap<String, IMAction>();
		this.actions.put("checklicense", this.checkLicense);
		this.actions.put("newchat", this.newChat);
		this.actions.put("chatmessage", this.chatMessage);
		this.actions.put("chattyping", this.chatTyping);
		this.actions.put("endchat", this.endChat);
	}

	public IMResponse process(IMRequest imRequest){
		if(this.actions==null){
			intialize();
		}
		String key = imRequest.getAction();
		if(StringUtils.isNotEmpty(StringUtils.trim(imRequest.getIdevent()))){
			key = imRequest.getIdevent();
		}
		System.out.println("key-->"+key);
		final IMAction action = this.actions.get(key);

		return action.process(imRequest);
	}

}
