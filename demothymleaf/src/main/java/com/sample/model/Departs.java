package com.sample.model;

import javax.persistence.*;

@Entity
@Table(name = "departs")
public class Departs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departID;
    @Column(name = "departName")
    private String departName;

    public Departs(String departName) {
        this.departName = departName;
    }

    public Departs() {
    }

    public Long getDepartID() {
        return departID;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartID(Long departID) {
        this.departID = departID;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    @Override
    public String toString() {
        return "Departs{" +
                "departID=" + departID +
                ", departName='" + departName + '\'' +
                '}';
    }
}
