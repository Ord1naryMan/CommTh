package com.thingy.commth.mapper;

import com.thingy.commth.db.entity.Message;
import com.thingy.commth.db.entity.MessageContent;
import com.thingy.commth.dto.MessageCreateEditDto;
import com.thingy.commth.dto.MessageShowDto;
import com.thingy.commth.service.MessageContentService;
import com.thingy.commth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MessageMapper {

    private final UserService userService;
    private final MessageContentService messageContentService;

    public static Message map(MessageCreateEditDto obj) {
        return Message.builder()
                .usersIdFrom(obj.getUsersIdFrom())
                .usersIdTo(obj.getUsersIdTo())
                .time(obj.getTime())
                .build();
    }

    public MessageShowDto mapToShow(Message obj) {
        return MessageShowDto.builder()
                .usernameTo(
                        userService.getUserById(obj.getUsersIdTo())
                                .getUsername().strip()
                )
                .text(messageContentService.findById(obj.getMessageId())
                        .orElse(new MessageContent(
                                obj.getMessageId(),
                                ""
                                )).getMessageContent()
                )
                .time(obj.getTime())
                .build();
    }
}
