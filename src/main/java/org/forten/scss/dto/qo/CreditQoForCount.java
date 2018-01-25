package org.forten.scss.dto.qo;

import java.util.Date;

public class CreditQoForCount {
    private long studentId;
    private Date begin;
    private Date end;

    public CreditQoForCount() {
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
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

    @Override
    public String toString() {
        return "CreditQoForCount{" +
                "studentId=" + studentId +
                ", begin=" + begin +
                ", end=" + end +
                '}';
    }
}
