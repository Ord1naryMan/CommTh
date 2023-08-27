package com.thingy.commth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserReadDto {

    long id;
    String username;
    String mail;
    int chatQuantity;
}
