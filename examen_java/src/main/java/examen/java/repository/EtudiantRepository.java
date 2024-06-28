package examen.java.repository;

import java.util.ArrayList;
import java.util.List;

import examen.java.core.Repository;
import examen.java.entities.Etudiant;
import examen.java.entities.Pavillon;

public class EtudiantRepository implements Repository <Etudiant>{
    private List<Etudiant> etudiants=new ArrayList<>();

    @Override
    public boolean insert(Etudiant object) {
        return etudiants.add(object);
    }

  

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Etudiant> selectAll() {
        return etudiants;
  }

    @Override
    public Etudiant selectById(int id) {
         for (Etudiant et : etudiants) {
            if(et.getId()==id){
                return et;
            }
         }return null;
    }

    @Override
    public int count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }



    @Override
    public boolean update(int id, int valeur, int value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

   
}
