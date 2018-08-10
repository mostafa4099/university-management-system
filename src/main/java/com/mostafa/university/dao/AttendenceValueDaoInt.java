package com.mostafa.university.dao;

import com.mostafa.university.domain.AccountType;
import com.mostafa.university.domain.AttendenceValue;
import java.util.List;

public interface AttendenceValueDaoInt {
    List<AttendenceValue> getAllObject();
    AttendenceValue getObjectById(int attValId);
}
