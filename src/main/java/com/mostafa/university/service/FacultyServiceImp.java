package com.mostafa.university.service;

import com.mostafa.university.dao.FacultyDaoInt;
import com.mostafa.university.domain.Faculty;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImp implements FacultyServiceInt{
    
    @Autowired
    private FacultyDaoInt facDaoInt;

    @Override
    public List<Faculty> getAllObject() {
        return facDaoInt.getAllObject();
    }

    @Override
    public Faculty getObjectById(int facId) {
        return facDaoInt.getObjectById(facId);
    }
    
    @Override
    public synchronized boolean addObject(Faculty faculty) {
        if (facDaoInt.objectExists(faculty.getFacName())) {
            return false;
        } else {
            facDaoInt.addObject(faculty);
            return true;
        }
    }

    @Override
    public void updateObject(Faculty faculty) {
        facDaoInt.updateObject(faculty);
    }

    @Override
    public void deleteObject(int facId) {
        facDaoInt.deleteObject(facId);
    }
    
}
