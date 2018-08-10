package com.mostafa.university.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mostafa.university.domain.ExamSchedule;
import com.mostafa.university.service.ExamScheduleServiceInt;
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
@RequestMapping("/schedule")
public class ExamScheduleController {
    
    @Autowired
    private ExamScheduleServiceInt scheduleServiceInt;
    
    @RequestMapping("/home")
    public String home(){
        return "exam_schedule";
    }
    
    @RequestMapping(value = "/schedulelist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<ExamSchedule>> getAllObject(){
        List <ExamSchedule> scheduleList=scheduleServiceInt.getAllObject();
        return new ResponseEntity<List<ExamSchedule>>(scheduleList, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/schedulelist/{id}", method = RequestMethod.GET)
    public ResponseEntity <ExamSchedule> getObjectById(@PathVariable("id") Integer id){
        ExamSchedule schedule=scheduleServiceInt.getObjectById(id);
        return new ResponseEntity<ExamSchedule>(schedule, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/schedulelist", method = RequestMethod.POST)
    public ResponseEntity <Void> addObject(@RequestBody ExamSchedule schedule, UriComponentsBuilder builder){
        boolean flag=scheduleServiceInt.addObject(schedule);
        if(flag == false){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(builder.path("/schedulelist/{id}").buildAndExpand(schedule.getScheduleId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/schedulelist/{id}", method = RequestMethod.PUT)
    public ResponseEntity <ExamSchedule> updateObject(@RequestBody ExamSchedule schedule){
        scheduleServiceInt.updateObject(schedule);
        return new ResponseEntity<ExamSchedule>(schedule, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/schedulelist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id){
        scheduleServiceInt.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
