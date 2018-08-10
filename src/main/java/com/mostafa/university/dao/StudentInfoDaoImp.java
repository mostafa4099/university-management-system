package com.mostafa.university.dao;

import com.mostafa.university.domain.StudentInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class StudentInfoDaoImp implements StudentInfoDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<StudentInfo> getAllObject() {
        String hql="FROM StudentInfo s ORDER BY s.stId";
        return (List<StudentInfo>) hibernateTemplate.find(hql);
    }

    @Override
    public StudentInfo getObjectById(int stId) {
        return hibernateTemplate.get(StudentInfo.class, stId);
    }

    @Override
    public void addObject(StudentInfo studentInfo) {
        hibernateTemplate.save(studentInfo);
    }

    @Override
    public void updateObject(StudentInfo studentInfo) {
        StudentInfo s=getObjectById(studentInfo.getStId());
        s.setStName(studentInfo.getStName());
        s.setStFather(studentInfo.getStFather());
        s.setStMother(studentInfo.getStMother());
        s.setStAddress(studentInfo.getStAddress());
        s.setStMobile(studentInfo.getStMobile());
        s.setStEmail(studentInfo.getStEmail());
        s.setStDob(studentInfo.getStDob());
        s.setStPic(studentInfo.getStPic());
        s.setStSession(studentInfo.getStSession());
        s.setStRoll(studentInfo.getStRoll());
        s.setStReg(studentInfo.getStReg());
        s.setAdmissionDate(studentInfo.getAdmissionDate());
        hibernateTemplate.update(s);
    }

    @Override
    public void deleteObject(int stId) {
        hibernateTemplate.delete(getObjectById(stId));
    }

    @Override
    public boolean objectExists(String stName, int stRoll, int stReg) {
        String hql="FROM StudentInfo as s WHERE s.stName=? and s.stRoll=? and s.stReg=?";
        List <StudentInfo> empList=(List <StudentInfo>) hibernateTemplate.find(hql, stName, stRoll, stReg);
        return empList.size() > 0 ? true:false;
    }

    
    
}
