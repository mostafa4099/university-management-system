package com.mostafa.university.dao;

import com.mostafa.university.domain.Routine;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class RoutineDaoImp implements RoutineDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Routine> getAllObject() {
        String hql="FROM Routine r LEFT JOIN FETCH r.classDay LEFT JOIN FETCH r.classHour LEFT JOIN FETCH r.subject LEFT JOIN FETCH r.teachers ORDER BY r.routineId";
        return (List<Routine>) hibernateTemplate.find(hql);
    }

    @Override
    public Routine getObjectById(int routineId) {
        return hibernateTemplate.get(Routine.class, routineId);
    }

    @Override
    public void addObject(Routine routine) {
        hibernateTemplate.save(routine);
    }

    @Override
    public void updateObject(Routine routine) {
        Routine r=getObjectById(routine.getRoutineId());
        r.setClassDay(routine.getClassDay());
        r.setClassHour(routine.getClassHour());
        r.setSubject(routine.getSubject());
        r.setTeachers(routine.getTeachers());
        hibernateTemplate.update(r);
    }

    @Override
    public void deleteObject(int routineId) {
        hibernateTemplate.delete(getObjectById(routineId));
    }

    @Override
    public boolean objectExists(int teacherId, int hourId, int dayId) {
        String hql="FROM Routine as r WHERE r.teachers.teacherId=? and r.classHour.hourId=? and r.classDay.dayId=?";
        List <Routine> routineList=(List <Routine>) hibernateTemplate.find(hql, teacherId, hourId, dayId);
        return routineList.size() > 0 ? true:false;
    }
    
}
