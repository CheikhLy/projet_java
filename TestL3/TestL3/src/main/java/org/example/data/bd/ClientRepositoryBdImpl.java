package org.example.data.bd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.data.entities.Client;

public class ClientRepositoryBdImpl extends RepositoryBdImpl<Client> implements ClientRepositoryBd{

    @Override
    public void insert(Client client) {
        List <Client> clients =new ArrayList<>();
        String query = "INSERT INTO client (surname, phone, address) VALUES (?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setString(1, client.getSurname());
            statement.setString(2, client.getPhone());
            statement.setString(3, client.getAddress());
            statement.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion du client : " + e.getMessage());
        }
        clients.add(client);
    }

    @Override
    public List<Client> selectAll() {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM client";
        
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
             
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setSurname(resultSet.getString("surname"));
                client.setPhone(resultSet.getString("phone"));
                client.setAddress(resultSet.getString("address"));
                clients.add(client);
            }
            
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des clients : " + e.getMessage());
        }
        return clients;
    }

    @Override
    public Client selectById(int id) {
        String query = "SELECT * FROM client WHERE id = ?";
        
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setSurname(resultSet.getString("surname"));
                client.setPhone(resultSet.getString("phone"));
                client.setAddress(resultSet.getString("address"));
                return client;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Client client) {
        String query = "UPDATE client SET surname = ?, phone = ?, address = ? WHERE id = ?";
        
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setString(1, client.getSurname());
            statement.setString(2, client.getPhone());
            statement.setString(3, client.getAddress());
            statement.setInt(4, client.getId());
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

    @Override
    public Client selectByPhone(String phone) {
        String query = "SELECT * FROM client WHERE phone = ?";
        
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setString(1, phone);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setSurname(resultSet.getString("surname"));
                client.setPhone(resultSet.getString("phone"));
                client.setAddress(resultSet.getString("address"));
                return client;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
