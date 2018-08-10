package com.mostafa.university.service;

import com.mostafa.university.domain.FinalResult;
import java.util.List;

public interface FinalResultServiceInt {
    List<FinalResult> getAllObject();
    FinalResult getObjectById(int cgpaId);
    boolean addObject(FinalResult finalResult);
    void updateObject(FinalResult finalResult);
    void deleteObject(int cgpaId);
}
