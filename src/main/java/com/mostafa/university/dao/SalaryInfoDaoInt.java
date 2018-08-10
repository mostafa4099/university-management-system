package com.mostafa.university.dao;

import com.mostafa.university.domain.SalaryInfo;
import com.mostafa.university.domain.Subject;
import java.util.Date;
import java.util.List;

public interface SalaryInfoDaoInt {
    List<SalaryInfo> getAllObject();
    SalaryInfo getObjectById(int salaryId);
    void addObject(SalaryInfo salary);
    void updateObject(SalaryInfo salary);
    void deleteObject(int salaryId);
    boolean objectExists(int empId, Date paymentMonth);
}
