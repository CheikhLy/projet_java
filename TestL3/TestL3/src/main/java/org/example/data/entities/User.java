package org.example.data.entities;

import javax.management.relation.Role;

import org.example.data.enums.Etat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class User {
    private int id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private Role role;
    private Client client;
    private Etat etat;
    public boolean isActive() {
        return etat == Etat.activer;
    }
}
