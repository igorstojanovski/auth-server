package com.codecastle.repositories;


import com.codecastle.models.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findByClientId(String clientId);
}
