package com.mostafa.university.dao;

import com.mostafa.university.domain.Faculty;
import java.util.List;

public interface FacultyDaoInt {
    List<Faculty> getAllObject();
    Faculty getObjectById(int facId);
    void addObject(Faculty faculty);
    void updateObject(Faculty faculty);
    void deleteObject(int facId);
    boolean objectExists(String facName);
}
