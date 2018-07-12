package com.server;

import com.model.CourseEntity;

import java.util.List;

public interface CourseManagerServer {
    List ListCourse();

    Boolean UpdateCourse(CourseEntity courseEntity);

    Boolean AddCourse(CourseEntity courseEntity);

    CourseEntity findCourseById(int id);

    Boolean DeleteCourse(int id);
}
