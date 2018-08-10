package com.mostafa.university.service;

import com.mostafa.university.domain.Exam;
import java.util.List;

public interface ExamServiceInt {
    List<Exam> getAllObject();
    Exam getObjectById(int examId);
    boolean addObject(Exam exam);
    void updateObject(Exam exam);
    void deleteObject(int examId);
}
