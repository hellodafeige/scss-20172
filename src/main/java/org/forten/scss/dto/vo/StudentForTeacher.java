package org.forten.scss.dto.vo;

public class StudentForTeacher {
    private long id;
    private String name;
    private String gender;
    private String phone;
    private String mailbox;

    public StudentForTeacher() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getIdStr(){
        return this.id+"";
    }

    @Override
    public String toString() {
        return "StudentForTeacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", mailbox='" + mailbox + '\'' +
                '}';
    }
}
