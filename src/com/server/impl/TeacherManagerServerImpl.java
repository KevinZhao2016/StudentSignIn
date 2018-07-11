package com.server.impl;

import com.dao.TeacherDao;
import com.dao.impl.TeacherDaoImpl;
import com.model.TeacherEntity;
import com.server.TeacherManagerServer;

import java.util.List;

/**
 * Created by Mediv on 2018/7/11.
 */
public class TeacherManagerServerImpl implements TeacherManagerServer{
    private TeacherDao teacherDao = new TeacherDaoImpl();
    @Override
    public List ListTeacher(){
        List<TeacherEntity> list;
        list = teacherDao.ListTeacher();
        return list;
    }

    @Override
    public Boolean AddTeacher(TeacherEntity Teacher){
        return teacherDao.AddTeacher(Teacher);
    }

    @Override
    public Boolean UpdateTeacher(TeacherEntity Teacher){
        return teacherDao.UpdateTeacher(Teacher);
    }

    @Override
    public TeacherEntity findTeacherByID(int id){
        return teacherDao.findTeacherByID(id);
    }

    @Override
    public TeacherEntity findTeacherByName(String name){
        return teacherDao.findTeacherByName(name);
    }

    @Override
    public Boolean DeleteTeacher(int id){
        return teacherDao.DeleteTeacher(id);
    }
}
