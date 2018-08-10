package com.mostafa.university.service;

import com.mostafa.university.domain.AttendenceValue;
import java.util.List;

public interface AttendenceValueServiceInt {
    List<AttendenceValue> getAllObject();
    AttendenceValue getObjectById(int attValId);
}
