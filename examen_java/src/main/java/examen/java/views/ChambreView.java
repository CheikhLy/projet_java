package examen.java.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import examen.java.core.ViewImpl;
import examen.java.entities.Chambre;
import examen.java.entities.Etudiant;
import examen.java.entities.Pavillon;
import examen.java.enums.EtatChambre;
import examen.java.enums.typeChambre;
import examen.java.repository.PavillonRepository;
import examen.java.service.ChambreService;
import examen.java.service.PavillonService;

public class ChambreView extends ViewImpl<Chambre> {
    private Scanner scanner = new Scanner(System.in);
    private PavillonService pavillonService ;
    private ChambreService chambreService;
   


    public ChambreView(PavillonService pavillonService,ChambreService chambreService) {
        this.pavillonService = pavillonService;
        this.chambreService= chambreService;
    }
    @Override
    public Chambre saisie() {
        Chambre chambre=new Chambre();
        typeChambre typeChambre=saisieTypeChambre();
        EtatChambre etatChambre=saisiEtatChambre();
        System.out.println("saisissez le numero de l'etage");
        chambre.setNumeroEtage(scanner.nextInt());
        System.out.println("saisissez le numero de la chambre");
        chambre.setNumero(scanner.nextInt());
        System.out.println("saisissez l'id du pavillon");
        int id=scanner.nextInt();
        System.out.println(pavillonService.selectById(id));
        Pavillon pavillon= pavillonService.selectById(id);
        chambre.setPavillon(pavillon);
        chambre.setEtat(etatChambre);
        chambre.setTypeChambre(typeChambre);
        pavillon.setChambre(chambre);
        return  chambre;
    }
    public typeChambre saisieTypeChambre() {
        int typeChambreChoice;
        do {
            for (typeChambre typeChambre : typeChambre.values()) {
                System.out.println((typeChambre.ordinal()+1) + "-" + typeChambre.name());
            }
            System.out.println("Entrer le numero du type de chambre");
            typeChambreChoice = scanner.nextInt();

        } while (typeChambreChoice <= 0 || typeChambreChoice > typeChambre.values().length);
        return typeChambre.values()[typeChambreChoice-1];
}
    
    
    private EtatChambre saisiEtatChambre() {
        int etatChoice;
        do {
            System.out.println("Choisissez l'état de la chambre :");
            for (EtatChambre etat : EtatChambre.values()) {
                System.out.println((etat.ordinal() + 1) + "-" + etat.name());
            }
            etatChoice = scanner.nextInt();
            scanner.nextLine(); // Pour consommer le saut de ligne après nextInt()
        } while (etatChoice <= 0 || etatChoice > EtatChambre.values().length);
        return EtatChambre.values()[etatChoice - 1];
    }

    public boolean askToContinue() {
        int choix;
        do {
            System.out.println("1- Oui ");
            System.out.println("2- Non");
            choix = scanner.nextInt();
        } while (choix < 1 || choix > 2);
        return choix == 1;

    }
            public void affectEtu (Etudiant etudiant) {
                scanner.nextLine();
            System.out.printf("voulez-vous affecter l'etudiant ?");
            if (askToContinue()){
                System.out.println("Entrez le numéro de la chambre : ");
                int numeroChambre = scanner.nextInt();   
            Chambre chambre=chambreService.getByNumero(numeroChambre);
                    if (chambre.getEtat() == EtatChambre.activer ){
            etudiant. setChambre(chambre);
            chambre.setEtat(EtatChambre.desactiver);;
            } else {
            System.out.println( "cette chambre est indisponible");
            }

            }
        }
    
}
