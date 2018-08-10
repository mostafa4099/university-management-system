package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.NoticeDetails;
import com.mostafa.university.service.NoticeDetailsServiceInt;
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
@RequestMapping("/notice")
public class NoticeDetailsController {
    
    @Autowired
    private NoticeDetailsServiceInt noticeDetailsServiceInt;
    
    @RequestMapping("/home")
    public String home(){
        return "noticeinfo";
    }
    
    @RequestMapping(value = "/noticelist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<NoticeDetails>> getAllObject(){
        List <NoticeDetails> nList=noticeDetailsServiceInt.getAllObject();
        return new ResponseEntity<List<NoticeDetails>>(nList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/noticelist/{id}", method = RequestMethod.GET)
    public ResponseEntity <NoticeDetails> getObjectById(@PathVariable("id") Integer id){
        NoticeDetails notice=noticeDetailsServiceInt.getObjectById(id);
        return new ResponseEntity<NoticeDetails>(notice, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/noticelist", method = RequestMethod.POST)
    public ResponseEntity <Void> addObject(@RequestBody NoticeDetails notice, UriComponentsBuilder builder){
        boolean flag=noticeDetailsServiceInt.addObject(notice);
        if(flag == false){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(builder.path("/noticelist/{id}").buildAndExpand(notice.getNoticeId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/noticelist/{id}", method = RequestMethod.PUT)
    public ResponseEntity <NoticeDetails> updateObject(@RequestBody NoticeDetails notice){
        noticeDetailsServiceInt.updateObject(notice);
        return new ResponseEntity<NoticeDetails>(notice, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/noticelist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id){
        noticeDetailsServiceInt.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
