package com.thingy.commth.http.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/hi")
    public String test(@AuthenticationPrincipal OAuth2User principal) {
        log.info("access");
        log.info(principal.getAttributes().toString());
        return "hello";
    }
}
