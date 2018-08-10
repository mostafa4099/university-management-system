package com.mostafa.university.service;

import com.mostafa.university.dao.GradeDaoInt;
import com.mostafa.university.domain.Grade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImp implements GradeServiceInt{
    
    @Autowired
    private GradeDaoInt gradeDaoInt;

    @Override
    public List<Grade> getAllObject() {
        return gradeDaoInt.getAllObject();
    }

    @Override
    public Grade getObjectById(int gradeId) {
        return gradeDaoInt.getObjectById(gradeId);
    }
    
}
