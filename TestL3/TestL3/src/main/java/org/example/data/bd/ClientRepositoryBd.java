package org.example.data.bd;

import org.example.data.entities.Client;

public interface ClientRepositoryBd extends RepositoryBd<Client>{
    Client selectByPhone(String phone);
}
