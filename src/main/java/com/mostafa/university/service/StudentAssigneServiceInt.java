package com.mostafa.university.service;

import com.mostafa.university.domain.Attendence;
import com.mostafa.university.domain.StudentAssigne;
import java.util.List;

public interface StudentAssigneServiceInt {
    List<StudentAssigne> getAllObject();
    StudentAssigne getObjectById(int assigneId);
    boolean addObject(StudentAssigne assigne);
    void updateObject(StudentAssigne assigne);
    void deleteObject(int assigneId);
}
