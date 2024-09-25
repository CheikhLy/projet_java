package com.evaluation.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.evaluation.core.RepositoryImpl;
import com.evaluation.entities.Medecin;

public class MedecinRepositoryImpl extends RepositoryImpl<Medecin> implements MedecinRepository {
    MedecinRepository medecinRepository;

    public MedecinRepositoryImpl(MedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository;
    }

    @Override
    public void insert(Medecin object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public List<Medecin> selectAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectAll'");
    }

    @Override
    protected String getInsertQuery() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInsertQuery'");
    }

    @Override
    protected void setInsertParameters(PreparedStatement statement, Medecin object) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setInsertParameters'");
    }

    @Override
    protected String getSelectAllQuery() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSelectAllQuery'");
    }

    @Override
    protected Medecin mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapResultSetToEntity'");
    }
    
}
