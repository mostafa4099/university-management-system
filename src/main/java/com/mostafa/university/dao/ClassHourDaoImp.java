package com.mostafa.university.dao;

import com.mostafa.university.domain.ClassHour;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ClassHourDaoImp implements ClassHourDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<ClassHour> getAllObject() {
        String hql = "FROM ClassHour as a ORDER BY a.hourId";
        return (List<ClassHour>) hibernateTemplate.find(hql);
    }

    @Override
    public ClassHour getObjectById(int hourId) {
        return hibernateTemplate.get(ClassHour.class, hourId);
    }
    
}
