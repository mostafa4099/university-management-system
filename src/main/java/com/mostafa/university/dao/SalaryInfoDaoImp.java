package com.mostafa.university.dao;

import com.mostafa.university.domain.SalaryInfo;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SalaryInfoDaoImp implements SalaryInfoDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<SalaryInfo> getAllObject() {
        String hql="FROM SalaryInfo s LEFT JOIN FETCH s.empInfo ORDER BY s.salaryId";
        return (List<SalaryInfo>) hibernateTemplate.find(hql);
    }

    @Override
    public SalaryInfo getObjectById(int salaryId) {
        return hibernateTemplate.get(SalaryInfo.class, salaryId);
    }

    @Override
    public void addObject(SalaryInfo salary) {
        SalaryInfo s=new SalaryInfo();
        double basicSal=salary.getBasic();
        double houseSal=(basicSal*0.20);
        double healthSal=(basicSal*0.10);
        double transportSal=(basicSal*0.05);
        Double festivalSal=salary.getFestival();
        Double othersSal=salary.getOthers();
        double totalSal;
        if (festivalSal==null & othersSal==null) {
            totalSal=basicSal+houseSal+healthSal+transportSal;
        } else if(festivalSal==null) {
            totalSal=basicSal+houseSal+healthSal+transportSal+othersSal;
        } else if(othersSal==null) {
            totalSal=basicSal+houseSal+healthSal+transportSal+festivalSal;
        } else {
            totalSal=basicSal+houseSal+healthSal+transportSal+festivalSal+othersSal;
        }
        Date payMonth= salary.getPaymentMonth();
        Date paymentDate= new Date();
        s.setEmpInfo(salary.getEmpInfo());
        s.setBasic(basicSal);
        s.setHouse(houseSal);
        s.setHelth(healthSal);
        s.setTransport(transportSal);
        s.setFestival(festivalSal);
        s.setOthers(othersSal);
        s.setTotal(totalSal);
        s.setPaymentMonth(payMonth);
        s.setPayDate(paymentDate);
        hibernateTemplate.save(s);
    }

    @Override
    public void updateObject(SalaryInfo salary) {
        SalaryInfo s=getObjectById(salary.getSalaryId());
        double basicSal=salary.getBasic();
        double houseSal=(basicSal*0.20);
        double healthSal=(basicSal*0.10);
        double transportSal=(basicSal*0.05);
        Double festivalSal=salary.getFestival();
        Double othersSal=salary.getOthers();
        double totalSal;
        if (festivalSal==null & othersSal==null) {
            totalSal=basicSal+houseSal+healthSal+transportSal;
        } else if(festivalSal==null) {
            totalSal=basicSal+houseSal+healthSal+transportSal+othersSal;
        } else if(othersSal==null) {
            totalSal=basicSal+houseSal+healthSal+transportSal+festivalSal;
        } else {
            totalSal=basicSal+houseSal+healthSal+transportSal+festivalSal+othersSal;
        }
        s.setEmpInfo(salary.getEmpInfo());
        s.setBasic(basicSal);
        s.setHouse(houseSal);
        s.setHelth(healthSal);
        s.setTransport(transportSal);
        s.setFestival(festivalSal);
        s.setOthers(othersSal);
        s.setTotal(totalSal);
        s.setPaymentMonth(salary.getPaymentMonth());
        s.setPayDate(salary.getPayDate());
        hibernateTemplate.update(s);
    }

    @Override
    public void deleteObject(int salaryId) {
        hibernateTemplate.delete(getObjectById(salaryId));
    }

    @Override
    public boolean objectExists(int empId, Date paymentMonth) {
        String hql="FROM SalaryInfo as s WHERE s.empInfo.empId=? and s.paymentMonth=?";
        List <SalaryInfo> salList=(List <SalaryInfo>) hibernateTemplate.find(hql, empId, paymentMonth);
        return salList.size() > 0 ? true:false;
    }
    
}
