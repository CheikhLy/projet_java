package org.example.data.core.config;

import java.util.List;

public interface Repository<T> {
    void insert(T object);
    List<T> selectAll();

}
