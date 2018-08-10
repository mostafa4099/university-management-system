package com.mostafa.university.service;

import com.mostafa.university.domain.ExamSchedule;
import java.util.List;

public interface ExamScheduleServiceInt {
    List<ExamSchedule> getAllObject();
    ExamSchedule getObjectById(int scheduleId);
    boolean addObject(ExamSchedule schedule);
    void updateObject(ExamSchedule schedule);
    void deleteObject(int scheduleId);
}
