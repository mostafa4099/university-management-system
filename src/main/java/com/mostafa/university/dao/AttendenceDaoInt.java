package com.mostafa.university.dao;

import com.mostafa.university.domain.Attendence;
import java.util.Date;
import java.util.List;

public interface AttendenceDaoInt {
    List<Attendence> getAllObject();
    Attendence getObjectById(int attendId);
    void addObject(Attendence attendence);
    void updateObject(Attendence attendence);
    void deleteObject(int attendId);
    boolean objectExists(int stId, int hourId, Date attendDate);
}
