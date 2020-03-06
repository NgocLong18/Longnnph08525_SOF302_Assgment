package com.sample.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;
    @Column(name = "username")
    private String username;
    @Column(name = "pass")
    private String pass;
    @Column(name = "fullname")
    private String fullname;

    public Users(String username, String pass, String fullname) {
        this.username = username;
        this.pass = pass;
        this.fullname = fullname;
    }

    public Users(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }

    public Users() {
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
