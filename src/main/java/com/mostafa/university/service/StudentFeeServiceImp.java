package com.mostafa.university.service;

import com.mostafa.university.dao.StudentFeeDaoInt;
import com.mostafa.university.domain.StudentFee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentFeeServiceImp implements StudentFeeServiceInt{
    
    @Autowired
    private StudentFeeDaoInt feeDaoInt;

    @Override
    public List<StudentFee> getAllObject() {
        return feeDaoInt.getAllObject();
    }

    @Override
    public StudentFee getObjectById(int feeId) {
        return feeDaoInt.getObjectById(feeId);
    }

    @Override
    public boolean addObject(StudentFee fee) {
        if (feeDaoInt.objectExists(fee.getStudentInfo().getStId(), fee.getApplyFee(), fee.getRegFee(), fee.getTutionFee(), fee.getExamFee(), fee.getOthersFee())) {
            return false;
        } else {
            feeDaoInt.addObject(fee);
            return true;
        }
    }

    @Override
    public void updateObject(StudentFee fee) {
        feeDaoInt.updateObject(fee);
    }

    @Override
    public void deleteObject(int feeId) {
        feeDaoInt.deleteObject(feeId);
    }

    
    
}
