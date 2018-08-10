package com.mostafa.university.dao;

import com.mostafa.university.domain.StudentFee;
import java.util.Date;
import java.util.List;

public interface StudentFeeDaoInt {
    List<StudentFee> getAllObject();
    StudentFee getObjectById(int feeId);
    void addObject(StudentFee fee);
    void updateObject(StudentFee fee);
    void deleteObject(int feeId);
    boolean objectExists(int stId, double applyFee, double regFee, double tutionFee, double examFee, double othersFee);
}
