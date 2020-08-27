package com.kevvlvl.demo.camel.repository;

import com.kevvlvl.demo.camel.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

}