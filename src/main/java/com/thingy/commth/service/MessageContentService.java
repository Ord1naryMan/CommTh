package com.thingy.commth.service;

import com.thingy.commth.db.entity.MessageContent;
import com.thingy.commth.db.repository.MessageContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageContentService {

    private final MessageContentRepository messageContentRepository;

    public Optional<MessageContent> findById(UUID id) {
        return messageContentRepository.findById(id);
    }

    public void save(MessageContent content) {
        messageContentRepository.save(content);
    }
}
