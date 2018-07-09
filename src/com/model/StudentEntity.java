package com.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Student", schema = "StuDB", catalog = "")
public class StudentEntity {
    private int sid;
    private String sno;
    private String sName;
    private String sAge;
    private String sSex;
    private String sMajor;

    @Id
    @Column(name = "SID", nullable = false)
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "Sno", nullable = false, length = 10)
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    @Basic
    @Column(name = "SName", nullable = false, length = 10)
    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Basic
    @Column(name = "SAge", nullable = false, length = 5)
    public String getsAge() {
        return sAge;
    }

    public void setsAge(String sAge) {
        this.sAge = sAge;
    }

    @Basic
    @Column(name = "SSex", nullable = false, length = 5)
    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    @Basic
    @Column(name = "SMajor", nullable = false, length = 20)
    public String getsMajor() {
        return sMajor;
    }

    public void setsMajor(String sMajor) {
        this.sMajor = sMajor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return sid == that.sid &&
                Objects.equals(sno, that.sno) &&
                Objects.equals(sName, that.sName) &&
                Objects.equals(sAge, that.sAge) &&
                Objects.equals(sSex, that.sSex) &&
                Objects.equals(sMajor, that.sMajor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sid, sno, sName, sAge, sSex, sMajor);
    }
}
