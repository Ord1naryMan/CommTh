package com.thingy.commth.http.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    @GetMapping
    public String showMessageSending() {
        return "message/test.html";
    }
}
