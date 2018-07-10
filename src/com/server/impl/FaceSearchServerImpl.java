package com.server.impl;

import com.dao.StudentDao;
import com.dao.impl.StudentDaoImpl;
import com.model.StudentEntity;
import com.server.FaceSearchServer;
import com.util.AipFaceUtil;

public class FaceSearchServerImpl implements FaceSearchServer{
    @Override
    public StudentEntity FindStudentByFace(String image){
        AipFaceUtil aipFaceUtil = new AipFaceUtil();
        String StudentID = aipFaceUtil.FaceSearch(image);
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.findStudentByID(StudentID);
    }
}
