package com.evaluation.repository;

import java.sql.Date;

import com.evaluation.core.Repository;
import com.evaluation.entities.Rv;

public interface RvRepository extends Repository<Rv> {
    public Rv  searchByDate(Date date);
}
