package com.mostafa.university.dao;

import com.mostafa.university.domain.EmpInfo;
import java.util.List;

public interface EmpInfoDaoInt {
    List<EmpInfo> getAllObject();
    EmpInfo getObjectById(int empId);
    void addObject(EmpInfo empInfo);
    void updateObject(EmpInfo empInfo);
    void deleteObject(int empId);
    boolean objectExists(String empName, String empFather, String empMobile);
}
