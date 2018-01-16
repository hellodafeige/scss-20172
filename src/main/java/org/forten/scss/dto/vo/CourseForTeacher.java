package org.forten.scss.dto.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.forten.utils.common.DateUtil;

import java.util.Date;

public class CourseForTeacher {
    private long id;
    private String name;
    private String teacher;
    private String intro;
    private String serviceTeacher;
    private String serviceTeacherTel;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date beginTeachTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date endTeachTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date beginSelectTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date endSelectTime;
    private String classroom;
    private int maxAmount;
    private int currentAmount;
    private int credit;
    private String status;

    public CourseForTeacher() {
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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
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

    public Date getEndTeachTime() {
        return endTeachTime;
    }

    public void setEndTeachTime(Date endTeachTime) {
        this.endTeachTime = endTeachTime;
    }

    public Date getBeginSelectTime() {
        return beginSelectTime;
    }

    public void setBeginSelectTime(Date beginSelectTime) {
        this.beginSelectTime = beginSelectTime;
    }

    public Date getEndSelectTime() {
        return endSelectTime;
    }

    public void setEndSelectTime(Date endSelectTime) {
        this.endSelectTime = endSelectTime;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdStr(){
        return this.id+"";
    }
    public String getBeginTeachTimeStr(){
        if(this.beginTeachTime==null){
            return "";
        }else{
            return DateUtil.convertDateToString(beginTeachTime,"yyyy-MM-dd HH:mm");
        }
    }

    public String getEndTeachTimeStr(){
        if(this.endTeachTime==null){
            return "";
        }else{
            return DateUtil.convertDateToString(endTeachTime,"yyyy-MM-dd HH:mm");
        }
    }

    public String getBeginSelectTimeStr(){
        if(this.beginSelectTime==null){
            return "";
        }else{
            return DateUtil.convertDateToString(beginSelectTime,"yyyy-MM-dd HH:mm");
        }
    }

    public String getEndSelectTimeStr(){
        if(this.endSelectTime==null){
            return "";
        }else{
            return DateUtil.convertDateToString(endSelectTime,"yyyy-MM-dd HH:mm");
        }
    }
    @Override
    public String toString() {
        return "CourseForTeacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                ", intro='" + intro + '\'' +
                ", serviceTeacher='" + serviceTeacher + '\'' +
                ", serviceTeacherTel='" + serviceTeacherTel + '\'' +
                ", beginTeachTime=" + beginTeachTime +
                ", endTeachTime=" + endTeachTime +
                ", beginSelectTime=" + beginSelectTime +
                ", endSelectTime=" + endSelectTime +
                ", classroom='" + classroom + '\'' +
                ", maxAmount=" + maxAmount +
                ", currentAmount=" + currentAmount +
                ", credit=" + credit +
                ", status='" + status + '\'' +
                '}';
    }
}
