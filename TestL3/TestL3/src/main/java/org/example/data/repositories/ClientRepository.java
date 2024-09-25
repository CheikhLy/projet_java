package org.example.data.repositories;

import org.example.data.core.config.Repository;
import org.example.data.entities.Client;

import java.util.ArrayList;
import java.util.List;

public interface ClientRepository extends Repository<Client> {


    @Override
    default void insert(Client object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    default List<Client> selectAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectAll'");
    }

    public Client selectByPhone(String phone);
}