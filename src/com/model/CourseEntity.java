package com.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Course", schema = "StuDB", catalog = "")
public class CourseEntity {
    private int cid;
    private String cName;
    private String tUserName;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return cid == that.cid &&
                Objects.equals(cName, that.cName) &&
                Objects.equals(tUserName, that.tUserName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cid, cName, tUserName);
    }
}
