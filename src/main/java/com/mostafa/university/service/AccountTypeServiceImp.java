package com.mostafa.university.service;

import com.mostafa.university.dao.AccountTypeDaoInt;
import com.mostafa.university.domain.AccountType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountTypeServiceImp implements AccountTypeServiceInt{
    
    @Autowired
    private AccountTypeDaoInt accountTypeDaoInt;

    @Override
    public List<AccountType> getAllObject() {
        return accountTypeDaoInt.getAllObject();
    }

    @Override
    public AccountType getObjectById(int accTypeId) {
        return accountTypeDaoInt.getObjectById(accTypeId);
    }
    
}
