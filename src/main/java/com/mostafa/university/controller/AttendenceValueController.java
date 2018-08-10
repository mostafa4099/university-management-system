package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.AttendenceValue;
import com.mostafa.university.service.AttendenceValueServiceInt;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/value")
public class AttendenceValueController {
    
    @Autowired
    private AttendenceValueServiceInt attendenceValueServiceInt;
    
    @RequestMapping(value = "/valuelist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity <List<AttendenceValue>> getAllObject(){
        List <AttendenceValue> valueList=attendenceValueServiceInt.getAllObject();
        return new ResponseEntity<List<AttendenceValue>>(valueList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/valuelist/{id}", method = RequestMethod.GET)
    public ResponseEntity <AttendenceValue> getObjectById(@PathVariable("id") Integer id){
        AttendenceValue type=attendenceValueServiceInt.getObjectById(id);
        return new ResponseEntity<AttendenceValue>(type, HttpStatus.OK);
    }
}
