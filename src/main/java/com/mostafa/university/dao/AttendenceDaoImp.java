package com.mostafa.university.dao;

import com.mostafa.university.domain.Attendence;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class AttendenceDaoImp implements AttendenceDaoInt {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Attendence> getAllObject() {
        String hql = "FROM Attendence a LEFT JOIN FETCH a.attendenceValue LEFT JOIN FETCH a.classHour LEFT JOIN FETCH a.studentInfo LEFT JOIN FETCH a.studentInfo.department LEFT JOIN FETCH a.studentInfo.program LEFT JOIN FETCH a.studentInfo.semister LEFT JOIN FETCH a.subject LEFT JOIN FETCH a.subject.department LEFT JOIN FETCH a.subject.program LEFT JOIN FETCH a.subject.semister LEFT JOIN FETCH a.teachers LEFT JOIN FETCH a.teachers.empInfo LEFT JOIN FETCH a.teachers.department ORDER BY a.attendId";
        return (List<Attendence>) hibernateTemplate.find(hql);
    }

    @Override
    public Attendence getObjectById(int attendId) {
        return hibernateTemplate.get(Attendence.class, attendId);
    }

    @Override
    public void addObject(Attendence attendence) {
        hibernateTemplate.save(attendence);
    }

    @Override
    public void updateObject(Attendence attendence) {
        Attendence a = getObjectById(attendence.getAttendId());
        a.setAttendenceValue(attendence.getAttendenceValue());
        a.setClassHour(attendence.getClassHour());
        a.setStudentInfo(attendence.getStudentInfo());
        a.setSubject(attendence.getSubject());
        a.setTeachers(attendence.getTeachers());
        a.setAttendDate(attendence.getAttendDate());
        hibernateTemplate.update(a);
    }

    @Override
    public void deleteObject(int attendId) {
        hibernateTemplate.delete(getObjectById(attendId));
    }

    @Override
    public boolean objectExists(int stId, int hourId, Date attendDate) {
        String hql="FROM Attendence as a WHERE a.studentInfo.stId=? and a.classHour.hourId=? and a.attendDate=?";
        List <Attendence> attList=(List <Attendence>) hibernateTemplate.find(hql, stId, hourId, attendDate);
        return attList.size() > 0 ? true:false;
    }

}
