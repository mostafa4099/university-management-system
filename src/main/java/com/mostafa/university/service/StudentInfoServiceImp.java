package com.mostafa.university.service;

import com.mostafa.university.dao.StudentInfoDaoInt;
import com.mostafa.university.domain.StudentInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentInfoServiceImp implements StudentInfoServiceInt {

    @Autowired
    private StudentInfoDaoInt studentInfoDaoInt;
    
    @Override
    public List<StudentInfo> getAllObject() {
        return studentInfoDaoInt.getAllObject();
    }

    @Override
    public StudentInfo getObjectById(int stId) {
        return studentInfoDaoInt.getObjectById(stId);
    }

    @Override
    public boolean addObject(StudentInfo student) {
        if (studentInfoDaoInt.objectExists(student.getStName(), student.getStRoll(), student.getStReg())) {
            return false;
        } else {
            studentInfoDaoInt.addObject(student);
            return true;
        }
    }

    @Override
    public void updateObject(StudentInfo student) {
        studentInfoDaoInt.updateObject(student);
    }

    @Override
    public void deleteObject(int stId) {
        studentInfoDaoInt.deleteObject(stId);
    }
    
}
