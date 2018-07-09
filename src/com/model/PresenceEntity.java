package com.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Presence", schema = "StuDB", catalog = "")
public class PresenceEntity {
    private int pid;
    private String tUserName;
    private String sno;
    private int cid;

    @Id
    @Column(name = "PID", nullable = false)
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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
    @Column(name = "Sno", nullable = false, length = 10)
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    @Basic
    @Column(name = "CID", nullable = false)
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PresenceEntity that = (PresenceEntity) o;
        return pid == that.pid &&
                cid == that.cid &&
                Objects.equals(tUserName, that.tUserName) &&
                Objects.equals(sno, that.sno);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pid, tUserName, sno, cid);
    }
}
