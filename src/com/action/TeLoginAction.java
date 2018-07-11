package com.action;

/**
 * Created by Mediv on 2018/7/10.
 */
import com.model.CourseEntity;
import com.opensymphony.xwork2.ActionContext;
import com.server.impl.TeLoginServerImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class TeLoginAction {
    private String TuserName;
    private Boolean flag;
    private List<String> courseList;

    public String getTuserName() {
        return TuserName;
    }

    public void setTuserName(String tuserName) {
        TuserName = tuserName;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public List<String> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<String> courseList) {
        this.courseList = courseList;
    }

    public String execute() throws Exception{
        String TpassWord;
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        TpassWord = request.getParameter("password");
        this.setTuserName(request.getParameter("username"));

        TeLoginServerImpl teloginServerImpl = new TeLoginServerImpl();
        String TName = teloginServerImpl.Login(TuserName,TpassWord);
        if(TName != null){
            List<String> courseList = teloginServerImpl.SelectCourse(TuserName);
            this.setCourseList(courseList);
            this.setFlag(true);
            return "success";
        }else{
            this.setFlag(false);
            return "fail";
        }
    }
}
