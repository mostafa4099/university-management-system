package com.mostafa.university.service;

import com.mostafa.university.domain.EmpInfo;
import java.util.List;

public interface EmpInfoServiceInt {
    List<EmpInfo> getAllObject();
    EmpInfo getObjectById(int empId);
    boolean addObject(EmpInfo empInfo);
    void updateObject(EmpInfo empInfo);
    void deleteObject(int empId);
}
