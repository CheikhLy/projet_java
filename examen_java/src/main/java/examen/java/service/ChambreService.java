package examen.java.service;

import java.util.ArrayList;
import java.util.List;

import examen.java.core.Service;
import examen.java.entities.Chambre;
import examen.java.repository.ChambreRepository;

public class ChambreService implements Service<Chambre> {
  private  ChambreRepository chambreRepository=new ChambreRepository();
   private List<Chambre> chambres=new ArrayList<>();



    @Override
    public boolean save(Chambre object) {
       return chambreRepository.insert(object);
    }

    @Override
    public List<Chambre> show() {
        return chambreRepository.selectAll();
    }

    @Override
    public Chambre getBy(int value) {
    return chambreRepository.getBy(value);
    }

    @Override
    public int count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public Chambre selectById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectById'");
    }
    public Chambre getByNumero(int numeroChambre) {
        for (Chambre chambre : chambres) {
            if (chambre.getNumero() == numeroChambre) {
                return chambre; 
            }
        }
        return null; 
    }
    
}
