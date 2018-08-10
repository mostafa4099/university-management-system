package com.mostafa.university.dao;

import com.mostafa.university.domain.SemisterResult;
import java.util.List;

public interface SemisterResultDaoInt {
    List<SemisterResult> getAllObject();
    SemisterResult getObjectById(int semResultId);
    void addObject(SemisterResult semResult);
    void updateObject(SemisterResult semResult);
    void deleteObject(int semResultId);
    boolean objectExists(int stId, int proId,int semId, double gpa);
}
