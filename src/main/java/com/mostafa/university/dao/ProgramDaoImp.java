package com.mostafa.university.dao;

import com.mostafa.university.domain.Program;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ProgramDaoImp implements ProgramDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Program> getAllObject() {
        String hql = "FROM Program as a ORDER BY a.proId";
        return (List<Program>) hibernateTemplate.find(hql);
    }

    @Override
    public Program getObjectById(int proId) {
        return hibernateTemplate.get(Program.class, proId);
    }
    
}
