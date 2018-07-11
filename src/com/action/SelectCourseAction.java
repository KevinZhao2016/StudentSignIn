package com.action;

/**
 * Created by Mediv on 2018/7/11.
 */
import com.opensymphony.xwork2.ActionContext;
import com.server.impl.TeLoginServerImpl;

import java.util.Map;

public class SelectCourseAction {
    private String CName;
    private int Cno;

    public String getCName(){
        return CName;
    }
    public void setCName(String CName){
        this.CName = CName;
    }

    public int getCno(){
        return Cno;
    }
    public void setCno(int Cno){
        this.Cno = Cno;
    }

    public String execute() throws Exception{
        System.out.println(this.CName);
        System.out.println(this.Cno);
        TeLoginServerImpl teloginServerImpl = new TeLoginServerImpl();
        int Cid = teloginServerImpl.CourseId(CName,Cno);
        if(Cid != 0){
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("cid",Cid);
            session.put("cname",CName);
            return "success";
        }else
            return "fail";
    }
}
