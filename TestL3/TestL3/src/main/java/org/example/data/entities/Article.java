package org.example.data.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Article {
    private String name;
    private int qteStock;

    public boolean isAvailable() {
        return qteStock > 0;
    }
}
