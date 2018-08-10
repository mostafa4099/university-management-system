package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.SemisterResult;
import com.mostafa.university.service.SemisterResultServiceInt;
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
@RequestMapping("/semres")
public class SemisterResultController {
    
    @Autowired
    private SemisterResultServiceInt semisterResultServiceInt;
    
    @RequestMapping("/home")
    public String home(){
        return "semisterresult";
    }
    
    @RequestMapping(value = "/semreslist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity <List<SemisterResult>> getAllObject(){
        List <SemisterResult> srList=semisterResultServiceInt.getAllObject();
        return new ResponseEntity<List<SemisterResult>>(srList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/semreslist/{id}", method = RequestMethod.GET)
    public ResponseEntity <SemisterResult> getObjectById(@PathVariable("id") Integer id){
        SemisterResult semResult=semisterResultServiceInt.getObjectById(id);
        return new ResponseEntity<SemisterResult>(semResult, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/semreslist", method = RequestMethod.POST)
    public ResponseEntity <Void> addObject(@RequestBody SemisterResult semResult, UriComponentsBuilder builder){
        boolean flag=semisterResultServiceInt.addObject(semResult);
        if(flag == false){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(builder.path("/semreslist/{id}").buildAndExpand(semResult.getSemResultId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/semreslist/{id}", method = RequestMethod.PUT)
    public ResponseEntity <SemisterResult> updateObject(@RequestBody SemisterResult semResult){
        semisterResultServiceInt.updateObject(semResult);
        return new ResponseEntity<SemisterResult>(semResult, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/semreslist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id){
        semisterResultServiceInt.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
