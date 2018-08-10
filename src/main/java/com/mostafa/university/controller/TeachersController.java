package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.Teachers;
import com.mostafa.university.service.TeachersServiceInt;
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
@RequestMapping("/teacher")
public class TeachersController {
    
    @Autowired
    private TeachersServiceInt teachersServiceInt;
    
    @RequestMapping("/home")
    public String home(){
        return "teachers";
    }
    
    @RequestMapping(value = "/teacherlist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<Teachers>> getAllObject(){
        List <Teachers> teacherList=teachersServiceInt.getAllObject();
        return new ResponseEntity<List<Teachers>>(teacherList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/teacherlist/{id}", method = RequestMethod.GET)
    public ResponseEntity <Teachers> getObjectById(@PathVariable("id") Integer id){
        Teachers teachers=teachersServiceInt.getObjectById(id);
        return new ResponseEntity<Teachers>(teachers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/teacherlist", method = RequestMethod.POST)
    public ResponseEntity <Void> addObject(@RequestBody Teachers teachers, UriComponentsBuilder builder){
        boolean flag=teachersServiceInt.addObject(teachers);
        if(flag == false){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(builder.path("/teacherlist/{id}").buildAndExpand(teachers.getTeacherId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/teacherlist/{id}", method = RequestMethod.PUT)
    public ResponseEntity <Teachers> updateObject(@RequestBody Teachers teachers){
        teachersServiceInt.updateObject(teachers);
        return new ResponseEntity<Teachers>(teachers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/teacherlist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id){
        teachersServiceInt.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
