package com.thingy.commth.mapper;

import com.thingy.commth.db.entity.User;
import com.thingy.commth.dto.UserCreateEditDto;
import com.thingy.commth.dto.UserReadDto;

public class UserMapper {

    public static UserReadDto map(User obj) {
        return UserReadDto.builder()
                .id(obj.getId())
                .username(obj.getUsername())
                .mail(obj.getMail())
                .build();
    }

    public static User map(UserCreateEditDto obj) {
        return User.builder()
                .username(obj.getUsername())
                .mail(obj.getMail())
                .build();
    }

}
