package com.server;

import com.model.TeacherEntity;

import java.util.List;

/**
 * Created by Mediv on 2018/7/11.
 */
public interface TeacherManagerServer {
    List ListTeacher();

    Boolean AddTeacher(TeacherEntity Teacher);

    Boolean UpdateTeacher(TeacherEntity Teacher);

    TeacherEntity findTeacherByID(int id);

    TeacherEntity findTeacherByName(String name);

    Boolean DeleteTeacher(int id);
}
