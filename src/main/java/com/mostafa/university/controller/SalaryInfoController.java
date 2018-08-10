package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.SalaryInfo;
import com.mostafa.university.domain.Subject;
import com.mostafa.university.service.SalaryInfoServiceInt;
import com.mostafa.university.service.SubjectServiceInt;
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
@RequestMapping("/salary")
public class SalaryInfoController {
    
    @Autowired
    private SalaryInfoServiceInt salaryInfoServiceInt;
    
    @RequestMapping("/home")
    public String home(){
        return "salaryinfo";
    }
    
    @RequestMapping(value = "/salarylist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<SalaryInfo>> getAllObject(){
        List <SalaryInfo> salList=salaryInfoServiceInt.getAllObject();
        return new ResponseEntity<List<SalaryInfo>>(salList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/salarylist/{id}", method = RequestMethod.GET)
    public ResponseEntity <SalaryInfo> getObjectById(@PathVariable("id") Integer id){
        SalaryInfo salary=salaryInfoServiceInt.getObjectById(id);
        return new ResponseEntity<SalaryInfo>(salary, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/salarylist", method = RequestMethod.POST)
    public ResponseEntity <Void> addObject(@RequestBody SalaryInfo salary, UriComponentsBuilder builder){
        boolean flag=salaryInfoServiceInt.addObject(salary);
        if(flag == false){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(builder.path("/salarylist/{id}").buildAndExpand(salary.getSalaryId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/salarylist/{id}", method = RequestMethod.PUT)
    public ResponseEntity <SalaryInfo> updateObject(@RequestBody SalaryInfo salary){
        salaryInfoServiceInt.updateObject(salary);
        return new ResponseEntity<SalaryInfo>(salary, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/salarylist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id){
        salaryInfoServiceInt.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
