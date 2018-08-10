package com.mostafa.university.service;

import com.mostafa.university.domain.AccountType;
import java.util.List;

public interface AccountTypeServiceInt {
    List<AccountType> getAllObject();
    AccountType getObjectById(int accTypeId);
}
