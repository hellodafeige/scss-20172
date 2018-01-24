package org.forten.scss.dto.vo;

public class SelectInfoVoForWrite {
    private long studentId;
    private long courseId;
    private String optType;

    public SelectInfoVoForWrite() {
    }

    public SelectInfoVoForWrite(long studentId, long courseId, String optType) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.optType = optType;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType;
    }

    @Override
    public String toString() {
        return "SelectInfoVoForWrite{" +
                "studentId=" + studentId +
                ", courseId=" + courseId +
                ", optType='" + optType + '\'' +
                '}';
    }
}
