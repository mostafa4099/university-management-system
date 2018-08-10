package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.StudentFee;
import com.mostafa.university.service.StudentFeeServiceInt;
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
@RequestMapping("/fee")
public class StudentFeeController {
    
    @Autowired
    private StudentFeeServiceInt feeServiceInt;
    
    @RequestMapping("/home")
    public String home(){
        return "studentfee";
    }
    
    @RequestMapping(value = "/feelist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<StudentFee>> getAllObject(){
        List <StudentFee> feeList=feeServiceInt.getAllObject();
        return new ResponseEntity<List<StudentFee>>(feeList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/feelist/{id}", method = RequestMethod.GET)
    public ResponseEntity <StudentFee> getObjectById(@PathVariable("id") Integer id){
        StudentFee fee=feeServiceInt.getObjectById(id);
        return new ResponseEntity<StudentFee>(fee, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/feelist", method = RequestMethod.POST)
    public ResponseEntity <Void> addObject(@RequestBody StudentFee fee, UriComponentsBuilder builder){
        boolean flag=feeServiceInt.addObject(fee);
        if(flag == false){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(builder.path("/feelist/{id}").buildAndExpand(fee.getFeeId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/feelist/{id}", method = RequestMethod.PUT)
    public ResponseEntity <StudentFee> updateObject(@RequestBody StudentFee fee){
        feeServiceInt.updateObject(fee);
        return new ResponseEntity<StudentFee>(fee, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/feelist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id){
        feeServiceInt.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
