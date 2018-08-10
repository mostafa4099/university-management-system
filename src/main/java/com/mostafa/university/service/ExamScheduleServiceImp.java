package com.mostafa.university.service;

import com.mostafa.university.dao.ExamScheduleDaoInt;
import com.mostafa.university.domain.ExamSchedule;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamScheduleServiceImp implements ExamScheduleServiceInt{
    
    @Autowired
    private ExamScheduleDaoInt scheduleDaoInt;

    @Override
    public List<ExamSchedule> getAllObject() {
        return scheduleDaoInt.getAllObject();
    }

    @Override
    public ExamSchedule getObjectById(int scheduleId) {
        return scheduleDaoInt.getObjectById(scheduleId);
    }

    @Override
    public boolean addObject(ExamSchedule schedule) {
        if (scheduleDaoInt.objectExists(schedule.getExam().getExamId(), schedule.getSubject().getSubId(), schedule.getExamDate())) {
            return false;
        } else {
            scheduleDaoInt.addObject(schedule);
            return true;
        }
    }

    @Override
    public void updateObject(ExamSchedule schedule) {
        scheduleDaoInt.updateObject(schedule);
    }

    @Override
    public void deleteObject(int scheduleId) {
        scheduleDaoInt.deleteObject(scheduleId);
    }
}
