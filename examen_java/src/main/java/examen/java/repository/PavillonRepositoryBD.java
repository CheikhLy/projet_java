package examen.java.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import examen.java.core.Repository;
import examen.java.entities.Pavillon;

public class PavillonRepositoryBD implements Repository<Pavillon>{
    

    @Override
    public boolean insert(Pavillon object) {
         int nbre = 0;
       Connection conn = null;
       try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/javasql","root","");
        Statement statement=conn.createStatement();
        nbre= statement.executeUpdate(String.format("INSERT INTO `pavillon` (`numero`, `NmbrEtage`)VALUES('%d', '%d')",object.getNumero(),object.getNmbrEtage()));
        System.out.println("Connexion Bd etablie");
       } catch (ClassNotFoundException e) {
          System.out.println("Erreur de chargement du Driver");
       } catch (SQLException e) {
          System.out.println("Erreur de Connexion a votre BD");
      }
          return nbre==0;
    }


    
    
    

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

   

    @Override
    public boolean update(int id,int valeur, int value) {
        int nbre = 0;
        Connection conn = null;
        try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/javasql","root","");
         Statement statement=conn.createStatement();
         nbre = statement.executeUpdate(String.format("UPDATE `pavillon` SET `numero`= '%d', `NmbrEtage`= '%d' WHERE id = '%d'", value, valeur, id));
         System.out.println("Connexion Bd etablie");
        } catch (ClassNotFoundException e) {
           System.out.println("Erreur de chargement du Driver");
        } catch (SQLException e) {
           System.out.println("Erreur de Connexion a votre BD");
       }
       return nbre==0;
           
    }






    @Override
    public List<Pavillon> selectAll() {
        List<Pavillon> pavillons = new ArrayList<>();
        Connection conn = null;
       try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/javasql","root","");
        Statement statement=conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM pavillon");
        while (rs.next()) {
            Pavillon pavillon = new Pavillon();
            pavillon.setId(rs.getInt("id"));
            pavillon.setNumero(rs.getInt("numero"));
            pavillon.setNmbrEtage(rs.getInt("NmbrEtage"));
            pavillons.add(pavillon);
        }
        System.out.println("Connexion Bd etablie");
       } catch (ClassNotFoundException e) {
          System.out.println("Erreur de chargement du Driver");
       } catch (SQLException e) {
          System.out.println("Erreur de Connexion a votre BD");
      }
          return pavillons;
    }






    @Override
       public  Pavillon selectById(int id) {
        Connection conn = null;
        try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/javasql","root","");
         Statement statement=conn.createStatement();
         ResultSet rs = statement.executeQuery(String.format(" SELECT * FROM pavillon WHERE id = '%d'",id));
         while (rs.next()) {
            Pavillon pavillon = new Pavillon();
            pavillon.setId(rs.getInt("id"));
            return pavillon;
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
