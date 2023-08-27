package com.thingy.commth.mapper;

import com.thingy.commth.db.entity.Message;
import com.thingy.commth.dto.MessageCreateEditDto;
import com.thingy.commth.dto.MessageReadDto;

public class MessageMapper {

    public static MessageReadDto map(Message obj) {
        return MessageReadDto.builder()
                .messageId(obj.getMessageId())
                .usersIdFrom(obj.getUsersIdFrom())
                .usersIdTo(obj.getUsersIdTo())
                .time(obj.getTime())
                .build();
    }

    public static Message map(MessageCreateEditDto obj) {
        return Message.builder()
                .usersIdFrom(obj.getUsersIdFrom())
                .usersIdTo(obj.getUsersIdTo())
                .time(obj.getTime())
                .build();
    }
}
