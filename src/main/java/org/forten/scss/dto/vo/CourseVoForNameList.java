package org.forten.scss.dto.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CourseVoForNameList {
    private long id;
    private String name;
    private String teacher;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date beginTeachTime;
    private int credit;

    public CourseVoForNameList() {
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

    public Date getBeginTeachTime() {
        return beginTeachTime;
    }

    public void setBeginTeachTime(Date beginTeachTime) {
        this.beginTeachTime = beginTeachTime;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "CourseVoForNameList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                ", beginTeachTime=" + beginTeachTime +
                ", credit=" + credit +
                '}';
    }
}
