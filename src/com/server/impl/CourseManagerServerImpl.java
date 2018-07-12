package com.server.impl;

import com.dao.CourseDao;
import com.dao.impl.CourseDaoImpl;
import com.model.CourseEntity;
import com.server.CourseManagerServer;

import java.util.List;
public class CourseManagerServerImpl implements CourseManagerServer{
    private CourseDao courseDao=new CourseDaoImpl();
    @Override
    public List ListCourse() {
        List<CourseEntity>list;
        list =courseDao.ListCourse();
        return list;
    }

    @Override
    public Boolean AddCourse(CourseEntity courseEntity) {
        return courseDao.AddCourse(courseEntity);
    }

    @Override
    public Boolean UpdateCourse(CourseEntity courseEntity) {
        return courseDao.UpdateCourse(courseEntity);
    }

    public CourseEntity findCourseById(int id){
        return courseDao.findCourseByID(id);
    }

    public Boolean DeleteCourse(int id){
        return courseDao.DeleteCourse(id);
    }
}
