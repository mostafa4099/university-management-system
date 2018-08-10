package com.mostafa.university.dao;

import com.mostafa.university.domain.Exam;
import java.util.List;

public interface ExamDaoInt {
    List<Exam> getAllObject();
    Exam getObjectById(int examId);
    void addObject(Exam exam);
    void updateObject(Exam exam);
    void deleteObject(int examId);
    boolean objectExists(int depId, int proId, String examName);
}
