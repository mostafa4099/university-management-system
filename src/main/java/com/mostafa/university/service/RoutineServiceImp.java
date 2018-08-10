package com.mostafa.university.service;

import com.mostafa.university.dao.RoutineDaoInt;
import com.mostafa.university.domain.Routine;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoutineServiceImp implements RoutineServiceInt{
    
    @Autowired
    private RoutineDaoInt routineDaoInt;

    @Override
    public List<Routine> getAllObject() {
        return routineDaoInt.getAllObject();
    }

    @Override
    public Routine getObjectById(int routineId) {
        return routineDaoInt.getObjectById(routineId);
    }

    @Override
    public boolean addObject(Routine routine) {
        if (routineDaoInt.objectExists(routine.getTeachers().getTeacherId(), routine.getClassHour().getHourId(), routine.getClassDay().getDayId())) {
            return false;
        } else {
            routineDaoInt.addObject(routine);
            return true;
        }
    }

    @Override
    public void updateObject(Routine routine) {
        routineDaoInt.updateObject(routine);
    }

    @Override
    public void deleteObject(int routineId) {
        routineDaoInt.deleteObject(routineId);
    }
    
}
