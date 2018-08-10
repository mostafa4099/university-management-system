package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.Designation;
import com.mostafa.university.service.DesignationServiceInt;
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
@RequestMapping("/des")
public class DesignationController {
    
    @Autowired
    private DesignationServiceInt designationServiceInt;
    
    @RequestMapping("/home")
    public String home(){
        return "designationInfo";
    }
    
    @RequestMapping(value = "/deslist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity <List<Designation>> getAllObject(){
        List <Designation> desList=designationServiceInt.getAllObject();
        return new ResponseEntity<List<Designation>>(desList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/deslist/{id}", method = RequestMethod.GET)
    public ResponseEntity <Designation> getObjectById(@PathVariable("id") Integer id){
        Designation designation=designationServiceInt.getObjectById(id);
        return new ResponseEntity<Designation>(designation, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/deslist", method = RequestMethod.POST)
    public ResponseEntity <Void> addObject(@RequestBody Designation designation, UriComponentsBuilder builder){
        boolean flag=designationServiceInt.addObject(designation);
        if(flag == false){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(builder.path("/deslist/{id}").buildAndExpand(designation.getDesigId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/deslist/{id}", method = RequestMethod.PUT)
    public ResponseEntity <Designation> updateObject(@RequestBody Designation designation){
        designationServiceInt.updateObject(designation);
        return new ResponseEntity<Designation>(designation, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/deslist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id){
        designationServiceInt.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
