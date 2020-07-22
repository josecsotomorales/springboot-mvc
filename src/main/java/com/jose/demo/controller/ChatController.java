package com.jose.demo.controller;

import com.jose.demo.service.ChatService;
import com.jose.demo.service.MessageListService;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }



}
