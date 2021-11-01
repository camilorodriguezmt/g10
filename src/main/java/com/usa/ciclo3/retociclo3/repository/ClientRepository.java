package com.usa.ciclo3.retociclo3.repository;

import com.usa.ciclo3.retociclo3.crudrepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.usa.ciclo3.retociclo3.model.Client;


import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    public ClientCrudRepository clientCrudRepository;

    public List<Client> getAll() {
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int id) {
        return clientCrudRepository.findById(id);
    }

    public Client save(Client client) {
        return clientCrudRepository.save(client);
    }

    public void delete(Client client){
        clientCrudRepository.delete(client);
    }

    }

