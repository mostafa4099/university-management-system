package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.Routine;
import com.mostafa.university.service.RoutineServiceInt;
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
@RequestMapping("/routine")
public class RoutineController {
    
    @Autowired
    private RoutineServiceInt routineServiceInt;
    
    @RequestMapping("/home")
    public String home(){
        return "routine";
    }
    
    @RequestMapping(value = "/routinelist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<Routine>> getAllObject(){
        List <Routine> routines=routineServiceInt.getAllObject();
        return new ResponseEntity<List<Routine>>(routines, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/routinelist/{id}", method = RequestMethod.GET)
    public ResponseEntity <Routine> getObjectById(@PathVariable("id") Integer id){
        Routine routine=routineServiceInt.getObjectById(id);
        return new ResponseEntity<Routine>(routine, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/routinelist", method = RequestMethod.POST)
    public ResponseEntity <Void> addObject(@RequestBody Routine routine, UriComponentsBuilder builder){
        boolean flag=routineServiceInt.addObject(routine);
        if(flag == false){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(builder.path("/routinelist/{id}").buildAndExpand(routine.getRoutineId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/routinelist/{id}", method = RequestMethod.PUT)
    public ResponseEntity <Routine> updateObject(@RequestBody Routine routine){
        routineServiceInt.updateObject(routine);
        return new ResponseEntity<Routine>(routine, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/routinelist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id){
        routineServiceInt.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
