package com.kevvlvl.demo.camel.service;

import com.kevvlvl.demo.camel.dto.ClientDto;
import com.kevvlvl.demo.camel.model.Client;
import com.kevvlvl.demo.camel.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getByClientId(int id) {

        log.info("getByClientId - Fetch Client with Id {}", id);
        Optional<Client> client = this.clientRepository.findById(id);

        if(client.isPresent()) {
            log.info("getByClientId - Found client");
            return client.get();
        }
        else {
            log.info("getByClientId - Client not found");
            return null;
        }
    }

    @Override
    public Client createClient(ClientDto clientDto) {

        log.info("createClient - clientDto = {}", clientDto);

        Client c = new Client(clientDto.getFirstName(), clientDto.getLastName());
        return this.clientRepository.save(c);
    }

    @Override
    public Client updateClient(int id, ClientDto clientDto) {

        log.info("updateClient - client ID = {}, clientDto = {}", id, clientDto);

        Client c = new Client(clientDto.getFirstName(), clientDto.getLastName());
        c.setClientId(id);

        return this.clientRepository.save(c);
    }
}
