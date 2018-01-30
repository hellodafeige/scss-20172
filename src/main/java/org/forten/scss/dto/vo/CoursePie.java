package org.forten.scss.dto.vo;

import java.util.HashSet;
import java.util.Set;

public class CoursePie {
    private String courseName;
    private Set<ScInfoPie> scInfoSet;

    public CoursePie() {
        scInfoSet = new HashSet<>();
    }

    public CoursePie(String courseName, Set<ScInfoPie> scInfoSet) {
        this.courseName = courseName;
        this.scInfoSet = scInfoSet;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Set<ScInfoPie> getScInfoSet() {
        return scInfoSet;
    }

    public void setScInfoSet(Set<ScInfoPie> scInfoSet) {
        this.scInfoSet = scInfoSet;
    }

    @Override
    public String toString() {
        return "CoursePie{" +
                "courseName='" + courseName + '\'' +
                ", scInfoSet=" + scInfoSet +
                '}';
    }
}
