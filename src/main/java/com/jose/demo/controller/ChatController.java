package com.jose.demo.controller;

import com.jose.demo.dto.ChatForm;
import com.jose.demo.dto.ChatMessage;
import com.jose.demo.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController {

    ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat")
    public String getChat(ChatMessage chatMessage, Model model) {
        model.addAttribute("username");
        chatService.getMessages();
        return "chat";
    }

    @PostMapping("/chat")
    public String addMessage(ChatForm chatForm, Model model) {
        chatService.addMessage(chatForm.getUsername(), chatForm.getMessageText());
        model.addAttribute("chat", chatService.getMessages());
        chatForm.setUsername("");
        chatForm.setMessageText("");
        return "chat";
    }

}
