package com.mostafa.university.service;

import com.mostafa.university.dao.ClassHourDaoInt;
import com.mostafa.university.domain.ClassHour;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassHourServiceImp implements ClassHourServiceInt{
    
    @Autowired
    private ClassHourDaoInt classHourDaoInt;

    @Override
    public List<ClassHour> getAllObject() {
        return classHourDaoInt.getAllObject();
    }

    @Override
    public ClassHour getObjectById(int hourId) {
        return classHourDaoInt.getObjectById(hourId);
    }
    
}
