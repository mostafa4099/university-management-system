package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.AccountType;
import com.mostafa.university.service.AccountTypeServiceInt;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/type")
public class AccountTypeController {
    
    @Autowired
    private AccountTypeServiceInt accountTypeServiceInt;
    
    @RequestMapping(value = "/typelist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity <List<AccountType>> getAllObject(){
        List <AccountType> typeList=accountTypeServiceInt.getAllObject();
        return new ResponseEntity<List<AccountType>>(typeList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/typelist/{id}", method = RequestMethod.GET)
    public ResponseEntity <AccountType> getObjectById(@PathVariable("id") Integer id){
        AccountType type=accountTypeServiceInt.getObjectById(id);
        return new ResponseEntity<AccountType>(type, HttpStatus.OK);
    }
}
