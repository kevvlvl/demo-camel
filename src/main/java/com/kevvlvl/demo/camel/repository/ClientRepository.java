package com.kevvlvl.demo.camel.repository;

import com.kevvlvl.demo.camel.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    // FIXME: implement query of client and client tasks in 1 JPQL
    // https://stackoverflow.com/questions/30088649/multiple-join-fetch-in-one-jpql-query
}