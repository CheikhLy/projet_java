package com.evaluation.core;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public abstract class RepositoryImpl<T> implements Repository<T> {

    protected Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ges_rv";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void insert(T object) {
        String query = getInsertQuery();  
        
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            setInsertParameters(statement, object); 
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> selectAll() {
        List<T> results = new ArrayList<>();
        String query = getSelectAllQuery();  

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                T object = mapResultSetToEntity(resultSet);  
                results.add(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    protected abstract String getInsertQuery(); 

    protected abstract void setInsertParameters(PreparedStatement statement, T object) throws SQLException;  

    protected abstract String getSelectAllQuery();  

    protected abstract T mapResultSetToEntity(ResultSet resultSet) throws SQLException;  
}