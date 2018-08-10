package com.mostafa.university.service;

import com.mostafa.university.dao.ExamDaoInt;
import com.mostafa.university.domain.Exam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImp implements ExamServiceInt{
    
    @Autowired
    private ExamDaoInt examDaoInt;

    @Override
    public List<Exam> getAllObject() {
        return examDaoInt.getAllObject();
    }

    @Override
    public Exam getObjectById(int examId) {
        return examDaoInt.getObjectById(examId);
    }

    @Override
    public boolean addObject(Exam exam) {
        if (examDaoInt.objectExists(exam.getDepartment().getDepId(), exam.getProgram().getProId(), exam.getExamName())) {
            return false;
        } else {
            examDaoInt.addObject(exam);
            return true;
        }
    }

    @Override
    public void updateObject(Exam exam) {
        examDaoInt.updateObject(exam);
    }

    @Override
    public void deleteObject(int examId) {
        examDaoInt.deleteObject(examId);
    }
}
