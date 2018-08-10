package com.mostafa.university.service;

import com.mostafa.university.dao.RegDaoInt;
import com.mostafa.university.domain.Login;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegServiceImp implements RegServiceInt{
    
    @Autowired
    private RegDaoInt regDaoInt;

    @Override
    public List<Login> getAllObject() {
        return regDaoInt.getAllObject();
    }

    @Override
    public Login getObjectById(int loginId) {
        return regDaoInt.getObjectById(loginId);
    }

    @Override
    public boolean addObject(Login login) {
        if (regDaoInt.objectExists(login.getUname(), login.getPass())) {
            return false;
        } else {
            regDaoInt.addObject(login);
            return true;
        }
    }

    @Override
    public void updateObject(Login login) {
        regDaoInt.updateObject(login);
    }

    @Override
    public void deleteObject(int loginId) {
        regDaoInt.deleteObject(loginId);
    }
    
}
