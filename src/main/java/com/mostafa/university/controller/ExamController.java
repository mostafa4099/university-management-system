package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.Exam;
import com.mostafa.university.service.ExamServiceInt;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/exam")
public class ExamController {
    
    @Autowired
    private ExamServiceInt examServiceInt;
    
    @RequestMapping("/home")
    public String home(){
        return "exam";
    }
    
    @RequestMapping(value = "/examlist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<Exam>> getAllObject(){
        List <Exam> examList=examServiceInt.getAllObject();
        return new ResponseEntity<List<Exam>>(examList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/examlist/{id}", method = RequestMethod.GET)
    public ResponseEntity <Exam> getObjectById(@PathVariable("id") Integer id){
        Exam exam=examServiceInt.getObjectById(id);
        return new ResponseEntity<Exam>(exam, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/examlist", method = RequestMethod.POST)
    public ResponseEntity <Void> addObject(@RequestBody Exam exam, UriComponentsBuilder builder){
        boolean flag=examServiceInt.addObject(exam);
        if(flag == false){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(builder.path("/examlist/{id}").buildAndExpand(exam.getExamId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/examlist/{id}", method = RequestMethod.PUT)
    public ResponseEntity <Exam> updateObject(@RequestBody Exam exam){
        examServiceInt.updateObject(exam);
        return new ResponseEntity<Exam>(exam, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/examlist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id){
        examServiceInt.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
