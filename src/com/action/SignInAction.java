package com.action;

import com.model.PresenceEntity;
import com.model.StudentEntity;
import com.opensymphony.xwork2.ActionContext;
import com.server.FaceSearchServer;
import com.server.SignInServer;
import com.server.impl.FaceSearchServerImpl;
import com.server.impl.SignInServerImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


public class SignInAction {
    private StudentEntity studentEntity;
    private PresenceEntity presenceEntity;
    private int flag;
    private String CName;

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public PresenceEntity getPresenceEntity() {
        return presenceEntity;
    }

    public void setPresenceEntity(PresenceEntity presenceEntity) {
        this.presenceEntity = presenceEntity;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        int cid = (int)session.get("cid");//获取课程号

        String face = request.getParameter("face");
        FaceSearchServer faceSearchServer = new FaceSearchServerImpl();
        SignInServer signInServer = new SignInServerImpl();
        StudentEntity student = faceSearchServer.FindStudentByFace(face);
        Boolean status = signInServer.GetSignInStatus(student.getSno(),cid);
        PresenceEntity presenceEntity = signInServer.SetPresenceEntity(student.getSno(),cid);
        this.setPresenceEntity(presenceEntity);
        this.setCName((String)session.get("cname"));

        if (student.getSno() != null) {
            this.setStudentEntity(student);
            if(!status){//重复签到
                setFlag(1);
                return "success";
            }else {
                setFlag(0);
                signInServer.AddPresence(presenceEntity);
                return "success";
            }
        } else
            return "fail";
    }
}
