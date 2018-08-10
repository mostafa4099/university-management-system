package com.mostafa.university.dao;

import com.mostafa.university.domain.Semister;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SemisterDaoImp implements SemisterDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Semister> getAllObject() {
        String hql = "FROM Semister as a ORDER BY a.semId";
        return (List<Semister>) hibernateTemplate.find(hql);
    }

    @Override
    public Semister getObjectById(int semId) {
        return hibernateTemplate.get(Semister.class, semId);
    }
    
}
