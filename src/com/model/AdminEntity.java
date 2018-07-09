package com.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Admin", schema = "StuDB", catalog = "")
public class AdminEntity {
    private int aid;
    private String aUserName;
    private String aPassword;

    @Id
    @Column(name = "AID", nullable = false)
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Basic
    @Column(name = "AUserName", nullable = false, length = 20)
    public String getaUserName() {
        return aUserName;
    }

    public void setaUserName(String aUserName) {
        this.aUserName = aUserName;
    }

    @Basic
    @Column(name = "APassword", nullable = false, length = 20)
    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminEntity that = (AdminEntity) o;
        return aid == that.aid &&
                Objects.equals(aUserName, that.aUserName) &&
                Objects.equals(aPassword, that.aPassword);
    }

    @Override
    public int hashCode() {

        return Objects.hash(aid, aUserName, aPassword);
    }
}
