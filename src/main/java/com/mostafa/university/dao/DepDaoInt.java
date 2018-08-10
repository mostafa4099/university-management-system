package com.mostafa.university.dao;

import com.mostafa.university.domain.Department;
import java.util.List;

public interface DepDaoInt {
    List<Department> getAllObject();
    Department getObjectById(int depId);
    void addObject(Department department);
    void updateObject(Department department);
    void deleteObject(int depId);
    boolean objectExists(String depName);
}
