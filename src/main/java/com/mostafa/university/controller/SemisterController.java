package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.Semister;
import com.mostafa.university.service.SemisterServiceInt;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sem")
public class SemisterController {
    
    @Autowired
    private SemisterServiceInt semisterServiceInt;
    
    @RequestMapping(value = "/semlist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity <List<Semister>> getAllObject(){
        List <Semister> semList=semisterServiceInt.getAllObject();
        return new ResponseEntity<List<Semister>>(semList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/semlist/{id}", method = RequestMethod.GET)
    public ResponseEntity <Semister> getObjectById(@PathVariable("id") Integer id){
        Semister sems=semisterServiceInt.getObjectById(id);
        return new ResponseEntity<Semister>(sems, HttpStatus.OK);
    }
}
