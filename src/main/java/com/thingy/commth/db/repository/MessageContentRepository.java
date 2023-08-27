package com.thingy.commth.db.repository;

import com.thingy.commth.db.entity.MessageContent;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.Optional;
import java.util.UUID;

public interface MessageContentRepository extends CassandraRepository<MessageContent, UUID> {

    Optional<MessageContent> findById(UUID id);
}
