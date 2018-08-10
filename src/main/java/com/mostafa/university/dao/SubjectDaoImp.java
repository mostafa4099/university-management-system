package com.mostafa.university.dao;

import com.mostafa.university.domain.Subject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SubjectDaoImp implements SubjectDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Subject> getAllObject() {
        String hql="FROM Subject s LEFT JOIN FETCH s.department LEFT JOIN FETCH s.program LEFT JOIN FETCH s.semister ORDER BY s.subId";
        return (List<Subject>) hibernateTemplate.find(hql);
    }

    @Override
    public Subject getObjectById(int subId) {
        return hibernateTemplate.get(Subject.class, subId);
    }

    @Override
    public void addObject(Subject subject) {
        hibernateTemplate.save(subject);
    }

    @Override
    public void updateObject(Subject subject) {
        Subject s=getObjectById(subject.getSubId());
        s.setDepartment(subject.getDepartment());
        s.setProgram(subject.getProgram());
        s.setSemister(subject.getSemister());
        s.setSubName(subject.getSubName());;
        hibernateTemplate.update(s);
    }

    @Override
    public void deleteObject(int subId) {
        hibernateTemplate.delete(getObjectById(subId));
    }

    @Override
    public boolean objectExists(int depId, int semId, int proId, String subName) {
        String hql="FROM Subject as s WHERE s.department.depId=? and s.program.proId=? and s.semister.semId=? and s.subName=?";
        List <Subject> subList=(List <Subject>) hibernateTemplate.find(hql, depId, semId, proId, subName);
        return subList.size() > 0 ? true:false;
    }
    
}
