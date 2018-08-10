package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.Grade;
import com.mostafa.university.service.GradeServiceInt;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/grade")
public class GradeController {
    
    @Autowired
    private GradeServiceInt gradeServiceInt;
    
    @RequestMapping(value = "/gradelist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity <List<Grade>> getAllObject(){
        List <Grade> gradeList=gradeServiceInt.getAllObject();
        return new ResponseEntity<List<Grade>>(gradeList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/gradelist/{id}", method = RequestMethod.GET)
    public ResponseEntity <Grade> getObjectById(@PathVariable("id") Integer id){
        Grade grades=gradeServiceInt.getObjectById(id);
        return new ResponseEntity<Grade>(grades, HttpStatus.OK);
    }
}
