package org.example.data.repositories;

import org.example.data.core.config.RepositoryImpl;
import org.example.data.entities.Client;

public class ClientRepositoryImpl extends RepositoryImpl<Client> implements ClientRepository {

    @Override
    public Client selectByPhone(String phone) {
        return list.stream()
                   .filter(client -> client.getPhone().equals(phone))
                   .findFirst()
                   .orElse(null); 
                }
}
