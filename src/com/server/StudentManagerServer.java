package com.server;

import com.model.StudentEntity;

import java.util.List;

/**
 * Created by Mediv on 2018/7/11.
 */
public interface StudentManagerServer {
    List ListStudent();

    Boolean UpdateUser(StudentEntity student);

    StudentEntity findStudentByID(String id);

    Boolean DeleteStudent(String id);
}
