package com.mostafa.university.dao;

import com.mostafa.university.domain.FinalResult;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class FinalResultDaoImp implements FinalResultDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<FinalResult> getAllObject() {
        String hql="FROM FinalResult s LEFT JOIN FETCH s.department LEFT JOIN FETCH s.grade LEFT JOIN FETCH s.program LEFT JOIN FETCH s.studentInfo ORDER BY s.cgpaId";
        return (List<FinalResult>) hibernateTemplate.find(hql);
    }

    @Override
    public FinalResult getObjectById(int cgpaId) {
        return hibernateTemplate.get(FinalResult.class, cgpaId);
    }

    @Override
    public void addObject(FinalResult finalResult) {
        hibernateTemplate.save(finalResult);
    }

    @Override
    public void updateObject(FinalResult finalResult) {
        FinalResult s=getObjectById(finalResult.getCgpaId());
        s.setDepartment(finalResult.getDepartment());
        s.setGrade(finalResult.getGrade());
        s.setProgram(finalResult.getProgram());
        s.setStudentInfo(finalResult.getStudentInfo());
        s.setCgpa(finalResult.getCgpa());
        hibernateTemplate.update(s);
    }

    @Override
    public void deleteObject(int cgpaId) {
        hibernateTemplate.delete(getObjectById(cgpaId));
    }

    @Override
    public boolean objectExists(int stId, int proId, double cgpa) {
        String hql="FROM FinalResult as s WHERE s.studentInfo.stId=? and s.program.proId=? and s.cgpa=?";
        List <FinalResult> finalResList=(List <FinalResult>) hibernateTemplate.find(hql, stId, proId, cgpa);
        return finalResList.size() > 0 ? true:false;
    }
    
}
