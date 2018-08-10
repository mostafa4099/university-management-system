package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.StudentInfo;
import com.mostafa.university.service.StudentInfoServiceInt;
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
@RequestMapping("/student")
public class StudentInfoController {
    
    @Autowired
    private StudentInfoServiceInt studentInfoServiceInt;
    
    @RequestMapping("/home")
    public String home(){
        return "studentinfo";
    }
    
    @RequestMapping(value = "/studentlist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<StudentInfo>> getAllObject(){
        List <StudentInfo> stList=studentInfoServiceInt.getAllObject();
        return new ResponseEntity<List<StudentInfo>>(stList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/studentlist/{id}", method = RequestMethod.GET)
    public ResponseEntity <StudentInfo> getObjectById(@PathVariable("id") Integer id){
        StudentInfo student=studentInfoServiceInt.getObjectById(id);
        return new ResponseEntity<StudentInfo>(student, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/studentlist", method = RequestMethod.POST)
    public ResponseEntity <Void> addObject(@RequestBody StudentInfo student, UriComponentsBuilder builder){
        boolean flag=studentInfoServiceInt.addObject(student);
        if(flag == false){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(builder.path("/studentlist/{id}").buildAndExpand(student.getStId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/studentlist/{id}", method = RequestMethod.PUT)
    public ResponseEntity <StudentInfo> updateObject(@RequestBody StudentInfo student){
        studentInfoServiceInt.updateObject(student);
        return new ResponseEntity<StudentInfo>(student, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/studentlist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id){
        studentInfoServiceInt.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
