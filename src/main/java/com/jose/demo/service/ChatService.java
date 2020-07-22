package com.jose.demo.service;

import com.jose.demo.dto.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {

    private List<ChatMessage> messages;

    @PostConstruct
    public void postConstruct() {
        this.messages = new ArrayList<>();
    }

    public void addMessage(String username, String message) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUsername(username);
        chatMessage.setMessage(message);
        this.messages.add(chatMessage);
    }

    public List<ChatMessage> getMessages() {
        return new ArrayList<>(this.messages);
    }

}
