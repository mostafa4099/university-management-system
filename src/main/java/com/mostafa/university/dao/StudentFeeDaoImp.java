package com.mostafa.university.dao;

import com.mostafa.university.domain.StudentFee;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class StudentFeeDaoImp implements StudentFeeDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<StudentFee> getAllObject() {
        String hql="FROM StudentFee s LEFT JOIN FETCH s.studentInfo ORDER BY s.feeId";
        return (List<StudentFee>) hibernateTemplate.find(hql);
    }

    @Override
    public StudentFee getObjectById(int feeId) {
        return hibernateTemplate.get(StudentFee.class, feeId);
    }

    @Override
    public void addObject(StudentFee fee) {
        StudentFee f=new StudentFee();
        f.setStudentInfo(fee.getStudentInfo());
        f.setApplyFee(fee.getApplyFee());
        f.setRegFee(fee.getRegFee());
        f.setTutionFee(fee.getTutionFee());
        f.setExamFee(fee.getExamFee());
        f.setOthersFee(fee.getOthersFee());
        f.setTotalFee(fee.getApplyFee()+fee.getRegFee()+fee.getTutionFee()+fee.getExamFee()+fee.getOthersFee());
        f.setPayDate(new Date());
        hibernateTemplate.save(f);
    }

    @Override
    public void updateObject(StudentFee fee) {
        StudentFee e=getObjectById(fee.getFeeId());
        e.setStudentInfo(fee.getStudentInfo());
        e.setApplyFee(fee.getApplyFee());
        e.setRegFee(fee.getRegFee());
        e.setTutionFee(fee.getTutionFee());
        e.setExamFee(fee.getExamFee());
        e.setOthersFee(fee.getOthersFee());
        e.setTotalFee(fee.getApplyFee()+fee.getRegFee()+fee.getTutionFee()+fee.getExamFee()+fee.getOthersFee());
        e.setPayDate(fee.getPayDate());
        hibernateTemplate.update(e);
    }

    @Override
    public void deleteObject(int feeId) {
        hibernateTemplate.delete(getObjectById(feeId));
    }

    @Override
    public boolean objectExists(int stId, double applyFee, double regFee, double tutionFee, double examFee, double othersFee) {
        String hql="FROM StudentFee as s WHERE s.studentInfo.stId=? and s.applyFee=? and s.regFee=? and s.tutionFee=? and s.examFee=? and s.othersFee=?";
        List <StudentFee> feeList=(List <StudentFee>) hibernateTemplate.find(hql, stId, applyFee, regFee, tutionFee, examFee, othersFee);
        return feeList.size() > 0 ? true:false;
    }
    
    
}
