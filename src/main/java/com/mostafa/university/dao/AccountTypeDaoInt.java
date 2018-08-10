package com.mostafa.university.dao;

import com.mostafa.university.domain.AccountType;
import java.util.List;

public interface AccountTypeDaoInt {
    List<AccountType> getAllObject();
    AccountType getObjectById(int accTypeId);
}
