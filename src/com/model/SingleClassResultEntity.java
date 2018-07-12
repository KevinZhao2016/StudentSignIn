package com.model;

import java.sql.Timestamp;

public class SingleClassResultEntity {
    private StudentEntity student;
    private int State;
    private Timestamp time;

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
