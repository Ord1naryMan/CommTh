package com.thingy.commth.http.rest;

import com.thingy.commth.dto.UserCreateEditDto;
import com.thingy.commth.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/oauth")
@RequiredArgsConstructor
@Slf4j
public class OauthRestController {

    private final UserService userService;

    @GetMapping("/ensureuser")
    public void user(@AuthenticationPrincipal OAuth2User principal) {
        String uName = principal.getAttribute("login");
        if (uName == null) {
            log.info("username is null");
            return;
        }
        if(!userService.isUsernameExists(uName)) {
            userService.save(UserCreateEditDto.builder()
                            .username(uName)
                            .mail(principal.getAttribute("email"))
                    .build());
        }
        log.info("ensure user here");
    }
}
