package com.kevvlvl.demo.camel.service;

import com.kevvlvl.demo.camel.dto.ClientDto;
import com.kevvlvl.demo.camel.model.Client;
import com.kevvlvl.demo.camel.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<Client> getByFirstName(String firstName) {

        log.info("getByFirstName - Fetch Client with firstName {}", firstName);
        List<Client> clients = this.clientRepository.findByFirstName(firstName);

        if(clients != null) {
            log.info("getByFirstName - Found {} clients", clients.size());
        }
        else {
            log.warn("getByFirstName - Found zero clients.");
        }

        return clients;
    }

    @Override
    public Client createClient(ClientDto clientDto) {

        log.info("createClient - clientDto", clientDto);

        Client c = new Client(clientDto.getFirstName(), clientDto.getLastName());
        return this.clientRepository.save(c);
    }
}
