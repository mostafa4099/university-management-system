package com.mostafa.university.dao;

import com.mostafa.university.domain.Teachers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class TeachersDaoImp implements TeachersDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Teachers> getAllObject() {
        String hql="FROM Teachers t LEFT JOIN FETCH t.department LEFT JOIN FETCH t.empInfo LEFT JOIN FETCH t.empInfo.designation ORDER BY t.teacherId";
        return (List<Teachers>) hibernateTemplate.find(hql);
    }

    @Override
    public Teachers getObjectById(int teacherId) {
        return hibernateTemplate.get(Teachers.class, teacherId);
    }

    @Override
    public void addObject(Teachers teachers) {
        hibernateTemplate.save(teachers);
    }

    @Override
    public void updateObject(Teachers teachers) {
        Teachers t=getObjectById(teachers.getTeacherId());
        t.setDepartment(teachers.getDepartment());
        t.setEmpInfo(teachers.getEmpInfo());
        hibernateTemplate.update(t);
    }

    @Override
    public void deleteObject(int teacherId) {
        hibernateTemplate.delete(getObjectById(teacherId));
    }

    @Override
    public boolean objectExists(int empId) {
        String hql="FROM Teachers as t WHERE t.empInfo.empId=?";
        List <Teachers> teacherList=(List <Teachers>) hibernateTemplate.find(hql, empId);
        return teacherList.size() > 0 ? true:false;
    }
    
    
}
