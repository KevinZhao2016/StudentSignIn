package com.dao;

import com.model.TeacherEntity;

import java.util.List;

public interface TeacherDao {
    List ListTeacher();

    Boolean AddTeacher(TeacherEntity Teacher);

    Boolean UpdateTeacher(TeacherEntity Teacher);

    TeacherEntity findTeacherByID(int id);

    TeacherEntity findTeacherByName(String name);

    Boolean DeleteTeacher(int id);

    String Login(String TuserName, String TpassWord);

    List ListCourse(String TuserName);

    int CourseId(String CName, int Cno);
}
