package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.SubjectResult;
import com.mostafa.university.service.SubjectResultServiceInt;
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
@RequestMapping("/subres")
public class SubjectResultController {
    
    @Autowired
    private SubjectResultServiceInt subjectResultServiceInt;
    
    @RequestMapping("/home")
    public String home(){
        return "subjectresult";
    }
    
    @RequestMapping(value = "/subreslist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity <List<SubjectResult>> getAllObject(){
        List <SubjectResult> srList=subjectResultServiceInt.getAllObject();
        return new ResponseEntity<List<SubjectResult>>(srList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/subreslist/{id}", method = RequestMethod.GET)
    public ResponseEntity <SubjectResult> getObjectById(@PathVariable("id") Integer id){
        SubjectResult subResult=subjectResultServiceInt.getObjectById(id);
        return new ResponseEntity<SubjectResult>(subResult, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/subreslist", method = RequestMethod.POST)
    public ResponseEntity <Void> addObject(@RequestBody SubjectResult subResult, UriComponentsBuilder builder){
        boolean flag=subjectResultServiceInt.addObject(subResult);
        if(flag == false){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(builder.path("/subreslist/{id}").buildAndExpand(subResult.getSubResultId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/subreslist/{id}", method = RequestMethod.PUT)
    public ResponseEntity <SubjectResult> updateObject(@RequestBody SubjectResult subResult){
        subjectResultServiceInt.updateObject(subResult);
        return new ResponseEntity<SubjectResult>(subResult, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/subreslist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id){
        subjectResultServiceInt.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
