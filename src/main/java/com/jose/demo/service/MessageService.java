package com.jose.demo.service;

import com.jose.demo.model.ChatForm;
import com.jose.demo.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private List<ChatMessage> chatMessages;

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
        this.chatMessages = new ArrayList<>();
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()) {
            case "Say" -> newMessage.setMessage(chatForm.getMessageText());
            case "Shout" -> newMessage.setMessage(chatForm.getMessageText().toUpperCase());
            case "Whisper" -> newMessage.setMessage(chatForm.getMessageText().toLowerCase());
        }
        this.chatMessages.add(newMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }
}
