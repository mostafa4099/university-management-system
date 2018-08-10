package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.Faculty;
import com.mostafa.university.service.FacultyServiceInt;
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
@RequestMapping("/fac")
public class FacultyController {
    
    @Autowired
    private FacultyServiceInt facultyServiceInt;
    
    @RequestMapping("/home")
    public String home(){
        return "facultyinfo";
    }
    
    @RequestMapping(value = "/faclist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity <List<Faculty>> getAllObject(){
        List <Faculty> facultyList=facultyServiceInt.getAllObject();
        return new ResponseEntity<List<Faculty>>(facultyList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/faclist/{id}", method = RequestMethod.GET)
    public ResponseEntity <Faculty> getObjectById(@PathVariable("id") Integer id){
        Faculty faculty=facultyServiceInt.getObjectById(id);
        return new ResponseEntity<Faculty>(faculty, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/faclist", method = RequestMethod.POST)
    public ResponseEntity <Void> addObject(@RequestBody Faculty faculty, UriComponentsBuilder builder){
        boolean flag=facultyServiceInt.addObject(faculty);
        if(flag == false){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(builder.path("/faclist/{id}").buildAndExpand(faculty.getFacId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/faclist/{id}", method = RequestMethod.PUT)
    public ResponseEntity <Faculty> updateObject(@RequestBody Faculty faculty){
        facultyServiceInt.updateObject(faculty);
        return new ResponseEntity<Faculty>(faculty, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/faclist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id){
        facultyServiceInt.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
