package examen.java.entities;

import examen.java.enums.EtatChambre;
import examen.java.enums.typeChambre;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Chambre {
    private int id;
    private   int numero;
    private int numeroEtage;
    private typeChambre typeChambre;
    private Pavillon pavillon;
    private EtatChambre etat;
    private static int nmbre;
    private Etudiant etudiant;
    
    public Chambre(examen.java.enums.typeChambre typeChambre, EtatChambre etat) {
        this.typeChambre = typeChambre;
        this.etat = etat;
        id=++nmbre;
    }
    public Chambre() {
        id=++nmbre;
    }


    
}
