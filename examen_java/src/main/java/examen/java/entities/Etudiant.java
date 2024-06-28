package examen.java.entities;

import java.util.Date;

import lombok.Data;

@Data
public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private String telephone;
    private Date dateNaiss;
    private static int nbr;
    private Chambre chambre;

    public Etudiant() {
        id=++nbr;
    }

}
