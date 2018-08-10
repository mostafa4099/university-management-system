package com.mostafa.university.dao;

import com.mostafa.university.domain.StudentInfo;
import java.util.List;

public interface StudentInfoDaoInt {
    List<StudentInfo> getAllObject();
    StudentInfo getObjectById(int stId);
    void addObject(StudentInfo studentInfo);
    void updateObject(StudentInfo studentInfo);
    void deleteObject(int stId);
    boolean objectExists(String stName, int stRoll, int stReg);
}
