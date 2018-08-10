package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.Department;
import com.mostafa.university.service.DepServiceInt;
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
@RequestMapping("/dep")
public class DepController {
    
    @Autowired
    private DepServiceInt depServiceInt;
    
    @RequestMapping("/home")
    public String home(){
        return "depInfo";
    }
    
    @RequestMapping(value = "/deplist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity <List<Department>> getAllObject(){
        List <Department> depList=depServiceInt.getAllObject();
        return new ResponseEntity<List<Department>>(depList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/deplist/{id}", method = RequestMethod.GET)
    public ResponseEntity <Department> getObjectById(@PathVariable("id") Integer id){
        Department department=depServiceInt.getObjectById(id);
        return new ResponseEntity<Department>(department, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/deplist", method = RequestMethod.POST)
    public ResponseEntity <Void> addObject(@RequestBody Department department, UriComponentsBuilder builder){
        boolean flag=depServiceInt.addObject(department);
        if(flag == false){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(builder.path("/deplist/{id}").buildAndExpand(department.getDepId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/deplist/{id}", method = RequestMethod.PUT)
    public ResponseEntity <Department> updateObject(@RequestBody Department department){
        depServiceInt.updateObject(department);
        return new ResponseEntity<Department>(department, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/deplist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id){
        depServiceInt.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
