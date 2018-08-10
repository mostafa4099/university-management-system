package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.StudentAssigne;
import com.mostafa.university.service.StudentAssigneServiceInt;
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
@RequestMapping("/assigne")
public class StudentAssigneController {
    
    @Autowired
    private StudentAssigneServiceInt assigneServiceInt;
    
    @RequestMapping("/home")
    public String home(){
        return "studentassigne";
    }
    
    @RequestMapping(value = "/assignelist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<StudentAssigne>> getAllObject(){
        List <StudentAssigne> saList=assigneServiceInt.getAllObject();
        return new ResponseEntity<List<StudentAssigne>>(saList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/assignelist/{id}", method = RequestMethod.GET)
    public ResponseEntity <StudentAssigne> getObjectById(@PathVariable("id") Integer id){
        StudentAssigne assigne=assigneServiceInt.getObjectById(id);
        return new ResponseEntity<StudentAssigne>(assigne, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/assignelist", method = RequestMethod.POST)
    public ResponseEntity <Void> addObject(@RequestBody StudentAssigne assigne, UriComponentsBuilder builder){
        boolean flag=assigneServiceInt.addObject(assigne);
        if(flag == false){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(builder.path("/assignelist/{id}").buildAndExpand(assigne.getAssigneId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/assignelist/{id}", method = RequestMethod.PUT)
    public ResponseEntity <StudentAssigne> updateObject(@RequestBody StudentAssigne assigne){
        assigneServiceInt.updateObject(assigne);
        return new ResponseEntity<StudentAssigne>(assigne, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/assignelist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id){
        assigneServiceInt.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
