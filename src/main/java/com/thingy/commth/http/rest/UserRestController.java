package com.thingy.commth.http.rest;

import com.thingy.commth.dto.UserReadDto;
import com.thingy.commth.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;


/**
 * throws: ResponseStatusException(HttpStatus.NOT_FOUND) - if user is not present in database
 */

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserRestController {

    private final UserService userService;

    @GetMapping
    public Map<String, Object> getUser(@AuthenticationPrincipal OAuth2User principal) {
        return new java.util.HashMap<>() {{
            put("username", Objects.requireNonNull(principal.getAttribute("login")));
            put("email", principal.getAttribute("email"));
        }};
    }

    @GetMapping("/{username}")
    public Map<String, Object> getUserByUsername(@PathVariable String username) {
        UserReadDto user = userService.loadUserByUsername(username);
        return Map.of(
          "username", user.getUsername().strip(),
          "mail", user.getMail()
        );
    }
}