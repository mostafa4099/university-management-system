package com.mostafa.university.service;

import com.mostafa.university.dao.AttendenceDaoInt;
import com.mostafa.university.domain.Attendence;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendenceServiceImp implements AttendenceServiceInt{

    @Autowired
    private AttendenceDaoInt attendenceDaoInt;
    
    @Override
    public List<Attendence> getAllObject() {
        return attendenceDaoInt.getAllObject();
    }

    @Override
    public Attendence getObjectById(int attendId) {
        return attendenceDaoInt.getObjectById(attendId);
    }

    @Override
    public boolean addObject(Attendence attendence) {
        if (attendenceDaoInt.objectExists(attendence.getStudentInfo().getStId(), attendence.getClassHour().getHourId(), attendence.getAttendDate())) {
            return false;
        } else {
            attendenceDaoInt.addObject(attendence);
            return true;
        }
    }

    @Override
    public void updateObject(Attendence attendence) {
        attendenceDaoInt.updateObject(attendence);
    }

    @Override
    public void deleteObject(int attendId) {
        attendenceDaoInt.deleteObject(attendId);
    }
    
}
