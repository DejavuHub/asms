package com.asms.dao;

import com.asms.pojo.Dictionary;
import com.asms.pojo.Project;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentDAO {
    int findApplyCount();
    int findMaterialCount(String studentid);
    int findDeadlineCount(Date date);
    int findDesignCount(String studentid);
    List<Dictionary> findProjectTypes();
    List<Dictionary> findProjectStages();
    List<Dictionary> findStudentProjectStatus();
    List<Dictionary> findProjectStatus();
    List<Project> findProjectsByConditions(Map<String,Object> conditions);
    int findProjectCountByConditions(Map<String,Object> conditions);
}
