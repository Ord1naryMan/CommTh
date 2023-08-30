package com.thingy.commth.service;

import com.thingy.commth.db.repository.MessageRepository;
import com.thingy.commth.dto.MessageCreateEditDto;
import com.thingy.commth.dto.MessageShowDto;
import com.thingy.commth.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper mapper;

    @Transactional
    public UUID save(MessageCreateEditDto obj) {
        return messageRepository.save(MessageMapper.map(obj)).getMessageId();
    }

    public List<MessageShowDto> getMessagesByUsersIdFromAndToAndTimeBetween(
            long usersIdFrom, long usersIdTo, LocalDateTime after, LocalDateTime before
    ) {
        return messageRepository.getMessagesByUsersIdFromAndUsersIdToAndTimeBetween(
                usersIdFrom, usersIdTo, after, before
        )
                .stream()
                .map(mapper::mapToShow)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
