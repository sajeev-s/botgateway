package it.sella.bg.core.im.action;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActionConfig {

	@Bean
	public CheckLicense checkLicense(){
		return new CheckLicense();
	}

	@Bean
	public NewChat newChat(){
		return new NewChat();
	}

	@Bean
	public ChatMessage chatMessage(){
		return new ChatMessage();
	}

	@Bean
	public ChatTyping chatTyping(){
		return new ChatTyping();
	}

	@Bean
	public EndChat endChat(){
		return new EndChat();
	}
}
