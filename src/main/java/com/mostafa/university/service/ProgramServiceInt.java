package com.mostafa.university.service;

import com.mostafa.university.domain.Program;
import java.util.List;

public interface ProgramServiceInt {
    List<Program> getAllObject();
    Program getObjectById(int proId);
}
