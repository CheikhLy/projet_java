package com.evaluation.core;

import java.util.List;

public interface Repository<T> {
    void insert(T object);
    List<T> selectAll();  
}
