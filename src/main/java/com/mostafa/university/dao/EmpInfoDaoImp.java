package com.mostafa.university.dao;

import com.mostafa.university.domain.EmpInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class EmpInfoDaoImp implements EmpInfoDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<EmpInfo> getAllObject() {
        String hql="FROM EmpInfo e LEFT JOIN FETCH e.designation ORDER BY e.empId";
        return (List<EmpInfo>) hibernateTemplate.find(hql);
    }

    @Override
    public EmpInfo getObjectById(int empId) {
        return hibernateTemplate.get(EmpInfo.class, empId);
    }

    @Override
    public void addObject(EmpInfo empInfo) {
        hibernateTemplate.save(empInfo);
    }

    @Override
    public void updateObject(EmpInfo empInfo) {
        EmpInfo e=getObjectById(empInfo.getEmpId());
        e.setDesignation(empInfo.getDesignation());
        e.setEmpName(empInfo.getEmpName());
        e.setEmpFather(empInfo.getEmpFather());
        e.setEmpMother(empInfo.getEmpMother());
        e.setEmpAddress(empInfo.getEmpAddress());
        e.setEmpDob(empInfo.getEmpDob());
        e.setEmpMobile(empInfo.getEmpMobile());
        e.setEmpPic(empInfo.getEmpPic());
        e.setJoinDate(empInfo.getJoinDate());
        hibernateTemplate.update(e);
    }

    @Override
    public void deleteObject(int empId) {
        hibernateTemplate.delete(getObjectById(empId));
    }

    @Override
    public boolean objectExists(String empName, String empFather, String empMobile) {
        String hql="FROM EmpInfo as e WHERE e.empName=? and e.empFather=? and e.empMobile=?";
        List <EmpInfo> empList=(List <EmpInfo>) hibernateTemplate.find(hql, empName, empFather, empMobile);
        return empList.size() > 0 ? true:false;
    }
    
}
