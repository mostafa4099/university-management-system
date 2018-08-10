package com.mostafa.university.service;

import com.mostafa.university.domain.ClassDay;
import java.util.List;

public interface ClassDayServiceInt {
    List<ClassDay> getAllObject();
    ClassDay getObjectById(int dayId);
}
