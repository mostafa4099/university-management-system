package com.mostafa.university.dao;

import com.mostafa.university.domain.Routine;
import java.util.List;

public interface RoutineDaoInt {
    List<Routine> getAllObject();
    Routine getObjectById(int routineId);
    void addObject(Routine routine);
    void updateObject(Routine routine);
    void deleteObject(int routineId);
    boolean objectExists(int teacherId, int hourId, int dayId);
}
