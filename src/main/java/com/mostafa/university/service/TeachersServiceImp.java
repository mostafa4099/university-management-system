package com.mostafa.university.service;

import com.mostafa.university.dao.TeachersDaoInt;
import com.mostafa.university.domain.Teachers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeachersServiceImp implements TeachersServiceInt{

    @Autowired
    private TeachersDaoInt teachersDaoInt;
    
    @Override
    public List<Teachers> getAllObject() {
        return teachersDaoInt.getAllObject();
    }

    @Override
    public Teachers getObjectById(int teacherId) {
        return teachersDaoInt.getObjectById(teacherId);
    }

    @Override
    public boolean addObject(Teachers teachers) {
        if (teachersDaoInt.objectExists(teachers.getEmpInfo().getEmpId())) {
            return false;
        } else {
            teachersDaoInt.addObject(teachers);
            return true;
        }
    }

    @Override
    public void updateObject(Teachers teachers) {
        teachersDaoInt.updateObject(teachers);
    }

    @Override
    public void deleteObject(int teacherId) {
        teachersDaoInt.deleteObject(teacherId);
    }
    
}
