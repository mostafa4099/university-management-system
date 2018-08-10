package com.mostafa.university.dao;

import com.mostafa.university.domain.Subject;
import java.util.List;

public interface SubjectDaoInt {
    List<Subject> getAllObject();
    Subject getObjectById(int subId);
    void addObject(Subject subject);
    void updateObject(Subject subject);
    void deleteObject(int subId);
    boolean objectExists(int depId, int semId, int proId, String subName);
}
