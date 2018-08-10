package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.ClassDay;
import com.mostafa.university.service.ClassDayServiceInt;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/day")
public class ClassDayController {
    
    @Autowired
    private ClassDayServiceInt classDayServiceInt;
    
    @RequestMapping(value = "/daylist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity <List<ClassDay>> getAllObject(){
        List <ClassDay> dayList=classDayServiceInt.getAllObject();
        return new ResponseEntity<List<ClassDay>>(dayList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/daylist/{id}", method = RequestMethod.GET)
    public ResponseEntity <ClassDay> getObjectById(@PathVariable("id") Integer id){
        ClassDay days=classDayServiceInt.getObjectById(id);
        return new ResponseEntity<ClassDay>(days, HttpStatus.OK);
    }
}
