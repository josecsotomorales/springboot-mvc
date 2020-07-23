package com.jose.demo.controller;

import com.jose.demo.model.ChatForm;
import com.jose.demo.model.ChatMessage;
import com.jose.demo.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping
    public String getChatPage(ChatForm chatForm, Model model) {
        model.addAttribute("chatMessages", this.chatService.getChatMessages());
        return "chat";
    }

    @PostMapping
    public String postChatMessage(ChatForm chatForm, Model model) {
        this.chatService.addMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("chatMessages", this.chatService.getChatMessages());
        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes () {
        return new String[] { "Say", "Shout", "Whisper" };
    }

}
