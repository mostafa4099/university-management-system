package com.mostafa.university.dao;

import com.mostafa.university.domain.ClassDay;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ClassDayDaoImp implements ClassDayDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<ClassDay> getAllObject() {
        String hql = "FROM ClassDay as a ORDER BY a.dayId";
        return (List<ClassDay>) hibernateTemplate.find(hql);
    }

    @Override
    public ClassDay getObjectById(int dayId) {
        return hibernateTemplate.get(ClassDay.class, dayId);
    }
    
}
