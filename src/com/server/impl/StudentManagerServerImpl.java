package com.server.impl;

import com.dao.StudentDao;
import com.dao.impl.StudentDaoImpl;
import com.model.StudentEntity;
import com.server.StudentManagerServer;
import com.util.AipFaceUtil;

import java.util.List;

/**
 * Created by Mediv on 2018/7/11.
 */
public class StudentManagerServerImpl implements StudentManagerServer{
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List ListStudent(){
        List<StudentEntity> list;
        list = studentDao.ListStudent();
        return list;
    }

    @Override
    public Boolean UpdateUser(StudentEntity student){
        return studentDao.UpdateUser(student);
    }

    @Override
    public StudentEntity findStudentByID(String id){
        return studentDao.findStudentByID(id);
    }

    @Override
    public Boolean DeleteStudent(String id){
        StudentEntity student = findStudentByID(id);
        AipFaceUtil aipFaceUtil = new AipFaceUtil();
        String token = student.getToken();
        if (aipFaceUtil.FaceDelete(id, token) == "success")
            return studentDao.DeleteStudent(id);
        else
            return false;
    }
}
