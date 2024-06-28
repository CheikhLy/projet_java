package examen.java.repository;

import java.util.ArrayList;
import java.util.List;

import examen.java.core.Repository;
import examen.java.entities.Chambre;

public class ChambreRepository implements Repository<Chambre>{
    private List<Chambre> chambres=new ArrayList<>();

    @Override
    public boolean insert(Chambre object) {
        return chambres.add(object);
    }



    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Chambre> selectAll() {
        return chambres;
    }

    @Override
    public Chambre selectById(int id) {
      for (Chambre chambre : chambres) {
          if (chambre.getId()==id){
            return chambre;
          }
      }return null;
        
    }

    @Override
    public int count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }
    public Chambre getBy(int value){
        for (Chambre chambre : chambres) {
            if (chambre.getNumero()==value){
                return chambre;
            }
            
        }
        return null;
    }



    @Override
    public boolean update(int id, int valeur, int value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


    
}
