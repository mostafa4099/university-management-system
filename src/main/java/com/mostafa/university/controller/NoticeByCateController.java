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
@RequestMapping("/nbc")
public class NoticeByCateController {
    
    @Autowired
    private NoticeDetailsServiceInt noticeDetailsServiceInt;
    
    @RequestMapping("/home")
    public String home(){
        return "home_notice_list";
    }
    
//    @RequestMapping(value = "/nbclist", method = RequestMethod.GET)
//    @JsonIgnore
//    public ResponseEntity<List<NoticeDetails>> getAllObject(){
//        List <NoticeDetails> nList=noticeDetailsServiceInt.getAllObject();
//        return new ResponseEntity<List<NoticeDetails>>(nList, HttpStatus.OK);
//    }
    
    @RequestMapping(value = "/nbclist/{id}", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<NoticeDetails>> getNoticeByCate(@PathVariable("id") Integer id){
        System.out.println(id);
        List <NoticeDetails> nList=noticeDetailsServiceInt.getNoticeByCate(id);
        return new ResponseEntity<List<NoticeDetails>>(nList, HttpStatus.OK);
    }
}
