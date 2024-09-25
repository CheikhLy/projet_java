package org.example.data.core.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DataSourceImpl implements DataSource<Object> {
    protected Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/ges_dette"; // Changez selon votre besoin
    private final String user = "root";
    private final String password = "";

    @Override
    public Connection setConnexion() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connection established.");
            }
        } catch (SQLException e) {
            System.err.println("Error establishing connection: " + e.getMessage());
        }
        return connection;
    }

    @Override
    public void closeConnexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing connection: " + e.getMessage());
        }
    }

    @Override
    public int executeUpdate(String sql, List<Object> params) {
        int rowsAffected = 0;
        try (Connection conn = setConnexion();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            setParameters(statement, params); // Méthode pour définir les paramètres de la requête
            rowsAffected = statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error executing update: " + e.getMessage());
        }
        return rowsAffected;
    }

    @Override
    public ResultSet executeQuery(String sql, List<Object> params) {
        ResultSet resultSet = null;
        try {
            Connection conn = setConnexion(); // Garder la connexion ouverte
            PreparedStatement statement = conn.prepareStatement(sql);
            setParameters(statement, params); // Méthode pour définir les paramètres de la requête
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
        return resultSet; // Notez que vous devez gérer le ResultSet à l'extérieur de cette méthode
    }

    private void setParameters(PreparedStatement statement, List<Object> params) throws SQLException {
        if (params != null) {
            for (int i = 0; i < params.size(); i++) {
                Object param = params.get(i);
                
                // Vérifiez le type de l'objet et définissez-le dans le statement en fonction de son type
                if (param instanceof Integer) {
                    statement.setInt(i + 1, (Integer) param);
                } else if (param instanceof String) {
                    statement.setString(i + 1, (String) param);
                } else if (param instanceof Double) {
                    statement.setDouble(i + 1, (Double) param);
                } else if (param instanceof Boolean) {
                    statement.setBoolean(i + 1, (Boolean) param);
                } else if (param instanceof java.sql.Date) {
                    statement.setDate(i + 1, (java.sql.Date) param);
                } else {
                    statement.setObject(i + 1, param); // Si le type n'est pas pris en charge explicitement
                }
            }
        }
    }
}
