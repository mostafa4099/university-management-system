package com.mostafa.university.service;

import com.mostafa.university.domain.Faculty;
import java.util.List;

public interface FacultyServiceInt {
    List<Faculty> getAllObject();
    Faculty getObjectById(int facId);
    boolean addObject(Faculty faculty);
    void updateObject(Faculty faculty);
    void deleteObject(int facId);
}
