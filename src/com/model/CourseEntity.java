package com.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "Course", schema = "StuDB", catalog = "")
public class CourseEntity {
    private int cid;
    private String cName;
    private String tUserName;
    private Time cStart;
    private Time cEnd;
    private int cno;

    @Id
    @Column(name = "CID", nullable = false)
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "CName", nullable = false, length = 20)
    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
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
    @Column(name = "CStart", nullable = false)
    public Time getcStart() {
        return cStart;
    }

    public void setcStart(Time cStart) {
        this.cStart = cStart;
    }

    @Basic
    @Column(name = "CEnd", nullable = false)
    public Time getcEnd() {
        return cEnd;
    }

    public void setcEnd(Time cEnd) {
        this.cEnd = cEnd;
    }

    @Basic
    @Column(name = "Cno", nullable = false)
    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return cid == that.cid &&
                cno == that.cno &&
                Objects.equals(cName, that.cName) &&
                Objects.equals(tUserName, that.tUserName) &&
                Objects.equals(cStart, that.cStart) &&
                Objects.equals(cEnd, that.cEnd);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cid, cName, tUserName, cStart, cEnd, cno);
    }
}
