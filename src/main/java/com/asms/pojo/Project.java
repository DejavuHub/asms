package com.asms.pojo;

import java.util.Date;

public class Project {
    private String id;
    private String projectcode;
    private String projectname;
    private Dictionary typeData;
    private Date starttime;
    private Date endtime;
    private String teacherid;
    private Integer peopleneed;
    private String projectremark;
    private String projectstage;
    private Integer delflag;
    private Date deadline;
    private Dictionary statusData;
    private String applyerid;
    private String remark2;
    private String description;
    private String opinion;
    private String reason;
    private String projecttypename;
    private String projectstagename;
    private String teachername;
    private String mystatusname;
    private String projectstatusname;

    public String getProjecttypename() {
        return projecttypename;
    }

    public void setProjecttypename(String projecttypename) {
        this.projecttypename = projecttypename;
    }

    public String getProjectstagename() {
        return projectstagename;
    }

    public void setProjectstagename(String projectstagename) {
        this.projectstagename = projectstagename;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getMystatusname() {
        return mystatusname;
    }

    public void setMystatusname(String mystatusname) {
        this.mystatusname = mystatusname;
    }

    public String getProjectstatusname() {
        return projectstatusname;
    }

    public void setProjectstatusname(String projectstatusname) {
        this.projectstatusname = projectstatusname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectcode() {
        return projectcode;
    }

    public void setProjectcode(String projectcode) {
        this.projectcode = projectcode;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getPeopleneed() {
        return peopleneed;
    }

    public void setPeopleneed(Integer peopleneed) {
        this.peopleneed = peopleneed;
    }

    public String getProjectremark() {
        return projectremark;
    }

    public void setProjectremark(String projectremark) {
        this.projectremark = projectremark;
    }

    public String getProjectstage() {
        return projectstage;
    }

    public void setProjectstage(String projectstage) {
        this.projectstage = projectstage;
    }

    public Integer getDelflag() {
        return delflag;
    }

    public void setDelflag(Integer delflag) {
        this.delflag = delflag;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Dictionary getTypeData() {
        return typeData;
    }

    public void setTypeData(Dictionary typeData) {
        this.typeData = typeData;
    }

    public Dictionary getStatusData() {
        return statusData;
    }

    public void setStatusData(Dictionary statusData) {
        this.statusData = statusData;
    }

    public String getApplyerid() {
        return applyerid;
    }

    public void setApplyerid(String applyerid) {
        this.applyerid = applyerid;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
