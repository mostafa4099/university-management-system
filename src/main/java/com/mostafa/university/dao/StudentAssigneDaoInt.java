package com.mostafa.university.dao;

import com.mostafa.university.domain.StudentAssigne;
import java.util.List;

public interface StudentAssigneDaoInt {
    List<StudentAssigne> getAllObject();
    StudentAssigne getObjectById(int assigneId);
    void addObject(StudentAssigne assigne);
    void updateObject(StudentAssigne assigne);
    void deleteObject(int assigneId);
    boolean objectExists(int stId, int depId, int proId, int semId, int subId);
}
