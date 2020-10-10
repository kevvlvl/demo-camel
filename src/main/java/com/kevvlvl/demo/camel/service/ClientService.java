package com.kevvlvl.demo.camel.service;

import com.kevvlvl.demo.camel.dto.ClientDto;
import com.kevvlvl.demo.camel.dto.ClientTaskDto;

import java.util.List;

public interface ClientService {

    ClientDto getByClientId(int id);
    ClientDto createClient(ClientDto clientDto);
    ClientDto updateClient(int id, ClientDto clientDto);
    ClientTaskDto createClientTask(ClientTaskDto clientTaskDto);
    List<ClientTaskDto> getClientTasks(int clientId);
}
