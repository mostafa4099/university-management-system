package com.mostafa.university.service;

import com.mostafa.university.domain.SalaryInfo;
import java.util.List;

public interface SalaryInfoServiceInt {
    List<SalaryInfo> getAllObject();
    SalaryInfo getObjectById(int salaryId);
    boolean addObject(SalaryInfo salary);
    void updateObject(SalaryInfo salary);
    void deleteObject(int salaryId);
}
