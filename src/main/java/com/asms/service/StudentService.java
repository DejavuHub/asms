package com.asms.service;

import com.asms.pojo.Project;

import java.util.List;
import java.util.Map;

public interface StudentService {
    int studentIndexApplyCount();
    int studentIndexMeterialCount(String studentid);
    int studentIndexDeadlineCount();
    int studentIndexDesignCount(String studentid);
    Map<String,Object> findMyProjectConditions();
    Map<String,Object> findProjectConditions();
    Map<String,Object> findProjectsByConditions(Map<String,Object> conditions);
}
