package org.example.data.services;

import java.util.List;

import org.example.data.entities.Client;

public interface ClientService {
    public void create(Client client);

    public List<Client> findAll();

    Client search(String phone);
}
