package com.kevvlvl.demo.camel.service;

import com.kevvlvl.demo.camel.dto.ClientDto;
import com.kevvlvl.demo.camel.model.Client;

import java.util.List;

public interface ClientService {

    public Client getByClientId(int id);
    public Client createClient(ClientDto clientDto);
    public Client updateClient(int id, ClientDto clientDto);
}
