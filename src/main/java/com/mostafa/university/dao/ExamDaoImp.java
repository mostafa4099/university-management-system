package com.mostafa.university.dao;

import com.mostafa.university.domain.Exam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ExamDaoImp implements ExamDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Exam> getAllObject() {
        String hql="FROM Exam s LEFT JOIN FETCH s.department LEFT JOIN FETCH s.program LEFT JOIN FETCH s.semister ORDER BY s.examId";
        return (List<Exam>) hibernateTemplate.find(hql);
    }

    @Override
    public Exam getObjectById(int examId) {
        return hibernateTemplate.get(Exam.class, examId);
    }

    @Override
    public void addObject(Exam exam) {
        hibernateTemplate.save(exam);
    }

    @Override
    public void updateObject(Exam exam) {
        Exam e=getObjectById(exam.getExamId());
        e.setDepartment(exam.getDepartment());
        e.setProgram(exam.getProgram());
        e.setSemister(exam.getSemister());
        e.setExamName(exam.getExamName());
        hibernateTemplate.update(e);
    }

    @Override
    public void deleteObject(int examId) {
        hibernateTemplate.delete(getObjectById(examId));
    }

    @Override
    public boolean objectExists(int depId, int proId, String examName) {
        String hql="FROM Exam as s WHERE s.department.depId=? and s.program.proId=? and s.examName=?";
        List <Exam> examList=(List <Exam>) hibernateTemplate.find(hql, depId, proId, examName);
        return examList.size() > 0 ? true:false;
    }
    
    
}
