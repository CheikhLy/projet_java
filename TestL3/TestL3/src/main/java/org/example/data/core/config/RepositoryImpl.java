package org.example.data.core.config;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ObjDoubleConsumer;

public class RepositoryImpl<T> implements Repository<T> {
    protected final List<T> list = new ArrayList<>();

    @Override
    public void insert(T object) {
        list.add(object);
    }

    @Override
    public List<T> selectAll() {
        return list;
    }

}
