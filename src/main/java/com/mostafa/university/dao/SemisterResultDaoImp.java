package com.mostafa.university.dao;

import com.mostafa.university.domain.SemisterResult;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SemisterResultDaoImp implements SemisterResultDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<SemisterResult> getAllObject() {
        String hql="FROM SemisterResult s LEFT JOIN FETCH s.department LEFT JOIN FETCH s.grade LEFT JOIN FETCH s.program LEFT JOIN FETCH s.semister LEFT JOIN FETCH s.studentInfo ORDER BY s.semResultId";
        return (List<SemisterResult>) hibernateTemplate.find(hql);
    }

    @Override
    public SemisterResult getObjectById(int semResultId) {
        return hibernateTemplate.get(SemisterResult.class, semResultId);
    }

    @Override
    public void addObject(SemisterResult semResult) {
        hibernateTemplate.save(semResult);
    }

    @Override
    public void updateObject(SemisterResult semResult) {
        SemisterResult s=getObjectById(semResult.getSemResultId());
        s.setDepartment(semResult.getDepartment());
        s.setGrade(semResult.getGrade());
        s.setProgram(semResult.getProgram());
        s.setSemister(semResult.getSemister());
        s.setStudentInfo(semResult.getStudentInfo());
        s.setGpa(semResult.getGpa());
        hibernateTemplate.update(s);
    }

    @Override
    public void deleteObject(int semResultId) {
        hibernateTemplate.delete(getObjectById(semResultId));
    }

    @Override
    public boolean objectExists(int stId, int proId, int semId, double gpa) {
        String hql="FROM SemisterResult as s WHERE s.studentInfo.stId=? and s.program.proId=? and s.gpa=?";
        List <SemisterResult> semResList=(List <SemisterResult>) hibernateTemplate.find(hql, stId, proId, gpa);
        return semResList.size() > 0 ? true:false;
    }
    
    
}
