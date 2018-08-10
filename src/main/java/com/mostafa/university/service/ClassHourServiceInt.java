package com.mostafa.university.service;

import com.mostafa.university.domain.ClassHour;
import java.util.List;

public interface ClassHourServiceInt {
    List<ClassHour> getAllObject();
    ClassHour getObjectById(int hourId);
}
