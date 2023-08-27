package com.thingy.commth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageCreateEditDto {

    long usersIdFrom;
    long usersIdTo;
    LocalDateTime time;
}
