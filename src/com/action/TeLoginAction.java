package com.action;

/**
 * Created by Mediv on 2018/7/10.
 */
import com.model.CourseEntity;
import com.opensymphony.xwork2.ActionContext;
import com.server.impl.TeLoginServerImpl;

import java.util.List;
import java.util.Map;

public class TeLoginAction {
    private String TuserName;
    private String TpassWord;

    public String getTuserName(){
        return TuserName;
    }
    public void setTuserName(String TuserName){
        this.TuserName = TuserName;
    }

    public String getTpassWord(){
        return TpassWord;
    }
    public void setTpassWord(String TpassWord){
        this.TpassWord = TpassWord;
    }

    public String execute() throws Exception{
        System.out.println(this.TuserName);
        System.out.println(this.TpassWord);
        TeLoginServerImpl teloginServerImpl = new TeLoginServerImpl();
        String TName = teloginServerImpl.Login(TuserName,TpassWord);
        if(TName != null){
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("TName",TName);
            List<String> courseList = teloginServerImpl.SelectCourse(TuserName);
            session.put("courseList",courseList);
            return "success";
        }else
            return "fail";
    }
}
