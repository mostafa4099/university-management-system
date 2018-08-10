package com.mostafa.university.dao;

import com.mostafa.university.domain.ExamSchedule;
import java.util.Date;
import java.util.List;

public interface ExamScheduleDaoInt {
    List<ExamSchedule> getAllObject();
    ExamSchedule getObjectById(int scheduleId);
    void addObject(ExamSchedule schedule);
    void updateObject(ExamSchedule schedule);
    void deleteObject(int scheduleId);
    boolean objectExists(int examId, int subId, Date examDate);
}
