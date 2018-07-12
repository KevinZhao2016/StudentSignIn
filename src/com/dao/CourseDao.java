package com.dao;

import com.model.CourseEntity;

import java.util.List;

public interface CourseDao {
    List ListCourse();

    Boolean AddCourse(CourseEntity course);

    Boolean UpdateCourse(CourseEntity course);

    CourseEntity findCourseByID(int id);

    List<CourseEntity> findCourseByCname(String Cname);

    Boolean DeleteCourse(int id);
}
