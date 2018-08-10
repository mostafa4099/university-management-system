package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.Attendence;
import com.mostafa.university.service.AttendenceServiceInt;
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
@RequestMapping("/attend")
public class AttendenceController {
    
    @Autowired
    private AttendenceServiceInt attendenceServiceInt;
    
    @RequestMapping("/home")
    public String home(){
        return "attendence";
    }
    
    @RequestMapping(value = "/attendlist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<Attendence>> getAllObject(){
        List <Attendence> attList=attendenceServiceInt.getAllObject();
        return new ResponseEntity<List<Attendence>>(attList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/attendlist/{id}", method = RequestMethod.GET)
    public ResponseEntity <Attendence> getObjectById(@PathVariable("id") Integer id){
        Attendence attendence=attendenceServiceInt.getObjectById(id);
        return new ResponseEntity<Attendence>(attendence, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/attendlist", method = RequestMethod.POST)
    public ResponseEntity <Void> addObject(@RequestBody Attendence attendence, UriComponentsBuilder builder){
        boolean flag=attendenceServiceInt.addObject(attendence);
        if(flag == false){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(builder.path("/attendlist/{id}").buildAndExpand(attendence.getAttendId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/attendlist/{id}", method = RequestMethod.PUT)
    public ResponseEntity <Attendence> updateObject(@RequestBody Attendence attendence){
        attendenceServiceInt.updateObject(attendence);
        return new ResponseEntity<Attendence>(attendence, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/attendlist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id){
        attendenceServiceInt.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
