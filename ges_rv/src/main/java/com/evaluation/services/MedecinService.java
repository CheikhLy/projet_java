package com.evaluation.services;

import java.util.List;

import com.evaluation.entities.Medecin;
import com.evaluation.repository.MedecinRepository;

public interface MedecinService {
 

    public void create(Medecin medecin);

    public List<Medecin> findAll();
}
