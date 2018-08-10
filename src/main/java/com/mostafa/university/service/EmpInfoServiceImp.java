package com.mostafa.university.service;

import com.mostafa.university.dao.EmpInfoDaoInt;
import com.mostafa.university.domain.EmpInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpInfoServiceImp implements EmpInfoServiceInt{
    
    @Autowired
    private EmpInfoDaoInt empInfoDaoInt;

    @Override
    public List<EmpInfo> getAllObject() {
        return empInfoDaoInt.getAllObject();
    }

    @Override
    public EmpInfo getObjectById(int empId) {
        return empInfoDaoInt.getObjectById(empId);
    }

    @Override
    public boolean addObject(EmpInfo empInfo) {
        if (empInfoDaoInt.objectExists(empInfo.getEmpName(), empInfo.getEmpFather(), empInfo.getEmpMobile())) {
            return false;
        } else {
            empInfoDaoInt.addObject(empInfo);
            return true;
        }
    }

    @Override
    public void updateObject(EmpInfo empInfo) {
        empInfoDaoInt.updateObject(empInfo);
    }

    @Override
    public void deleteObject(int empId) {
        empInfoDaoInt.deleteObject(empId);
    }
    
}
