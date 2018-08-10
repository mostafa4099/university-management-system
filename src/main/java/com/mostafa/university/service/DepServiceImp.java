package com.mostafa.university.service;

import com.mostafa.university.dao.DepDaoInt;
import com.mostafa.university.domain.Department;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepServiceImp implements DepServiceInt{
    
    @Autowired
    private DepDaoInt depDaoInt;

    @Override
    public List<Department> getAllObject() {
        return depDaoInt.getAllObject();
    }

    @Override
    public Department getObjectById(int depId) {
        return depDaoInt.getObjectById(depId);
    }
    
    @Override
    public synchronized boolean addObject(Department department) {
        if (depDaoInt.objectExists(department.getDepName())) {
            return false;
        } else {
            depDaoInt.addObject(department);
            return true;
        }
    }

    @Override
    public void updateObject(Department department) {
        depDaoInt.updateObject(department);
    }

    @Override
    public void deleteObject(int depId) {
        depDaoInt.deleteObject(depId);
    }
    
}
