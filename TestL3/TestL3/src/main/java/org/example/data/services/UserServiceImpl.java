package org.example.data.services;

import java.util.List;

import org.example.data.entities.Client;
import org.example.data.entities.User;
import org.example.data.enums.Etat;
import org.example.data.enums.Role;
import org.example.data.repositories.UserRepository;

public class UserServiceImpl  {
    private final UserRepository userRepository = new UserRepository();
     public void create(User user) {
        userRepository.insert(user);
    }
      public void disableUser(User user) {
        user.setEtat(Etat.desactiver);  
    }

    public void enableUser(User user) {
        user.setEtat(Etat.activer);  
    }
 
    public List<User> findAllActiveUsers() {
        return userRepository.findAll().stream()
                .filter(User::isActive)
                .toList();
    }

    public List<User> findUsersByRole(Role role) {
        return userRepository.findAll().stream()
                .filter(user -> user.getRole().equals(role))
                .toList();
    }


 
}