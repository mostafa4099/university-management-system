package com.mostafa.university.service;

import com.mostafa.university.dao.SemisterDaoInt;
import com.mostafa.university.domain.Semister;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SemisterServiceImp implements SemisterServiceInt{
    
    @Autowired
    private SemisterDaoInt semisterDaoInt;

    @Override
    public List<Semister> getAllObject() {
        return semisterDaoInt.getAllObject();
    }

    @Override
    public Semister getObjectById(int semId) {
        return semisterDaoInt.getObjectById(semId);
    }
    
}
