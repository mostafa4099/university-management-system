package com.mostafa.university.service;

import com.mostafa.university.domain.Subject;
import java.util.List;

public interface SubjectServiceInt {
    List<Subject> getAllObject();
    Subject getObjectById(int subId);
    boolean addObject(Subject subject);
    void updateObject(Subject subject);
    void deleteObject(int subId);
}
