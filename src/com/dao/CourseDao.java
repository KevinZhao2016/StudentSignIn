package com.dao;

import com.model.CourseEntity;

import java.util.List;

public interface CourseDao {
    List ListCourse();

    Boolean AddCourse(CourseEntity course);

    Boolean UpdateCourse(CourseEntity course);

    CourseEntity findCourseByID(int id);

    Boolean DeleteCourse(int id);
}
