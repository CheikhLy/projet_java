package org.example.data.bd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryBdImpl<T> implements RepositoryBd<T> {

    protected Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ges_dette";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void insert(T object) {
        String query = "INSERT INTO client (surname, phone, address) VALUES (?, ?, ?)"; 
        // Ajuste la table et les colonnes selon l'entité `T`
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> selectAll() {
        List<T> results = new ArrayList<>();
        String query = "SELECT * FROM client";  
        
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            
            while (resultSet.next()) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public T selectById(int id) {
        T object = null;
        String query = "SELECT * FROM client WHERE id = ?";  
        
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public void update(T object) {
        String query = "UPDATE client SET surname = ?, phone = ?, address = ? WHERE id = ?";
        
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM client WHERE id = ?";
        
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
