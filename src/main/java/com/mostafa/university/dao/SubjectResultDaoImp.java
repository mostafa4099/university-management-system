package com.mostafa.university.dao;

import com.mostafa.university.domain.SubjectResult;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SubjectResultDaoImp implements SubjectResultDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<SubjectResult> getAllObject() {
        String hql="FROM SubjectResult s LEFT JOIN FETCH s.grade LEFT JOIN FETCH s.studentInfo LEFT JOIN FETCH s.subject ORDER BY s.subResultId";
        return (List<SubjectResult>) hibernateTemplate.find(hql);
    }

    @Override
    public SubjectResult getObjectById(int subResultId) {
        return hibernateTemplate.get(SubjectResult.class, subResultId);
    }

    @Override
    public void addObject(SubjectResult subResult) {
        hibernateTemplate.save(subResult);
    }

    @Override
    public void updateObject(SubjectResult subResult) {
        SubjectResult s=getObjectById(subResult.getSubResultId());
        s.setGrade(subResult.getGrade());
        s.setStudentInfo(subResult.getStudentInfo());
        s.setSubject(subResult.getSubject());
        s.setMarks(subResult.getMarks());
        s.setMarkObtaine(subResult.getMarkObtaine());
        s.setGpa(subResult.getGpa());
        hibernateTemplate.update(s);
    }

    @Override
    public void deleteObject(int subResultId) {
        hibernateTemplate.delete(getObjectById(subResultId));
    }

    @Override
    public boolean objectExists(int stId, int subId, double gpa) {
        String hql="FROM SubjectResult as s WHERE s.studentInfo.stId=? and s.subject.subId=? and s.gpa=?";
        List <SubjectResult> subResList=(List <SubjectResult>) hibernateTemplate.find(hql, stId, subId, gpa);
        return subResList.size() > 0 ? true:false;
    }
    
}
