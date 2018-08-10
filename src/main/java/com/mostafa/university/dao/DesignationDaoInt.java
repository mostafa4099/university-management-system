package com.mostafa.university.dao;

import com.mostafa.university.domain.Designation;
import java.util.List;

public interface DesignationDaoInt {
    List<Designation> getAllObject();
    Designation getObjectById(int desigId);
    void addObject(Designation designation);
    void updateObject(Designation designation);
    void deleteObject(int desigId);
    boolean objectExists(String desigName);
}
