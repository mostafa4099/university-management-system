package com.mostafa.university.service;

import com.mostafa.university.domain.SemisterResult;
import java.util.List;

public interface SemisterResultServiceInt {
    List<SemisterResult> getAllObject();
    SemisterResult getObjectById(int semResultId);
    boolean addObject(SemisterResult semResult);
    void updateObject(SemisterResult semResult);
    void deleteObject(int semResultId);
}
