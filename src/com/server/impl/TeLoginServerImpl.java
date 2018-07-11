package com.server.impl;

/**
 * Created by Mediv on 2018/7/10.
 */
import com.dao.impl.TeacherDaoImpl;
import com.server.TeLoginServer;

import java.util.List;

public class TeLoginServerImpl implements TeLoginServer{
    TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
    @Override
    public String Login(String TuserName, String TpassWord){
        return teacherDaoImpl.Login(TuserName,TpassWord);
    }

    @Override
    public List<String> SelectCourse(String TuserName){
        return teacherDaoImpl.ListCourse(TuserName);
    }

    @Override
    public int CourseId(String CName, int Cno){
        return teacherDaoImpl.CourseId(CName, Cno);
    }
}
