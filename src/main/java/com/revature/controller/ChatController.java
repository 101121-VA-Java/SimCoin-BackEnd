package com.revature.controller;

import java.util.ArrayList;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.revature.model.ChatMessage;

@Controller
public class ChatController {
	public static ArrayList<ChatMessage> history = new ArrayList<ChatMessage>();

	@MessageMapping("/hello")
	@SendTo("/message")
	public String greeting(ChatMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay
		System.out.println(message.getName());
		history.add(message);
		System.out.println(history.toString());
		return ("test");
	}

}
