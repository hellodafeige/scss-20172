package org.forten.scss.dto.qo;

public class StudentQoForTeacher {
    private String name;
    private String gender;

    private int first;
    private int page;
    private int rows;

    public StudentQoForTeacher() {
        page = 1;
        rows = 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        return "StudentQoForTeacher{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", first=" + first +
                ", page=" + page +
                ", rows=" + rows +
                '}';
    }
}
