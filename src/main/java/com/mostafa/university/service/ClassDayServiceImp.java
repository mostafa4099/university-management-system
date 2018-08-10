package com.mostafa.university.service;

import com.mostafa.university.dao.ClassDayDaoInt;
import com.mostafa.university.domain.ClassDay;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassDayServiceImp implements ClassDayServiceInt{
    
    @Autowired
    private ClassDayDaoInt classDayDaoInt;

    @Override
    public List<ClassDay> getAllObject() {
        return classDayDaoInt.getAllObject();
    }

    @Override
    public ClassDay getObjectById(int dayId) {
        return classDayDaoInt.getObjectById(dayId);
    }
    
}
