package com.mostafa.university.service;

import com.mostafa.university.domain.StudentInfo;
import java.util.List;

public interface StudentInfoServiceInt {
    List<StudentInfo> getAllObject();
    StudentInfo getObjectById(int stId);
    boolean addObject(StudentInfo student);
    void updateObject(StudentInfo student);
    void deleteObject(int stId);
}
