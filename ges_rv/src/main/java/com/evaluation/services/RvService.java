package com.evaluation.services;

import java.sql.Date;
import java.util.List;

import com.evaluation.entities.Rv;

public interface RvService {

    public void create(Rv rv);

    public List<Rv> findAll();

    public Rv searchByDate(Date date);
}
