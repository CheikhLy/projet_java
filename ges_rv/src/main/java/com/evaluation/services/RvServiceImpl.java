package com.evaluation.services;

import java.sql.Date;
import java.util.List;

import com.evaluation.entities.Rv;
import com.evaluation.repository.RvRepository;

public class RvServiceImpl implements RvService{
    RvRepository rvRepository;

    public RvServiceImpl(RvRepository rvRepository) {
        this.rvRepository = rvRepository;
    }
    @Override
    public void create(Rv rv) {
        rvRepository.insert(rv);
        }

    @Override
    public List<Rv> findAll() {
       return rvRepository.selectAll();
    }

    @Override
    public Rv searchByDate(Date date) {
        return rvRepository.searchByDate(date);
    }
    
}
