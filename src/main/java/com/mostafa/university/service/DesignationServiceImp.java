package com.mostafa.university.service;

import com.mostafa.university.dao.DesignationDaoInt;
import com.mostafa.university.domain.Designation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesignationServiceImp implements DesignationServiceInt{

    @Autowired
    private DesignationDaoInt designationDaoInt;
    
    @Override
    public List<Designation> getAllObject() {
        return designationDaoInt.getAllObject();
    }

    @Override
    public Designation getObjectById(int desigId) {
        return designationDaoInt.getObjectById(desigId);
    }

    @Override
    public synchronized boolean addObject(Designation designation) {
        if (designationDaoInt.objectExists(designation.getDesigName())) {
            return false;
        } else {
            designationDaoInt.addObject(designation);
            return true;
        }
    }

    @Override
    public void updateObject(Designation designation) {
        designationDaoInt.updateObject(designation);
    }

    @Override
    public void deleteObject(int desigId) {
        designationDaoInt.deleteObject(desigId);
    }
    
}
