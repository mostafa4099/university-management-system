package com.mostafa.university.dao;

import com.mostafa.university.domain.ExamSchedule;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ExamScheduleDaoImp implements ExamScheduleDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<ExamSchedule> getAllObject() {
        String hql="FROM ExamSchedule s LEFT JOIN FETCH s.exam LEFT JOIN FETCH s.subject ORDER BY s.scheduleId";
        return (List<ExamSchedule>) hibernateTemplate.find(hql);
    }

    @Override
    public ExamSchedule getObjectById(int scheduleId) {
        return hibernateTemplate.get(ExamSchedule.class, scheduleId);
    }

    @Override
    public void addObject(ExamSchedule schedule) {
        hibernateTemplate.save(schedule);
    }

    @Override
    public void updateObject(ExamSchedule schedule) {
        ExamSchedule e=getObjectById(schedule.getScheduleId());
        e.setExam(schedule.getExam());
        e.setSubject(schedule.getSubject());
        e.setExamDate(schedule.getExamDate());
        hibernateTemplate.update(e);
    }

    @Override
    public void deleteObject(int scheduleId) {
        hibernateTemplate.delete(getObjectById(scheduleId));
    }

    @Override
    public boolean objectExists(int examId, int subId, Date examDate) {
        String hql="FROM ExamSchedule as s WHERE s.exam.examId=? and s.subject.subId=? and s.examDate=?";
        List <ExamSchedule> scheduleList=(List <ExamSchedule>) hibernateTemplate.find(hql, examId, subId, examDate);
        return scheduleList.size() > 0 ? true:false;
    }
}
