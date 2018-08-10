package com.mostafa.university.dao;

import com.mostafa.university.domain.ClassHour;
import java.util.List;

public interface ClassHourDaoInt {
    List<ClassHour> getAllObject();
    ClassHour getObjectById(int hourId);
}
