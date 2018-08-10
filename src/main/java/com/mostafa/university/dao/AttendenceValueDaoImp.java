package com.mostafa.university.dao;

import com.mostafa.university.domain.AttendenceValue;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class AttendenceValueDaoImp implements AttendenceValueDaoInt{
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<AttendenceValue> getAllObject() {
        String hql = "FROM AttendenceValue as a ORDER BY a.attValId";
        return (List<AttendenceValue>) hibernateTemplate.find(hql);
    }

    @Override
    public AttendenceValue getObjectById(int attValId) {
        return hibernateTemplate.get(AttendenceValue.class, attValId);
    }
}
