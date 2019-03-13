package com.asms.controller;

import com.asms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("/studentIndex")
    @ResponseBody
    public Object studentIndex(String studentid){
        Map<String,Object> map=new HashMap<>();
        map.put("apply",studentService.studentIndexApplyCount());
        map.put("material",studentService.studentIndexMeterialCount(studentid));
        map.put("deadline",studentService.studentIndexDeadlineCount());
        map.put("design",studentService.studentIndexDesignCount(studentid));
        return map;
    }
    @RequestMapping("/myProjectConditions")
    @ResponseBody
    public Object myProjectConditions(){
        return studentService.findMyProjectConditions();
    }
    @RequestMapping("/projectConditions")
    @ResponseBody
    public Object projectConditions(){
        return studentService.findProjectConditions();
    }
    @RequestMapping("/searchForProjects")
    @ResponseBody
    public Object searchForProjects(@RequestParam Map<String,Object> conditions){
        return studentService.findProjectsByConditions(conditions);
    }
}
