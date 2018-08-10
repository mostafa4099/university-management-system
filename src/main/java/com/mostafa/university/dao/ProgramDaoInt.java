package com.mostafa.university.dao;

import com.mostafa.university.domain.Program;
import java.util.List;

public interface ProgramDaoInt {
    List<Program> getAllObject();
    Program getObjectById(int proId);
}
