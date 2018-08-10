package com.mostafa.university.service;

import com.mostafa.university.domain.Grade;
import java.util.List;

public interface GradeServiceInt {
    List<Grade> getAllObject();
    Grade getObjectById(int gradeId);
}
