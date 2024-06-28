package examen.java.core;

import java.util.List;

public interface Repository <T>{
        boolean insert (T object);
        boolean update (int id,int valeur,int value);
        boolean delete (int id);
        List<T> selectAll();
        T selectById(int id);
        int count();
}
