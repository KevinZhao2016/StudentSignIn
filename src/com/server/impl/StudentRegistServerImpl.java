package com.server.impl;

import com.dao.StudentDao;
import com.dao.impl.StudentDaoImpl;
import com.model.StudentEntity;
import com.server.StudentRegistServer;
import com.util.AipFaceUtil;

public class StudentRegistServerImpl implements StudentRegistServer {
    public String FaceAdd(String face, String id){
        AipFaceUtil aipFaceUtil = new AipFaceUtil();
        return aipFaceUtil.FaceAdd(face,id);
    }

    public Boolean InfoRegist(StudentEntity student){
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.RegisterStudent(student);
    }
}
