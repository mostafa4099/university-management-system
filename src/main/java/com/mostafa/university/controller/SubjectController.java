package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.Subject;
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
@RequestMapping("/sub")
public class SubjectController {
    
    @Autowired
    private SubjectServiceInt subjectServiceInt;
    
    @RequestMapping("/home")
    public String home(){
        return "subjectinfo";
    }
    
    @RequestMapping(value = "/sublist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<Subject>> getAllObject(){
        List <Subject> subList=subjectServiceInt.getAllObject();
        return new ResponseEntity<List<Subject>>(subList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/sublist/{id}", method = RequestMethod.GET)
    public ResponseEntity <Subject> getObjectById(@PathVariable("id") Integer id){
        Subject subject=subjectServiceInt.getObjectById(id);
        return new ResponseEntity<Subject>(subject, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/sublist", method = RequestMethod.POST)
    public ResponseEntity <Void> addObject(@RequestBody Subject subject, UriComponentsBuilder builder){
        boolean flag=subjectServiceInt.addObject(subject);
        if(flag == false){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(builder.path("/sublist/{id}").buildAndExpand(subject.getSubId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/sublist/{id}", method = RequestMethod.PUT)
    public ResponseEntity <Subject> updateObject(@RequestBody Subject subject){
        subjectServiceInt.updateObject(subject);
        return new ResponseEntity<Subject>(subject, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/sublist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id){
        subjectServiceInt.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
