package com.action;

import com.model.TeacherEntity;
import com.opensymphony.xwork2.ActionContext;
import com.server.TeacherManagerServer;
import com.server.impl.TeacherManagerServerImpl;

import java.util.List;
import java.util.Map;

/**
 * Created by Mediv on 2018/7/11.
 */
public class TeacherManagerAction {
    private int tid;
    private String tUsername;
    private String tName;
    private String tPassword;
    private String tTell;
    private TeacherManagerServer teacherManagerServer= new TeacherManagerServerImpl();

    public int getTid(){
        return tid;
    }
    public void setTid(int tid){
        this.tid = tid;
    }

    public String gettUsername(){
        return tUsername;
    }
    public void settUsername(String tUsername){
        this.tUsername = tUsername;
    }

    public String gettName(){
        return tName;
    }
    public void settName(String tName){
        this.tName = tName;
    }

    public String gettPassword(){
        return tPassword;
    }
    public void settPassword(String tPassword){
        this.tPassword = tPassword;
    }

    public String gettTell(){
        return tTell;
    }
    public void settTell(String tTell){
        this.tTell = tTell;
    }

    private TeacherEntity setTeacherEntity(){
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setTid(this.getTid());
        teacherEntity.settName(this.gettName());
        teacherEntity.settUserName(this.gettUsername());
        teacherEntity.settPassword(this.gettPassword());
        teacherEntity.setTtell(this.gettTell());
        return teacherEntity;
    }

    public String List() throws Exception{
        List<TeacherEntity> list = teacherManagerServer.ListTeacher();
        if (list != null){
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("TeacherList",list);
            return "success";
        }else
            return "fail";
    }

    public String Add() throws Exception{
        TeacherEntity teacherEntity = this.setTeacherEntity();
        if (teacherManagerServer.AddTeacher(teacherEntity)){
            this.List();
            return "success";
        }else
            return "fail";
    }

    public String Update() throws Exception{
        TeacherEntity teacherEntity = this.setTeacherEntity();
        if (teacherManagerServer.UpdateTeacher(teacherEntity)){
            this.List();
            return "success";
        }else
            return "fail";
    }

    public String Delete() throws Exception{
        if (teacherManagerServer.DeleteTeacher(this.getTid())){
            this.List();
            return "success";
        }else
            return "fail";
    }

}
