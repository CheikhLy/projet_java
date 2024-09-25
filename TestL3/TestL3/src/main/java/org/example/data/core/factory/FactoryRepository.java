package org.example.data.core.factory;

import org.example.data.bd.ClientRepositoryBd;
import org.example.data.repositories.ClientRepository;
import org.example.data.repositories.UserRepository;

public class FactoryRepository {
    private  ClientRepository clientRepository=null;
    private  UserRepository userRepository=null;
    public  ClientRepository getInstanceclientRepository(){
        if (clientRepository==null){
            clientRepository=new ClientRepositoryBd();
        }
        return clientRepository;
    }

public  UserRepository getInstanceUserRepository()
{
    if (userRepository==null){
        userRepository=new  UserRepositoryBd();
    }
    return userRepository;
}
}
