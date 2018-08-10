package com.mostafa.university.service;

import com.mostafa.university.domain.Department;
import java.util.List;

public interface DepServiceInt {
    List<Department> getAllObject();
    Department getObjectById(int depId);
    boolean addObject(Department department);
    void updateObject(Department department);
    void deleteObject(int depId);
}
