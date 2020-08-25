package com.kevvlvl.demo.camel.service;

import com.kevvlvl.demo.camel.dto.ClientDto;
import com.kevvlvl.demo.camel.model.Client;

import java.util.List;

public interface ClientService {

    public Client getByClientId(int id);
    public List<Client> getByFirstName(String firstName);
    public Client createClient(ClientDto clientDto);
}
