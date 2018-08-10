package com.mostafa.university.dao;

import com.mostafa.university.domain.FinalResult;
import java.util.List;

public interface FinalResultDaoInt {
    List<FinalResult> getAllObject();
    FinalResult getObjectById(int cgpaId);
    void addObject(FinalResult finalResult);
    void updateObject(FinalResult finalResult);
    void deleteObject(int cgpaId);
    boolean objectExists(int stId, int proId, double cgpa);
}
