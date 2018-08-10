package com.mostafa.university.service;

import com.mostafa.university.domain.Semister;
import java.util.List;

public interface SemisterServiceInt {
    List<Semister> getAllObject();
    Semister getObjectById(int semId);
}
