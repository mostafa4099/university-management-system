package com.mostafa.university.service;

import com.mostafa.university.domain.Teachers;
import java.util.List;

public interface TeachersServiceInt {
    List<Teachers> getAllObject();
    Teachers getObjectById(int teacherId);
    boolean addObject(Teachers teachers);
    void updateObject(Teachers teachers);
    void deleteObject(int teacherId);
}
