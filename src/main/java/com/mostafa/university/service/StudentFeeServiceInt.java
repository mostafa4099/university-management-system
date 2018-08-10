package com.mostafa.university.service;

import com.mostafa.university.domain.StudentFee;
import java.util.List;

public interface StudentFeeServiceInt {
    List<StudentFee> getAllObject();
    StudentFee getObjectById(int feeId);
    boolean addObject(StudentFee fee);
    void updateObject(StudentFee fee);
    void deleteObject(int feeId);
}
