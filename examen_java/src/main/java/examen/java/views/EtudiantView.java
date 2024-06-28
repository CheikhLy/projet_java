package examen.java.views;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import examen.java.core.View;
import examen.java.core.ViewImpl;
import examen.java.entities.Etudiant;
import examen.java.enums.typeEleve;

public class EtudiantView extends ViewImpl<Etudiant> {
    private Scanner scanner=new Scanner(System.in);
   
    @Override
    public Etudiant saisie() {
        Etudiant etudiant =new Etudiant();
        System.out.println("entrer le nom de l'etudiant");
        etudiant.setNom(scanner.nextLine());
        System.out.println("entrer le prenom de l'etudiant");
        etudiant.setPrenom(scanner.nextLine());
        System.out.println("entrer le mail de l'etudiant");
        etudiant.setMail(scanner.nextLine());
        System.out.println("entrer le telephone de l'etudiant");
        etudiant.setTelephone(scanner.nextLine());
        typeEleve typeEleve=saisiTypeEleve();
        scanner.nextLine();
        Date dateNaiss=saisirDateNaissance();
        return etudiant;


    }
    private typeEleve saisiTypeEleve() {
        int EleveChoice;
        do {
            for (typeEleve type : typeEleve.values()) {
                System.out.println((type.ordinal() + 1) + "-" + type.name());
            }
            System.out.println("Veuillez sélectionner le type de l'eleve : ");
            EleveChoice = scanner.nextInt();
        } while (EleveChoice <= 0 || EleveChoice > typeEleve.values().length);
        return typeEleve.values()[EleveChoice - 1];
    }
       private Date saisirDateNaissance() {
        System.out.println("Entrer la date de naissance de l'étudiant (format JJ/MM/AAAA) : ");
        String dateNaissanceStr = scanner.nextLine();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateNaissance = null;

        try {
            dateNaissance = formatter.parse(dateNaissanceStr);
        } catch (ParseException e) {
            System.out.println("Format de date incorrect. Assurez-vous d'utiliser le format JJ/MM/AAAA.");
            // Vous pouvez gérer l'erreur de parsing ici selon vos besoins
        }

        return dateNaissance;
    }

    public int  callId(){
        System.out.println("entrer l'id");
        int id=scanner.nextInt();
        return id;   
        }
    
    
}
