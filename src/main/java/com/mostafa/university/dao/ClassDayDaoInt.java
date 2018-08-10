package com.mostafa.university.dao;

import com.mostafa.university.domain.ClassDay;
import java.util.List;

public interface ClassDayDaoInt {
    List<ClassDay> getAllObject();
    ClassDay getObjectById(int dayId);
}
