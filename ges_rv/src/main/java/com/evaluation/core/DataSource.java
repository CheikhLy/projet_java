package com.evaluation.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DataSource<T> {

    public Connection setConnexion();

    public void closeConnexion();

    int executeUpdate(String sql, List<Object> params);
    ResultSet executeQuery(String sql, List<Object> params);
}
