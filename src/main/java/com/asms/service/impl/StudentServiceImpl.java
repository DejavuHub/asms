package com.asms.service.impl;

import com.asms.dao.StudentDAO;
import com.asms.pojo.Project;
import com.asms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDAO studentDAO;
    @Transactional(readOnly = true)
    public int studentIndexApplyCount(){
        return studentDAO.findApplyCount();
    }
    @Transactional(readOnly = true)
    public int studentIndexMeterialCount(String studentid){
        return studentDAO.findMaterialCount(studentid);
    }
    @Transactional(readOnly = true)
    public int studentIndexDeadlineCount(){
        return studentDAO.findDeadlineCount(new Date());
    }
    @Transactional(readOnly = true)
    public int studentIndexDesignCount(String studentid){
        return studentDAO.findDesignCount(studentid);
    }
    @Transactional(readOnly = true)
    public Map<String,Object> findMyProjectConditions() {
        Map<String,Object> map=new HashMap<>();
        map.put("projectTypes",studentDAO.findProjectTypes());
        map.put("projectStages",studentDAO.findProjectStages());
        map.put("studentProjectStatus",studentDAO.findStudentProjectStatus());
        return map;
    }
    @Transactional(readOnly = true)
    public Map<String,Object> findProjectConditions(){
        Map<String,Object> map=new HashMap<>();
        map.put("projectTypes",studentDAO.findProjectTypes());
        map.put("projectStages",studentDAO.findProjectStages());
        map.put("projectStatus",studentDAO.findProjectStatus());
        return map;
    }
    @Transactional(readOnly = true)
    public Map<String,Object> findProjectsByConditions(Map<String,Object> conditions){
        Map<String,Object> map=new HashMap<>();
        conditions.put("projectname","%"+conditions.get("projectname")+"%");
        int rows=Integer.parseInt((String)conditions.get("rows"));
        int nowpage=Integer.parseInt((String)conditions.get("nowpage"));
        conditions.put("index",(nowpage-1)*rows);
        conditions.put("rows",rows);
        map.put("result",studentDAO.findProjectsByConditions(conditions));
        map.put("resultcount",studentDAO.findProjectCountByConditions(conditions));
        return map;
    }
}
