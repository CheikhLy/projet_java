package examen.java.service;

import java.util.List;

import examen.java.core.Service;
import examen.java.entities.Etudiant;
import examen.java.repository.EtudiantRepository;

public class EtudiantService implements Service<Etudiant>{
    private EtudiantRepository etudiantRepository=new EtudiantRepository();
    @Override
    public boolean save(Etudiant object) {
        return etudiantRepository.insert(object);
    }

    @Override
    public List<Etudiant> show() {
        return etudiantRepository.selectAll();
    }

    @Override
    public Etudiant getBy(int value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBy'");
    }

    @Override
    public int count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public Etudiant selectById(int id) {
        return etudiantRepository.selectById(id);
    }
    
}
