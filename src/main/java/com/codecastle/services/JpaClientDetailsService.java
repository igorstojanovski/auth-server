package com.codecastle.services;

import com.codecastle.models.Client;
import com.codecastle.models.ClientDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class JpaClientDetailsService implements ClientDetailsService {

    @Autowired
    ClientService clientService;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        Client client = clientService.getClient(clientId);
        return new ClientDetailsImpl(client);
    }
}
