package com.thingy.commth.service;

import com.thingy.commth.db.repository.UserRepository;
import com.thingy.commth.dto.UserCreateEditDto;
import com.thingy.commth.dto.UserReadDto;
import com.thingy.commth.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void save(UserCreateEditDto obj) {
        userRepository.save(UserMapper.map(obj));
    }

    public UserReadDto loadUserByUsername(String uName) {
        return userRepository.getUserByUsernameIgnoreCase(uName)
                .map(UserMapper::map)
                .orElseThrow(() -> new UsernameNotFoundException("Failed to retrieve user: " + uName));
    }

    public boolean isUsernameExists(String uName) {
        return userRepository.getUserByUsernameIgnoreCase(uName).isPresent();
    }

    public UserReadDto getUserById(long id) {
        return UserMapper.map(userRepository.getUserById(id));
    }
}
