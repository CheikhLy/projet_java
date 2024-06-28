package examen.java.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import examen.java.core.Repository;
import examen.java.entities.Chambre;
import examen.java.entities.Etudiant;
import examen.java.entities.Pavillon;

public class ChambreRepositoryBD implements Repository <Chambre> {

   
    @Override
   public boolean insert(Chambre object) {
         int nbre = 0;
       Connection conn = null;
       try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/javasql","root","");
        Statement statement=conn.createStatement();
        nbre= statement.executeUpdate(String.format("INSERT INTO `chambre` (`id`, `numero`, `numeroEtage`, `idPavillon`, `idEtat`, `idEtudiant`, `idTypeChambre)VALUES('%d', '%d','%d','%d','%d','%d','%d')",object.getNumero(),object.getNumeroEtage()));
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
    public List<Chambre> selectAll() {
        List<Chambre> chambres = new ArrayList<>();
        Connection conn = null;
       try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/javasql","root","");
        Statement statement=conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM chambre");
        while (rs.next()) {
            Chambre chambre = new Chambre();
            chambre.setId(rs.getInt("id"));
            chambre.setNumero(rs.getInt("numero"));
            chambre.setNumeroEtage(rs.getInt("NmbrEtage"));
            chambres.add(chambre);
        }
        System.out.println("Connexion Bd etablie");
       } catch (ClassNotFoundException e) {
          System.out.println("Erreur de chargement du Driver");
       } catch (SQLException e) {
          System.out.println("Erreur de Connexion a votre BD");
      }
          return chambres;
    }

    @Override
public Chambre selectById(int id) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    Chambre chambre = null;
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasql", "root", "");

        String query = "SELECT * FROM chambre WHERE id = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, id);
        
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            chambre = new Chambre();
            chambre.setId(rs.getInt("id"));
            chambre.setNumero(rs.getInt("numero"));
            chambre.setNumeroEtage(rs.getInt("NmbrEtage"));
        }
        
        System.out.println("Connexion Bd établie");
    } catch (ClassNotFoundException e) {
        System.out.println("Erreur de chargement du Driver");
    } catch (SQLException e) {
        System.out.println("Erreur de Connexion à votre BD");
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    return chambre;
}


    @Override
    public int count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }
    public Chambre getBy(int value) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Chambre chambre = null;
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasql", "root", "");
    
            String query = "SELECT * FROM chambre WHERE numero = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, value);
    
            ResultSet rs = pstmt.executeQuery();
    
            if (rs.next()) {
                chambre = new Chambre();
                chambre.setId(rs.getInt("id"));
                chambre.setNumero(rs.getInt("numero"));
                chambre.setNumeroEtage(rs.getInt("NmbrEtage"));
            }
    
            System.out.println("Connexion Bd établie");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement du Driver");
        } catch (SQLException e) {
            System.out.println("Erreur de Connexion à votre BD");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        return chambre;
    }


    @Override
    public boolean update(int id, int valeur, int value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
    
}
