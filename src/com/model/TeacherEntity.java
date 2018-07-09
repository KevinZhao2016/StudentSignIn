package com.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Teacher", schema = "StuDB", catalog = "")
public class TeacherEntity {
    private int tid;
    private String tUserName;
    private String tName;
    private String tPassword;
    private String ttell;

    @Id
    @Column(name = "TID", nullable = false)
    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Basic
    @Column(name = "TUserName", nullable = false, length = 20)
    public String gettUserName() {
        return tUserName;
    }

    public void settUserName(String tUserName) {
        this.tUserName = tUserName;
    }

    @Basic
    @Column(name = "TName", nullable = false, length = 10)
    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    @Basic
    @Column(name = "TPassword", nullable = false, length = 20)
    public String gettPassword() {
        return tPassword;
    }

    public void settPassword(String tPassword) {
        this.tPassword = tPassword;
    }

    @Basic
    @Column(name = "Ttell", nullable = false, length = 20)
    public String getTtell() {
        return ttell;
    }

    public void setTtell(String ttell) {
        this.ttell = ttell;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherEntity that = (TeacherEntity) o;
        return tid == that.tid &&
                Objects.equals(tUserName, that.tUserName) &&
                Objects.equals(tName, that.tName) &&
                Objects.equals(tPassword, that.tPassword) &&
                Objects.equals(ttell, that.ttell);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tid, tUserName, tName, tPassword, ttell);
    }
}
