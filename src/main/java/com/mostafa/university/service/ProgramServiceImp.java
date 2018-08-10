package com.mostafa.university.service;

import com.mostafa.university.dao.ProgramDaoInt;
import com.mostafa.university.domain.Program;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramServiceImp implements ProgramServiceInt{
    
    @Autowired
    private ProgramDaoInt programDaoInt;

    @Override
    public List<Program> getAllObject() {
        return programDaoInt.getAllObject();
    }

    @Override
    public Program getObjectById(int proId) {
        return programDaoInt.getObjectById(proId);
    }
    
}
