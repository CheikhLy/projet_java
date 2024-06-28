package examen.java.repository;

import java.util.ArrayList;
import java.util.List;

import examen.java.core.Repository;
import examen.java.entities.Chambre;
import examen.java.entities.Pavillon;

public class PavillonRepository implements Repository<Pavillon> {
      private List<Pavillon> pavillons=new ArrayList<>();

    @Override
    public boolean insert(Pavillon object) {
        return pavillons.add(object);
    }

    @Override
    public boolean update(int id,int NmbrEtage,int numero) { 
        for (Pavillon pavillon2 : pavillons) {
            if (pavillon2.getId()==id){
            if ((pavillon2.getNumero()==numero)) {
                pavillon2.setNmbrEtage(NmbrEtage);
                return false;      
            }
            }
        }  return true;       
                        
    }
    
    
    

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Pavillon> selectAll() {
        return pavillons;
    }

    @Override
    public Pavillon selectById(int id) {
         for (Pavillon pavillon : pavillons) {
            if(pavillon.getId()==id){
                return pavillon;
            }
         }return null;
    }

    @Override
    public int count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

   

    
}
