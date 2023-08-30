package com.thingy.commth.db.repository;

import com.thingy.commth.db.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {

    List<Message> getMessagesByUsersIdFromAndUsersIdToAndTimeBetween(
            long usersIdFrom, long usersIdTo, LocalDateTime after, LocalDateTime before
    );
}
