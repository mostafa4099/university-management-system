package com.mostafa.university.dao;

import com.mostafa.university.domain.Grade;
import java.util.List;

public interface GradeDaoInt {
    List<Grade> getAllObject();
    Grade getObjectById(int gradeId);
}
