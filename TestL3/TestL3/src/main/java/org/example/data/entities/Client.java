package org.example.data.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Client {
    private int id;
    private String surname;
    private String phone;
    private String address;

    private User user;
}
