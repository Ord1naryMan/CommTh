package com.thingy.commth.http.rest;

import com.thingy.commth.db.entity.MessageContent;
import com.thingy.commth.dto.MessageCreateEditDto;
import com.thingy.commth.dto.MessageShowDto;
import com.thingy.commth.dto.SendMessageDto;
import com.thingy.commth.dto.UserReadDto;
import com.thingy.commth.service.MessageContentService;
import com.thingy.commth.service.MessageService;
import com.thingy.commth.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/message")
@Slf4j
public class MessageRestController {

    private final MessageService messageService;
    private final UserService userService;
    private final MessageContentService messageContentService;


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void send(@AuthenticationPrincipal OAuth2User principal,
                     @RequestBody SendMessageDto sendMessageDto) {

        log.info("Preview:");
        log.info("usernameTo: " + sendMessageDto.getUsernameTo());
        log.info("MessageContent: " + sendMessageDto.getMessageContent());
        long usersIdFrom = userService
                .loadUserByUsername(principal.getAttribute("login"))
                .getId();

        MessageCreateEditDto message = MessageCreateEditDto.builder()
                .usersIdFrom(usersIdFrom)
                //TODO: possibly add "getIdByUsername" in UserService
                .usersIdTo(userService.loadUserByUsername(sendMessageDto.getUsernameTo()).getId())
                .time(LocalDateTime.now())
                .build();

        UUID id = messageService.save(message);

        messageContentService.save(
                MessageContent.builder()
                        .id(id)
                        .messageContent(sendMessageDto.getMessageContent())
                        .build()
        );

        //---test-----
        MessageContent mc = messageContentService.findById(id)
                .orElse(new MessageContent(new UUID(1, 1), "1"));

        log.info(sendMessageDto.getMessageContent() + " " +sendMessageDto.getUsernameTo());
        log.info(mc.getMessageContent() + " " + mc.getId());
        //--end-test----
    }

    @GetMapping
    public List<MessageShowDto> getMessageHistory(@RequestParam String username,
                                                         @RequestParam LocalDate date,
                                                         @AuthenticationPrincipal OAuth2User principal) {
        log.info("trying to show history");
        log.info("Username1: " + username);
        log.info("Username2: " + principal.getAttribute("login"));
        UserReadDto userTo = userService.loadUserByUsername(username);

        if (userTo == null) {
            log.info("Username to is null, I won't send history");
            return List.of();
        }
        List<MessageShowDto> localMessageHistory = messageService
                .getMessageHistory(
                        userService.loadUserByUsername(principal.getAttribute("login")).getId(),
                        userTo.getId(),
                        date.atStartOfDay(),
                        date.plusDays(1).atStartOfDay()
                );

        localMessageHistory.sort(Comparator.naturalOrder());

        return localMessageHistory;
    }
}
