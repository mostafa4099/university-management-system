package com.mostafa.university.dao;

import com.mostafa.university.domain.SubjectResult;
import java.util.List;

public interface SubjectResultDaoInt {
    List<SubjectResult> getAllObject();
    SubjectResult getObjectById(int subResultId);
    void addObject(SubjectResult subResult);
    void updateObject(SubjectResult subResult);
    void deleteObject(int subResultId);
    boolean objectExists(int stId, int subId, double gpa);
}
