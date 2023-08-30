package com.thingy.commth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
public class MessageShowDto implements Comparable<MessageShowDto> {

    String text;
    String usernameTo;
    LocalDateTime time;

    @Override
    public int compareTo(MessageShowDto messageShowDto) {
        return time.compareTo(messageShowDto.time);
    }
}