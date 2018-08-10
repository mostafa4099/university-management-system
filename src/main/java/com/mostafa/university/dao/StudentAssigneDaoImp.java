package com.mostafa.university.dao;

import com.mostafa.university.domain.Subject;
import com.mostafa.university.domain.StudentAssigne;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class StudentAssigneDaoImp implements StudentAssigneDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<StudentAssigne> getAllObject() {
        String hql = "FROM StudentAssigne a LEFT JOIN FETCH a.studentInfo LEFT JOIN FETCH a.department LEFT JOIN FETCH a.program LEFT JOIN FETCH a.semister LEFT JOIN FETCH a.subject ORDER BY a.assigneId";
        return (List<StudentAssigne>) hibernateTemplate.find(hql);
    }

    @Override
    public StudentAssigne getObjectById(int assigneId) {
        return hibernateTemplate.get(StudentAssigne.class, assigneId);
    }

    @Override
    public void addObject(StudentAssigne assigne) {
        hibernateTemplate.save(assigne);
    }

    @Override
    public void updateObject(StudentAssigne assigne) {
        StudentAssigne s = getObjectById(assigne.getAssigneId());
        s.setStudentInfo(assigne.getStudentInfo());
        s.setDepartment(assigne.getDepartment());
        s.setProgram(assigne.getProgram());
        s.setSemister(assigne.getSemister());
        s.setSubject(assigne.getSubject());
        hibernateTemplate.update(s);
    }

    @Override
    public void deleteObject(int assigneId) {
        hibernateTemplate.delete(getObjectById(assigneId));
    }

    @Override
    public boolean objectExists(int stId, int depId, int proId, int semId, int subId) {
        String hql="FROM StudentAssigne as a WHERE a.studentInfo.stId=? and a.department.depId=? and a.program.proId=? and a.semister.semId=? and a.subject.subId=?";
        List <StudentAssigne> saList=(List <StudentAssigne>) hibernateTemplate.find(hql, stId, depId, proId, semId, subId);
        return saList.size() > 0 ? true:false;
    }

    
    
}
