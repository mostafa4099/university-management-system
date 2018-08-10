package com.mostafa.university.service;

import com.mostafa.university.dao.FinalResultDaoInt;
import com.mostafa.university.domain.FinalResult;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinalResultServiceImp implements FinalResultServiceInt{
    
    @Autowired
    private FinalResultDaoInt finalResultDaoInt;

    @Override
    public List<FinalResult> getAllObject() {
        return finalResultDaoInt.getAllObject();
    }

    @Override
    public FinalResult getObjectById(int cgpaId) {
        return finalResultDaoInt.getObjectById(cgpaId);
    }

    @Override
    public boolean addObject(FinalResult finalResult) {
        if (finalResultDaoInt.objectExists(finalResult.getStudentInfo().getStId(), finalResult.getProgram().getProId(), finalResult.getCgpa())) {
            return false;
        } else {
            finalResultDaoInt.addObject(finalResult);
            return true;
        }
    }

    @Override
    public void updateObject(FinalResult finalResult) {
        finalResultDaoInt.updateObject(finalResult);
    }

    @Override
    public void deleteObject(int cgpaId) {
        finalResultDaoInt.deleteObject(cgpaId);
    }
}
