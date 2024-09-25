package com.evaluation.entities;

import java.util.List;

import lombok.Data;

@Data
public class Medecin {
    private int id;
    private String nom;
    private String prenom;
    List<Rv> rv;
}
