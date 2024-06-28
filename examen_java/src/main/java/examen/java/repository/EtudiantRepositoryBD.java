package examen.java.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import examen.java.core.Repository;
import examen.java.entities.Etudiant;
import examen.java.entities.Pavillon;

public class EtudiantRepositoryBD implements Repository <Etudiant>{
    @Override
    public boolean insert(Etudiant object) {
      
        int nbre = 0;
        Connection conn = null;
        try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/javasql","root","");
         Statement statement=conn.createStatement();
         nbre= statement.executeUpdate(String.format("INSERT INTO `etudiant` (`id`, `nom`, `prenom`, `mail`, `telephone`, `idChambre`, `dateNaiss`, `idTypeEleve`)VALUES('%d', '%s','%s','%s','%s''%d','%s','%s')",object.getNom(),object.getPrenom()));
         System.out.println("Connexion Bd etablie");
        } catch (ClassNotFoundException e) {
           System.out.println("Erreur de chargement du Driver");
        } catch (SQLException e) {
           System.out.println("Erreur de Connexion a votre BD");
       }
           return nbre==0;
    }

    @Override
    public boolean update(int id,int valeur,int value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
      public List<Etudiant> selectAll() {
        List<Etudiant> etudiants = new ArrayList<>();
        Connection conn = null;
       try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/javasql","root","");
        Statement statement=conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM etudiant");
        while (rs.next()) {
            Etudiant etudiant = new Etudiant();
            etudiant.setId(rs.getInt("id"));
            etudiant.setNom(rs.getString("nom"));
            etudiant.setPrenom(rs.getString("prenom"));
            etudiant.setDateNaiss(rs.getDate("dateNaiss"));
            etudiant.setMail(rs.getString("mail"));
            etudiant.setTelephone(rs.getString("telephone"));
            etudiants.add(etudiant);
        }
        System.out.println("Connexion Bd etablie");
       } catch (ClassNotFoundException e) {
          System.out.println("Erreur de chargement du Driver");
       } catch (SQLException e) {
          System.out.println("Erreur de Connexion a votre BD");
      }
          return etudiants;
    }

    @Override
    public Etudiant selectById(int id) {
        Connection conn = null;
        try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/javasql","root","");
         Statement statement=conn.createStatement();
         ResultSet rs = statement.executeQuery(String.format(" SELECT * FROM pavillon WHERE id = '%d'",id));
         while (rs.next()) {
            Etudiant etudiant = new Etudiant();
            etudiant.setId(rs.getInt("id"));
            return etudiant;
         }
         System.out.println("Connexion Bd etablie");
        } catch (ClassNotFoundException e) {
           System.out.println("Erreur de chargement du Driver");
        } catch (SQLException e) {
           System.out.println("Erreur de Connexion a votre BD");
        } 
        return null;
    }

    @Override
    public int count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }
}
