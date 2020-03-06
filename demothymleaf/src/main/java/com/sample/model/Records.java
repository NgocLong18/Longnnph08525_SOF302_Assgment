package com.sample.model;

import javax.persistence.*;

@Entity
@Table(name = "records")
public class Records {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recordId;
    @Column(name = "typeRecords")
    private String typeRecords;
    @Column(name = "reason")
    private String reason;
    @Column(name = "dates")
    private String dates;
    @Column(name = "staffID")
    private String staffID;


    public Records(String typeRecords, String reason, String dates, String staffID) {
        this.typeRecords = typeRecords;
        this.reason = reason;
        this.dates = dates;
        this.staffID = staffID;
    }

    public Records() {
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getTypeRecords() {
        return typeRecords;
    }

    public void setTypeRecords(String typeRecords) {
        this.typeRecords = typeRecords;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }
}
