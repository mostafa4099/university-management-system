package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.EmpInfo;
import com.mostafa.university.service.EmpInfoServiceInt;
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
@RequestMapping("/emp")
public class EmpInfoController {
    
    @Autowired
    private EmpInfoServiceInt empInfoServiceInt;
    
    @RequestMapping("/home")
    public String home(){
        return "empinfo";
    }
    
    @RequestMapping(value = "/emplist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<EmpInfo>> getAllObject(){
        List <EmpInfo> empList=empInfoServiceInt.getAllObject();
        return new ResponseEntity<List<EmpInfo>>(empList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/emplist/{id}", method = RequestMethod.GET)
    public ResponseEntity <EmpInfo> getObjectById(@PathVariable("id") Integer id){
        EmpInfo empInfo=empInfoServiceInt.getObjectById(id);
        return new ResponseEntity<EmpInfo>(empInfo, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/emplist", method = RequestMethod.POST)
    public ResponseEntity <Void> addObject(@RequestBody EmpInfo empInfo, UriComponentsBuilder builder){
        boolean flag=empInfoServiceInt.addObject(empInfo);
        if(flag == false){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(builder.path("/emplist/{id}").buildAndExpand(empInfo.getEmpId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/emplist/{id}", method = RequestMethod.PUT)
    public ResponseEntity <EmpInfo> updateObject(@RequestBody EmpInfo empInfo){
        empInfoServiceInt.updateObject(empInfo);
        return new ResponseEntity<EmpInfo>(empInfo, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/emplist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id){
        empInfoServiceInt.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
