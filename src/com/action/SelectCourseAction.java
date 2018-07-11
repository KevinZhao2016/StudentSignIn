package com.action;

/**
 * Created by Mediv on 2018/7/11.
 */
import com.opensymphony.xwork2.ActionContext;
import com.server.impl.TeLoginServerImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class SelectCourseAction {
    private String CName;
    private int Cno;
    private boolean flag;

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

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
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        TeLoginServerImpl teloginServerImpl = new TeLoginServerImpl();
        int Cid = teloginServerImpl.CourseId(CName,Cno);
        if(Cid != 0){
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("cid",Cid);
            session.put("cname",CName);
            this.setFlag(true);
            return "success";
        }else{
            this.setFlag(false);
            return "fail";
        }
    }
}
