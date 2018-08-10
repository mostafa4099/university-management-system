package com.mostafa.university.service;

import com.mostafa.university.domain.SubjectResult;
import java.util.List;

public interface SubjectResultServiceInt {
    List<SubjectResult> getAllObject();
    SubjectResult getObjectById(int subResultId);
    boolean addObject(SubjectResult subResult);
    void updateObject(SubjectResult subResult);
    void deleteObject(int subResultId);
}
