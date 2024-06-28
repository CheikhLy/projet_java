package examen.java;

import java.util.Random;
import java.util.Scanner;

import examen.java.core.Repository;
import examen.java.entities.Chambre;
import examen.java.entities.Etudiant;
import examen.java.entities.Pavillon;
import examen.java.repository.ChambreRepository;
import examen.java.repository.EtudiantRepository;
import examen.java.repository.PavillonRepository;
import examen.java.repository.PavillonRepository;
import examen.java.service.ChambreService;
import examen.java.service.EtudiantService;
import examen.java.service.PavillonService;
import examen.java.views.ChambreView;
import examen.java.views.EtudiantView;
import examen.java.views.PavillonView;

public class Main {
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) { 
        ChambreService chambreService=new ChambreService();
        PavillonView pavillonView=new PavillonView();
        Repository <Etudiant> etudiantRepository =new EtudiantRepository();
        Repository <Chambre> chambreRepository =new ChambreRepository();
        Repository <Pavillon> pavillonRepository =new PavillonRepository();
        PavillonService pavillonService=new PavillonService(pavillonRepository);
        ChambreView chambreView=new ChambreView(pavillonService,chambreService);
        EtudiantView etudiantView=new EtudiantView();
        EtudiantService etudiantService=new EtudiantService();
        


        int choix;
        do {

            choix=menu();
            switch(choix){
                case 1:
                pavillonService.save(pavillonView.saisie());
                break;
                case 2:
                pavillonView.affiche(pavillonService.show());
                break;
                case 3:
                chambreService.save(chambreView.saisie());
                break;

                case 4:
                chambreView.affiche(chambreService.show());
                break; 

                case 5:
                chambreView.affiche(pavillonService.selectById(pavillonView.callId()).getListeChambre());
                break;

                case 6:
                pavillonService.modify(pavillonView.callId(),pavillonView.saisieInt("entrer le nombre d'etage"),pavillonView.saisieInt("entrer le numero du pavillon"));
                break;
                case 7:
                etudiantService.save(etudiantView.saisie());
                break;
                case 8:
                etudiantView.affiche(etudiantService.show());
                break;
                case 9:
                Etudiant etudiant=etudiantRepository.selectById(etudiantView.callId());
               chambreView.affectEtu(etudiant);
                break;
            }
        }while(choix !=11);
        
    }
    public static int menu(){
        System.out.println("1-créer un pavillon");
        System.out.println("2-lister les pavillons");
        System.out.println("3-créer une chambre");
        System.out.println("4-lister les chambres");
        System.out.println("5-lister les chambres d'un pavillon");
        System.out.println("6-modifier un pavillon");
        System.out.println("7-créer un etudiant");
        System.out.println("8-lister les etudiants");
        System.out.println("9-affecter une chmbre a un etudiant");
        System.out.println("10-Quitter");


        return scanner.nextInt();
    }
    

}