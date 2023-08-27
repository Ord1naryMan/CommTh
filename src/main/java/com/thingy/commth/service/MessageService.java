package com.thingy.commth.service;

import com.thingy.commth.db.repository.MessageRepository;
import com.thingy.commth.dto.MessageCreateEditDto;
import com.thingy.commth.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MessageService {

    private final MessageRepository messageRepository;

    @Transactional
    public UUID save(MessageCreateEditDto obj) {
        return messageRepository.save(MessageMapper.map(obj)).getMessageId();
    }
}
