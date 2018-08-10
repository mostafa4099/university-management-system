package com.mostafa.university.dao;

import com.mostafa.university.domain.Grade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class GradeDaoImp implements GradeDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Grade> getAllObject() {
        String hql = "FROM Grade as a ORDER BY a.gradeId";
        return (List<Grade>) hibernateTemplate.find(hql);
    }

    @Override
    public Grade getObjectById(int gradeId) {
        return hibernateTemplate.get(Grade.class, gradeId);
    }
    
}
