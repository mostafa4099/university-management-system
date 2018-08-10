package com.mostafa.university.service;

import com.mostafa.university.domain.Login;
import java.util.List;

public interface RegServiceInt {
    List<Login> getAllObject();
    Login getObjectById(int loginId);
    boolean addObject(Login login);
    void updateObject(Login login);
    void deleteObject(int loginId);
}
