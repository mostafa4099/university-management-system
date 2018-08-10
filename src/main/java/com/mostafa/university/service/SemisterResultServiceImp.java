package com.mostafa.university.service;

import com.mostafa.university.dao.SemisterResultDaoInt;
import com.mostafa.university.domain.SemisterResult;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SemisterResultServiceImp implements SemisterResultServiceInt{
    
    @Autowired
    private SemisterResultDaoInt semisterResultDaoInt;

    @Override
    public List<SemisterResult> getAllObject() {
        return semisterResultDaoInt.getAllObject();
    }

    @Override
    public SemisterResult getObjectById(int semResultId) {
        return semisterResultDaoInt.getObjectById(semResultId);
    }

    @Override
    public boolean addObject(SemisterResult semResult) {
        if (semisterResultDaoInt.objectExists(semResult.getStudentInfo().getStId(), semResult.getProgram().getProId(), semResult.getSemister().getSemId(), semResult.getGpa())) {
            return false;
        } else {
            semisterResultDaoInt.addObject(semResult);
            return true;
        }
    }

    @Override
    public void updateObject(SemisterResult semResult) {
        semisterResultDaoInt.updateObject(semResult);
    }

    @Override
    public void deleteObject(int semResultId) {
        semisterResultDaoInt.deleteObject(semResultId);
    }
}
