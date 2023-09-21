package com.thingy.commth.service;

import com.thingy.commth.db.repository.UserRepository;
import com.thingy.commth.dto.UserCreateEditDto;
import com.thingy.commth.dto.UserReadDto;
import com.thingy.commth.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void save(UserCreateEditDto obj) {
        userRepository.save(UserMapper.map(obj));
    }

    public UserReadDto loadUserByUsername(String uName) {
        return userRepository.getUserByUsernameIgnoreCase(uName)
                .map(UserMapper::map)
                .orElseThrow(() -> {
                    log.info("load user by username returned null");
                    return new ResponseStatusException(HttpStatus.NOT_FOUND);
                });
    }

    public boolean isUsernameExists(String uName) {
        return userRepository.getUserByUsernameIgnoreCase(uName).isPresent();
    }

    public UserReadDto getUserById(long id) {
        return UserMapper.map(userRepository.getUserById(id));
    }
}
