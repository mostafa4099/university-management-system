package com.mostafa.university.service;

import com.mostafa.university.dao.SalaryInfoDaoInt;
import com.mostafa.university.domain.SalaryInfo;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryInfoServiceImp implements SalaryInfoServiceInt{
    
    @Autowired
    private SalaryInfoDaoInt salaryInfoDaoInt;

    @Override
    public List<SalaryInfo> getAllObject() {
        return salaryInfoDaoInt.getAllObject();
    }

    @Override
    public SalaryInfo getObjectById(int salaryId) {
        return salaryInfoDaoInt.getObjectById(salaryId);
    }

    @Override
    public boolean addObject(SalaryInfo salary) {
        if (salaryInfoDaoInt.objectExists(salary.getEmpInfo().getEmpId(), salary.getPaymentMonth())) {
            return false;
        } else {
            salaryInfoDaoInt.addObject(salary);
            return true;
        }
    }

    @Override
    public void updateObject(SalaryInfo salary) {
        salaryInfoDaoInt.updateObject(salary);
    }

    @Override
    public void deleteObject(int salaryId) {
        salaryInfoDaoInt.deleteObject(salaryId);
    }
    
}
