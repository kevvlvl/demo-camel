package com.kevvlvl.demo.camel.repository;

import com.kevvlvl.demo.camel.model.ClientTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientTaskRepository extends JpaRepository<ClientTask, Integer> {

    @Query("SELECT ct FROM ClientTask ct " +
            "JOIN FETCH ct.client c " +
            "WHERE ct.client.clientId = ?1")
    List<ClientTask> findListByClientId(int clientId);
}
