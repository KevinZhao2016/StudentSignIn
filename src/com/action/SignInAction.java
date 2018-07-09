package com.action;

import com.model.StudentEntity;
import org.apache.struts2.ServletActionContext;
import service.FaceSearchServer;
import service.impl.FaceSearcherverImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SignInAction {
    private StudentEntity studentEntity;

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }


    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String face;
        face=request.getParameter("face");
        FaceSearchServer faceSeracherver = new FaceSearcherverImpl();
        StudentEntity student = faceSeracherver.FindStudentByFace(face);
        if (student != null) {
            this.setStudentEntity(student);
            return "success";
        } else
            return "fail";
    }
}
