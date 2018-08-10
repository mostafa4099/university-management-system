package com.mostafa.university.service;

import com.mostafa.university.domain.Routine;
import java.util.List;

public interface RoutineServiceInt {
    List<Routine> getAllObject();
    Routine getObjectById(int routineId);
    boolean addObject(Routine routine);
    void updateObject(Routine routine);
    void deleteObject(int routineId);
}
