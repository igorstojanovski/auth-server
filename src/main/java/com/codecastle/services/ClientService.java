package com.codecastle.services;

import com.codecastle.models.Client;
import com.codecastle.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client getClient(String clientId) {

        return clientRepository.findByClientId(clientId);
    }

    public void create(Client client) {
        clientRepository.save(client);
    }
}
