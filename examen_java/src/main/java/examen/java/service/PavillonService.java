package examen.java.service;
import java.util.List;

import examen.java.core.Repository;
import examen.java.core.Service;
import examen.java.entities.Chambre;
import examen.java.entities.Pavillon;
import examen.java.repository.PavillonRepository;

public class PavillonService implements Service<Pavillon> {
    private Repository <Pavillon> pavillonRepository;
    public PavillonService(Repository <Pavillon> pavillonRepository) {
        this.pavillonRepository = pavillonRepository;
    }

    @Override
    public boolean save(Pavillon object) {
        return pavillonRepository.insert(object);
    }

    @Override
    public List<Pavillon> show() {
        return pavillonRepository.selectAll();
    }

    @Override
    public Pavillon getBy(int value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBy'");
    }

    @Override
    public int count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public Pavillon selectById(int id) {
       return pavillonRepository.selectById(id);
    }
   public boolean modify(int id,int valeur,int value){
    return pavillonRepository.update(id,valeur,value);
   }
    
}
