package org.example.data.services;

import org.example.data.bd.ClientRepositoryBd;
import org.example.data.entities.Client;
import org.example.data.repositories.ClientRepository;

import java.util.ArrayList;
import java.util.List;

public class ClientServiceImpl implements ClientService {
    ClientRepository clientRepository;
    //ClientRepositoryBd clientRepositoryBd;

    public ClientServiceImpl(ClientRepository clientRepository
    // ClientRepositoryBd clientRepositoryBd
    ) {
        this.clientRepository = clientRepository;
        // this.clientRepositoryBd=clientRepositoryBd;
    }

    @Override
    public void create(Client client) {
        clientRepository.insert(client);
        ;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.selectAll();
    }

    public Client search(String phone) {
        return clientRepository.selectByPhone(phone);

    }

}
