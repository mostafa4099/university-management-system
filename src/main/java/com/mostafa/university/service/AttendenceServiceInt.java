package com.mostafa.university.service;

import com.mostafa.university.domain.Attendence;
import java.util.List;

public interface AttendenceServiceInt {
    List<Attendence> getAllObject();
    Attendence getObjectById(int attendId);
    boolean addObject(Attendence attendence);
    void updateObject(Attendence attendence);
    void deleteObject(int attendId);
}
