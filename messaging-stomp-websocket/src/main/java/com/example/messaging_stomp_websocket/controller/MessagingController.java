package com.example.messaging_stomp_websocket.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import com.example.messaging_stomp_websocket.dto.Greeting;
import com.example.messaging_stomp_websocket.dto.HelloMessage;

@RestController
public class MessagingController {
	  @MessageMapping("/hello/{userId}")
	  @SendTo("/topic/greetings/{userId}")
	  public Greeting greeting(HelloMessage message, @DestinationVariable Integer userId) throws Exception {
		System.out.println(userId);
	    Thread.sleep(1000); // simulated delay
	    return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	  }
}
