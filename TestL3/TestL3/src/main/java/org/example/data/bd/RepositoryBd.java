package org.example.data.bd;

import java.util.List;

public interface RepositoryBd<T> {
    void insert(T object);          // Insérer un objet dans la base de données
    List<T> selectAll();            // Récupérer tous les objets de la base de données
    T selectById(int id);           // Récupérer un objet par son ID
    void update(T object);          // Mettre à jour un objet dans la base de données
    void delete(int id);            // Supprimer un objet par son ID
}
