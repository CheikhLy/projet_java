package examen.java.core;

import java.util.List;

public interface View<T> {
    T saisie();
    void affiche (List<T> datas);
}
