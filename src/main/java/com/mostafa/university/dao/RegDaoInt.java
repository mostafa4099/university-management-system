package com.mostafa.university.dao;

import com.mostafa.university.domain.Login;
import java.util.List;

public interface RegDaoInt {
    List<Login> getAllObject();
    Login getObjectById(int loginId);
    void addObject(Login login);
    void updateObject(Login login);
    void deleteObject(int loginId);
    boolean objectExists(String uname, String pass);
}
