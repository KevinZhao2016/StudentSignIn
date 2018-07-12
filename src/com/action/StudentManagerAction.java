package com.action;

import com.model.StudentEntity;
import com.opensymphony.xwork2.ActionContext;
import com.server.StudentManagerServer;
import com.server.impl.StudentManagerServerImpl;

import java.util.List;
import java.util.Map;

/**
 * Created by Mediv on 2018/7/11.
 */
public class StudentManagerAction {
    private int sid;
    private String sno;
    private String sName;
    private String sAge;
    private String sSex;
    private String sMajor;
    private String token;
    private StudentManagerServer studentManagerServer = new StudentManagerServerImpl();

    public int getSid(){
        return sid;
    }
    public void setSid(int sid){
        this.sid = sid;
    }

    public String getSno(){
        return sno;
    }
    public void setSno(String sno){
        this.sno = sno;
    }

    public String getsName(){
        return sName;
    }
    public void setsName(String sName){
        this.sName = sName;
    }

    public String getsAge(){
        return sAge;
    }
    public void setsAge(String sAge){
        this.sAge = sAge;
    }

    public String getsSex(){
        return sSex;
    }
    public void setsSex(String sSex){
        this.sSex = sSex;
    }

    public String getsMajor(){
        return sMajor;
    }
    public void setsMajor(String sMajor){
        this.sMajor = sMajor;
    }

    public String getToken(){
        return token;
    }
    public void setToken(String token){
        this.token = token;
    }

    private StudentEntity setStudentEntity(){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setSid(this.getSid());
        studentEntity.setSno(this.getSno());
        studentEntity.setsName(this.getsName());
        studentEntity.setsAge(this.getsAge());
        studentEntity.setsSex(this.getsSex());
        studentEntity.setsMajor(this.getsMajor());
        studentEntity.setToken(this.getToken());
        return studentEntity;
    }

    public String List() throws Exception{
        List<StudentEntity> list = studentManagerServer.ListStudent();
        if (list != null){
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("StudentList", list);
            return "success";
        }else
            return "fail";
    }

    public String Update()throws Exception{
        StudentEntity studentEntity = this.setStudentEntity();
        if (studentManagerServer.UpdateUser(studentEntity)){
            this.List();
            return "success";
        }else
            return "fail";
    }

    public String Delete() throws Exception{
        if (studentManagerServer.DeleteStudent(this.getSno())){
            this.List();
            return "success";
        }else
            return "fail";
    }
}
