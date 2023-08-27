package com.thingy.commth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class SendMessageDto {

    String usernameTo;
    String messageContent;
}
