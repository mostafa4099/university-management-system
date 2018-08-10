package com.mostafa.university.service;

import com.mostafa.university.dao.AttendenceValueDaoInt;
import com.mostafa.university.domain.AttendenceValue;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendenceValueServiceImp implements AttendenceValueServiceInt{
    
    @Autowired
    private AttendenceValueDaoInt attendenceValueDaoInt;

    @Override
    public List<AttendenceValue> getAllObject() {
        return attendenceValueDaoInt.getAllObject();
    }

    @Override
    public AttendenceValue getObjectById(int attValId) {
        return attendenceValueDaoInt.getObjectById(attValId);
    }
    
}
