package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.Program;
import com.mostafa.university.service.ProgramServiceInt;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/pro")
public class ProgramController {
    
    @Autowired
    private ProgramServiceInt proServiceInt;
    
    @RequestMapping(value = "/prolist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity <List<Program>> getAllObject(){
        List <Program> proList=proServiceInt.getAllObject();
        return new ResponseEntity<List<Program>>(proList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/prolist/{id}", method = RequestMethod.GET)
    public ResponseEntity <Program> getObjectById(@PathVariable("id") Integer id){
        Program pros=proServiceInt.getObjectById(id);
        return new ResponseEntity<Program>(pros, HttpStatus.OK);
    }
}
