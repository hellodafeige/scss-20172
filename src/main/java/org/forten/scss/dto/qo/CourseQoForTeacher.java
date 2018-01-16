package org.forten.scss.dto.qo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CourseQoForTeacher {
    private String name;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end;

    private int first;
    private int page;
    private int rows;

    public CourseQoForTeacher() {
        page = 1;
        rows = 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "CourseQoForTeacher{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", begin=" + begin +
                ", end=" + end +
                ", first=" + first +
                ", page=" + page +
                ", rows=" + rows +
                '}';
    }
}
