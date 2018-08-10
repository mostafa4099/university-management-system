package com.mostafa.university.service;

import com.mostafa.university.dao.SubjectResultDaoInt;
import com.mostafa.university.domain.SubjectResult;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectResultServiceImp implements SubjectResultServiceInt{
    
    @Autowired
    private SubjectResultDaoInt subjectResultDaoInt;

    @Override
    public List<SubjectResult> getAllObject() {
        return subjectResultDaoInt.getAllObject();
    }

    @Override
    public SubjectResult getObjectById(int subResultId) {
        return subjectResultDaoInt.getObjectById(subResultId);
    }

    @Override
    public boolean addObject(SubjectResult subResult) {
        if (subjectResultDaoInt.objectExists(subResult.getStudentInfo().getStId(), subResult.getSubject().getSubId(), subResult.getGpa())) {
            return false;
        } else {
            subjectResultDaoInt.addObject(subResult);
            return true;
        }
    }

    @Override
    public void updateObject(SubjectResult subResult) {
        subjectResultDaoInt.updateObject(subResult);
    }

    @Override
    public void deleteObject(int subResultId) {
        subjectResultDaoInt.deleteObject(subResultId);
    }
    
}
