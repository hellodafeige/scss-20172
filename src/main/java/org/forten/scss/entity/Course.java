package org.forten.scss.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.forten.utils.system.CurrentTimeKeyBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Course implements Serializable{
      @Id
      private long id;
      @Column
      @NotNull(message = "课程名称不能为空")
      @Size(min = 2,max = 50,message = "课程名称的长度应该在{min}~{max}之间")
      private String name;
      @Column
      @NotBlank(message = "任课讲师不能为空")
      private String teacher;
      @Column
      private String intro;
      @Column(name = "service_teacher")
      private String serviceTeacher;
      @Column(name = "service_teacher_tel")
      private String serviceTeacherTel;
      @Column(name = "begin_teach_time")
      @DateTimeFormat(pattern = "yyyy-MM-dd")
      @JsonFormat(timezone = "GMT+8" , pattern = "yyyy-MM-dd HH:mm")
      private Date beginTeachTime;
      @Column(name = "end_teach_time")
      @DateTimeFormat(pattern = "yyyy-MM-dd")
      @JsonFormat(timezone = "GMT+8" , pattern = "yyyy-MM-dd HH:mm")
      private Date endTeachTime;
      @Column(name = "begin_select_time")
      @DateTimeFormat(pattern = "yyyy-MM-dd")
      @JsonFormat(timezone = "GMT+8" , pattern = "yyyy-MM-dd HH:mm")
      private Date beginSelectTime;
      @Column(name = "end_select_time")
      @DateTimeFormat(pattern = "yyyy-MM-dd")
      @JsonFormat(timezone = "GMT+8" , pattern = "yyyy-MM-dd HH:mm")
      private Date endSelectTime;
      @Column
      private String classroom;
      @Column(name = "max_amount")
      private int maxAmount;
      @Column(name = "current_amount")
      private int currentAmount;
      @Column
      private int credit;
      @Column
      private String status;

    public Course() {
        this.id = CurrentTimeKeyBuilder.getInstance().nextPK();
        this.currentAmount = 0;
        this.status = "AC";
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getIntro() {
        return intro;
    }

    public String getServiceTeacher() {
        return serviceTeacher;
    }

    public String getServiceTeacherTel() {
        return serviceTeacherTel;
    }

    public Date getBeginTeachTime() {
        return beginTeachTime;
    }

    public Date getEndTeachTime() {
        return endTeachTime;
    }

    public Date getBeginSelectTime() {
        return beginSelectTime;
    }

    public Date getEndSelectTime() {
        return endSelectTime;
    }

    public String getClassroom() {
        return classroom;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public int getCredit() {
        return credit;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setServiceTeacher(String serviceTeacher) {
        this.serviceTeacher = serviceTeacher;
    }

    public void setServiceTeacherTel(String serviceTeacherTel) {
        this.serviceTeacherTel = serviceTeacherTel;
    }

    public void setBeginTeachTime(Date beginTeachTime) {
        this.beginTeachTime = beginTeachTime;
    }

    public void setEndTeachTime(Date endTeachTime) {
        this.endTeachTime = endTeachTime;
    }

    public void setBeginSelectTime(Date beginSelectTime) {
        this.beginSelectTime = beginSelectTime;
    }

    public void setEndSelectTime(Date endSelectTime) {
        this.endSelectTime = endSelectTime;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public void setCurrentAmount(int currentAmount) {
        this.currentAmount = currentAmount;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return id == course.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Course{" +
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
