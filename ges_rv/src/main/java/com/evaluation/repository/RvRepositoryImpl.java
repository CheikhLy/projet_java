package com.evaluation.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.evaluation.core.RepositoryImpl;
import com.evaluation.entities.Rv;

public class RvRepositoryImpl extends RepositoryImpl<Rv> implements RvRepository {

    @Override
    public Rv searchByDate(Date date) {
    return list.stream()
     .filter(rv -> rv
     .getDate()
     .equals(date))
     .findFirst()
     .orElse(null);
    }

    @Override
    protected String getInsertQuery() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInsertQuery'");
    }

    @Override
    protected void setInsertParameters(PreparedStatement statement, Rv object) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setInsertParameters'");
    }

    @Override
    protected String getSelectAllQuery() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSelectAllQuery'");
    }

    @Override
    protected Rv mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapResultSetToEntity'");
    }
    
}
