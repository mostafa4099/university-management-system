package com.mostafa.university.service;

import com.mostafa.university.domain.Designation;
import java.util.List;

public interface DesignationServiceInt {
    List<Designation> getAllObject();
    Designation getObjectById(int desigId);
    boolean addObject(Designation designation);
    void updateObject(Designation designation);
    void deleteObject(int desigId);
}
