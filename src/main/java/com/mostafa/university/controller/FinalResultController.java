package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.FinalResult;
import com.mostafa.university.service.FinalResultServiceInt;
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
@RequestMapping("/finalres")
public class FinalResultController {
    
    @Autowired
    private FinalResultServiceInt finalResultServiceInt;
    
    @RequestMapping("/home")
    public String home(){
        return "finalresult";
    }
    
    @RequestMapping(value = "/finalreslist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity <List<FinalResult>> getAllObject(){
        List <FinalResult> frList=finalResultServiceInt.getAllObject();
        return new ResponseEntity<List<FinalResult>>(frList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/finalreslist/{id}", method = RequestMethod.GET)
    public ResponseEntity <FinalResult> getObjectById(@PathVariable("id") Integer id){
        FinalResult finalResult=finalResultServiceInt.getObjectById(id);
        return new ResponseEntity<FinalResult>(finalResult, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/finalreslist", method = RequestMethod.POST)
    public ResponseEntity <Void> addObject(@RequestBody FinalResult finalResult, UriComponentsBuilder builder){
        boolean flag=finalResultServiceInt.addObject(finalResult);
        if(flag == false){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(builder.path("/finalreslist/{id}").buildAndExpand(finalResult.getCgpaId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/finalreslist/{id}", method = RequestMethod.PUT)
    public ResponseEntity <FinalResult> updateObject(@RequestBody FinalResult finalResult){
        finalResultServiceInt.updateObject(finalResult);
        return new ResponseEntity<FinalResult>(finalResult, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/finalreslist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id){
        finalResultServiceInt.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
