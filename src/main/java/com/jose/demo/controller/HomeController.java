package com.jose.demo.controller;

import com.jose.demo.model.MessageForm;
import com.jose.demo.service.MessageListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    MessageListService messageListService;

    public HomeController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping({"", "/", "/home"})
    public String getHomePage(@ModelAttribute("messageForm") MessageForm newMessage, Model model) {
        model.addAttribute("greetings", this.messageListService.getMessages());
        return "home";
    }

    @PostMapping("/home")
    public String addMessage(MessageForm messageForm, Model model) {
        messageListService.addMessage(messageForm.getText());
        model.addAttribute("greetings", messageListService.getMessages());
        messageForm.setText("");
        return "home";
    }

}