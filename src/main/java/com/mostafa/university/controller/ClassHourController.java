package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.ClassHour;
import com.mostafa.university.service.ClassHourServiceInt;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hour")
public class ClassHourController {
    
    @Autowired
    private ClassHourServiceInt classHourServiceInt;
    
    @RequestMapping(value = "/hourlist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity <List<ClassHour>> getAllObject(){
        List <ClassHour> hourList=classHourServiceInt.getAllObject();
        return new ResponseEntity<List<ClassHour>>(hourList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/hourlist/{id}", method = RequestMethod.GET)
    public ResponseEntity <ClassHour> getObjectById(@PathVariable("id") Integer id){
        ClassHour hours=classHourServiceInt.getObjectById(id);
        return new ResponseEntity<ClassHour>(hours, HttpStatus.OK);
    }
}
