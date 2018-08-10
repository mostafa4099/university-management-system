package com.mostafa.university.service;

import com.mostafa.university.dao.SubjectDaoInt;
import com.mostafa.university.domain.Subject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImp implements SubjectServiceInt {
    
    @Autowired
    private SubjectDaoInt subjectDaoInt;
    
    @Override
    public List<Subject> getAllObject() {
        return subjectDaoInt.getAllObject();
    }
    
    @Override
    public Subject getObjectById(int subId) {
        return subjectDaoInt.getObjectById(subId);
    }
    
    @Override
    public boolean addObject(Subject subject) {
        if (subjectDaoInt.objectExists(subject.getDepartment().getDepId(), subject.getProgram().getProId(), subject.getSemister().getSemId(), subject.getSubName())) {
            return false;
        } else {
            subjectDaoInt.addObject(subject);
            return true;
        }
    }
    
    @Override
    public void updateObject(Subject subject) {
        subjectDaoInt.updateObject(subject);
    }
    
    @Override
    public void deleteObject(int subId) {
        subjectDaoInt.deleteObject(subId);
    }
    
}
