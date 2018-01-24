package org.forten.scss.dto.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CourseVoForSelect {
    private long id;
    private String name;
    private String teacher;
    private String serviceTeacher;
    private String serviceTeacherTel;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date beginTeachTime;
    private String classroom;
    private int maxAmount;
    private int currentAmount;
    private int credit;
    private String optType;

    public CourseVoForSelect() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getServiceTeacher() {
        return serviceTeacher;
    }

    public void setServiceTeacher(String serviceTeacher) {
        this.serviceTeacher = serviceTeacher;
    }

    public String getServiceTeacherTel() {
        return serviceTeacherTel;
    }

    public void setServiceTeacherTel(String serviceTeacherTel) {
        this.serviceTeacherTel = serviceTeacherTel;
    }

    public Date getBeginTeachTime() {
        return beginTeachTime;
    }

    public void setBeginTeachTime(Date beginTeachTime) {
        this.beginTeachTime = beginTeachTime;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(int currentAmount) {
        this.currentAmount = currentAmount;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType;
    }

    public String getOptTypeDes(){
        if(optType==null){
            return "";
        }
        if(optType.equals("XK")){
            return "选中";
        }else if(optType.equals("PD")){
            return "排队";
        }else{
            return "未知";
        }
    }

    public String getIdStr(){
        return id+"";
    }

    public boolean isOverMax(){
        return currentAmount>=maxAmount;
    }

    @Override
    public String toString() {
        return "CourseVoForSelect{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                ", serviceTeacher='" + serviceTeacher + '\'' +
                ", serviceTeacherTel='" + serviceTeacherTel + '\'' +
                ", beginTeachTime=" + beginTeachTime +
                ", classroom='" + classroom + '\'' +
                ", maxAmount=" + maxAmount +
                ", currentAmount=" + currentAmount +
                ", credit=" + credit +
                '}';
    }
}
