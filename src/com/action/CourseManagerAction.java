package com.action;

import com.model.CourseEntity;
import com.opensymphony.xwork2.ActionContext;
import com.server.CourseManagerServer;
import com.server.impl.CourseManagerServerImpl;

import java.sql.Time;
import java.util.List;
import java.util.Map;

/**
 * Created by Mediv on 2018/7/12.
 */
public class CourseManagerAction {
    private int Cid;
    private String CName;
    private String TUserName;
    private Time CStart;
    private Time CEnd;
    private int Cno;
    private CourseManagerServer courseMangerServer =new CourseManagerServerImpl();

    public  int getCid(){return Cid;}
    public  void setCid(int Cid){this.Cid=Cid;}
    public  String getCName(){return CName;}
    public void setCName(String CName){this.CName=CName;}
    public String getTUserName(){return TUserName;}
    public void setTUserName(String TUserName){this.TUserName=TUserName;}
    public Time getCStart(){return CStart;}
    public void setCStart(Time CStart){this.CStart=CStart;}
    public Time getCEnd(){return  CEnd;}
    public void setCEnd(Time CEnd){this.CEnd=CEnd;}
    public int getCno(){return Cno;}
    public void setCno(int Cno){this.Cno=Cno;}

    private CourseEntity setCourseEnity(){
        CourseEntity courseEntity=new CourseEntity();
        courseEntity.setCid(this.getCid());
        courseEntity.setcName(this.getCName());
        courseEntity.settUserName(this.getTUserName());
        courseEntity.setcStart(this.getCStart());
        courseEntity.setcEnd(this.getCEnd());
        courseEntity.setCno(this.getCno());
        return courseEntity;
    }

    public String List() throws Exception{
        List<CourseEntity>list =courseMangerServer.ListCourse();
        if (list != null) {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("CourseList", list);
            return "success";
        } else
            return "fail";
    }
    public String Update() throws Exception {
        CourseEntity courseEntity=this.setCourseEnity();
        if (courseMangerServer.UpdateCourse(courseEntity)) {
            this.List();
            return "success";
        } else {
            return "fail";
        }
    }

    public String Add() throws Exception {
        CourseEntity courseEntity=this.setCourseEnity();
        if (courseMangerServer.AddCourse(courseEntity)) {
            this.List();
            return "success";
        } else {
            return "fail";
        }
    }

    public String Delete() throws Exception {
        if (courseMangerServer.DeleteCourse(this.getCid())) {
            this.List();
            return "success";
        } else {
            return "fail";
        }
    }

    public String findRouteById() throws Exception {
        int id = this.getCid();
        CourseEntity  courseEntity=courseMangerServer.findCourseById(id);
        if (courseEntity!= null) {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("courseEntity", courseEntity);
            return "success";
        } else
            return "fail";
    }
}
