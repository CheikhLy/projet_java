package examen.java.core;

import java.util.List;

public interface Service<T> {
    boolean save(T object);
    List<T> show();
    T getBy(int value);
    int count();
    T selectById(int id);
}
