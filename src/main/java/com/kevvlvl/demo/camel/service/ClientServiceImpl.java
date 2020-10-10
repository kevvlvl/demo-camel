package com.kevvlvl.demo.camel.service;

import com.kevvlvl.demo.camel.dto.ClientDto;
import com.kevvlvl.demo.camel.dto.ClientTaskDto;
import com.kevvlvl.demo.camel.model.Client;
import com.kevvlvl.demo.camel.model.ClientTask;
import com.kevvlvl.demo.camel.repository.ClientRepository;
import com.kevvlvl.demo.camel.repository.ClientTaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientTaskRepository clientTaskRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ClientTaskRepository clientTaskRepository) {
        this.clientRepository = clientRepository;
        this.clientTaskRepository = clientTaskRepository;
    }

    @Override
    public ClientDto getByClientId(int id) {

        ClientDto dto = null;
        log.info("getByClientId - Fetch Client with Id {}", id);
        Optional<Client> client = this.clientRepository.findById(id);

        if(client.isPresent()) {
            log.info("getByClientId - Found client");

            Client c = client.get();

            dto = new ClientDto();
            dto.setClientId(c.getClientId());
            dto.setFirstName(c.getFirstName());
            dto.setLastName(c.getLastName());
        }
        else {
            log.info("getByClientId - Client not found");
        }

        return dto;
    }

    @Override
    public ClientDto createClient(ClientDto clientDto) {

        log.info("createClient - clientDto = {}", clientDto);

        Client c = this.clientRepository.save(new Client(clientDto.getFirstName(), clientDto.getLastName()));
        clientDto.setClientId(c.getClientId());

        log.info("createClient - Created");

        return clientDto;
    }

    @Override
    public ClientDto updateClient(int id, ClientDto clientDto) {

        log.info("updateClient - client ID = {}, clientDto = {}", id, clientDto);

        Client c = new Client(clientDto.getFirstName(), clientDto.getLastName());
        c.setClientId(id);
        c = this.clientRepository.save(c);

        log.info("updateClient - Updated the client");

        return clientDto;
    }

    public ClientTaskDto createClientTask(ClientTaskDto clientTaskDto) {

        log.info("createClientTask - clientTaskDto = {}", clientTaskDto);

        Optional<Client> client = clientRepository.findById(clientTaskDto.getClientId());

        if(client.isPresent()) {
            ClientTask ct = new ClientTask();
            ct.setTaskDescription(clientTaskDto.getTaskDescription());
            ct.setClient(client.get());

            ct = clientTaskRepository.save(ct);
            clientTaskDto.setTaskId(ct.getTaskId());
        }

        log.info("createClientTask - Created");

        return clientTaskDto;
    }

    @Override
    public List<ClientTaskDto> getClientTasks(int clientId) {
        List<ClientTaskDto> dtos = null;

        log.info("getClientTasks - clientId = {}", clientId);

        List<ClientTask> ctList = clientTaskRepository.findListByClientId(clientId);

        if(CollectionUtils.isNotEmpty(ctList)) {
            log.info("createClientTask - Got list Size = {}", ctList.size());

            dtos = new ArrayList<>();
            for(ClientTask ct : ctList) {
                dtos.add(new ClientTaskDto(ct.getTaskId(), ct.getTaskDescription(), ct.getClient().getClientId()));
            }
        }
        else {
            log.info("Tasks or clientId not found!");
        }

        return dtos;
    }


}
