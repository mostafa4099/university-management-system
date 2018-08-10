package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.Login;
import com.mostafa.university.service.RegServiceInt;
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
@RequestMapping("/user")
public class RegController {
    
    @Autowired
    private RegServiceInt regServiceInt;
    
    @RequestMapping("/home")
    public String home(){
        return "registration";
    }
    
    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<Login>> getAllObject(){
        List <Login> userList=regServiceInt.getAllObject();
        return new ResponseEntity<List<Login>>(userList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/userlist/{id}", method = RequestMethod.GET)
    public ResponseEntity <Login> getObjectById(@PathVariable("id") Integer id){
        Login login=regServiceInt.getObjectById(id);
        return new ResponseEntity<Login>(login, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/userlist", method = RequestMethod.POST)
    public ResponseEntity <Void> addObject(@RequestBody Login login, UriComponentsBuilder builder){
        boolean flag=regServiceInt.addObject(login);
        if(flag == false){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(builder.path("/userlist/{id}").buildAndExpand(login.getLoginId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/userlist/{id}", method = RequestMethod.PUT)
    public ResponseEntity <Login> updateObject(@RequestBody Login login){
        regServiceInt.updateObject(login);
        return new ResponseEntity<Login>(login, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/userlist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id){
        regServiceInt.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
