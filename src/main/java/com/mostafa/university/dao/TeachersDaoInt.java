package com.mostafa.university.dao;

import com.mostafa.university.domain.Teachers;
import java.util.List;

public interface TeachersDaoInt {
    List<Teachers> getAllObject();
    Teachers getObjectById(int teacherId);
    void addObject(Teachers teachers);
    void updateObject(Teachers teachers);
    void deleteObject(int teacherId);
    boolean objectExists(int empId);
}
