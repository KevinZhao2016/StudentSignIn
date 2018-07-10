package com.action;

import com.model.StudentEntity;
import com.server.StudentRegistServer;
import com.server.impl.StudentRegistServerImpl;

public class StudentRegistAction {
    private String sno;
    private String sName;
    private String sAge;
    private String sSex;
    private String sMajor;
    private String token;
    private String face;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsAge() {
        return sAge;
    }

    public void setsAge(String sAge) {
        this.sAge = sAge;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public String getsMajor() {
        return sMajor;
    }

    public void setsMajor(String sMajor) {
        this.sMajor = sMajor;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String execute() throws Exception {
        StudentRegistServer studentRegistServer = new StudentRegistServerImpl();
        StudentEntity studentEntity= new StudentEntity();
        studentEntity.setsAge(this.getsAge());
        studentEntity.setsMajor(this.getsMajor());
        studentEntity.setsName(this.getsName());
        studentEntity.setSno(this.getSno());
        studentEntity.setsSex(this.getsSex());
        this.setToken(studentRegistServer.FaceAdd(this.getFace(),this.getSno()));
        studentEntity.setToken(this.getToken());

        if(this.getToken() == null){
            return "fail";
        }else {
            if (studentRegistServer.InfoRegist(studentEntity)) {
                return "success";
            } else {
                return "fail";
            }
        }
    }
}
