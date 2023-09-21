package com.thingy.commth.db.repository;

import com.thingy.commth.db.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {

    @Query("select m from Message m " +
            "where ((m.usersIdFrom = :usersIdFrom and m.usersIdTo = :usersIdTo) or " +
            "      (m.usersIdFrom = :usersIdTo and m.usersIdTo = :usersIdFrom)) and " +
            "    m.time between :after and :before")
    List<Message> getMessages(
            long usersIdFrom, long usersIdTo, LocalDateTime after, LocalDateTime before
    );
}
