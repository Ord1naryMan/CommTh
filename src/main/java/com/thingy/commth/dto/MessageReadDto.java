package com.thingy.commth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageReadDto {

    UUID messageId;
    long usersIdFrom;
    long usersIdTo;
    LocalDateTime time;
}
