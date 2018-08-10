package com.mostafa.university.service;

import com.mostafa.university.domain.StudentAssigne;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mostafa.university.dao.StudentAssigneDaoInt;

@Service
public class StudentAssigneServiceImp implements StudentAssigneServiceInt{
    
    @Autowired
    private StudentAssigneDaoInt assigneDaoInt;

    @Override
    public List<StudentAssigne> getAllObject() {
        return assigneDaoInt.getAllObject();
    }

    @Override
    public StudentAssigne getObjectById(int assigneId) {
        return assigneDaoInt.getObjectById(assigneId);
    }

    @Override
    public boolean addObject(StudentAssigne assigne) {
        if (assigneDaoInt.objectExists(assigne.getStudentInfo().getStId(), assigne.getDepartment().getDepId(), assigne.getProgram().getProId(), assigne.getSemister().getSemId(), assigne.getSubject().getSubId())) {
            return false;
        } else {
            assigneDaoInt.addObject(assigne);
            return true;
        }
    }

    @Override
    public void updateObject(StudentAssigne assigne) {
        assigneDaoInt.updateObject(assigne);
    }

    @Override
    public void deleteObject(int assigneId) {
        assigneDaoInt.deleteObject(assigneId);
    }
    
}
