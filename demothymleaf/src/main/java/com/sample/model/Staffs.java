package com.sample.model;

import javax.persistence.*;

@Entity
@Table(name = "staffs")
public class Staffs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long staffId;
    @Column(name = "staffName")
    private String staffName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "birthday")
    private String birthday;
    @Column(name = "photo")
    private String photo;
    @Column(name = "mail")
    private String mail;
    @Column(name = "phone")
    private String phone;
    @Column(name = "salary")
    private String salary;
    @Column(name = "departID")
    private String departID;
    @Column(name = "statusOfStaff")
    private String statusOfStaff;

    public Staffs(String staffName, String gender, String birthday, String photo, String mail, String phone, String salary, String departID, String statusOfStaff) {
        this.staffName = staffName;
        this.gender = gender;
        this.birthday = birthday;
        this.photo = photo;
        this.mail = mail;
        this.phone = phone;
        this.salary = salary;
        this.departID = departID;
        this.statusOfStaff = statusOfStaff;
    }

    public Staffs() {
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDepartID() {
        return departID;
    }

    public void setDepartID(String departID) {
        this.departID = departID;
    }

    public String getStatusOfStaff() {
        return statusOfStaff;
    }

    public void setStatusOfStaff(String statusOfStaff) {
        this.statusOfStaff = statusOfStaff;
    }
}
