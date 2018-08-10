package com.mostafa.university.dao;

import com.mostafa.university.domain.AccountType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class AccountTypeDaoImp implements AccountTypeDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<AccountType> getAllObject() {
        String hql = "FROM AccountType as a ORDER BY a.accTypeId";
        return (List<AccountType>) hibernateTemplate.find(hql);
    }

    @Override
    public AccountType getObjectById(int accTypeId) {
        return hibernateTemplate.get(AccountType.class, accTypeId);
    }
    
}
