package com.evaluation.services;

import java.util.List;

import com.evaluation.entities.Medecin;
import com.evaluation.repository.MedecinRepository;

public class MedecinServiceImpl implements MedecinService {
   MedecinRepository medecinRepository;

    public MedecinServiceImpl(MedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository; 
    }
    @Override
    public void create(Medecin medecin) {
       medecinRepository.insert(medecin);
    }

    @Override
    public List<Medecin> findAll() {
        return medecinRepository.selectAll();}

}
