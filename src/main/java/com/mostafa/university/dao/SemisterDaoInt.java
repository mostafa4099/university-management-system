package com.mostafa.university.dao;

import com.mostafa.university.domain.Semister;
import java.util.List;

public interface SemisterDaoInt {
    List<Semister> getAllObject();
    Semister getObjectById(int semId);
}
