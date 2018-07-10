package com.dao;

import com.model.StudentEntity;

import java.util.List;

public interface StudentDao {
    List ListStudent();

   // String Login(String TelNum, String Password);

    Boolean RegisterStudent(StudentEntity student);

    Boolean UpdateUser(StudentEntity student);

    StudentEntity  findStudentByID(String id);

    Boolean DeleteStudent(String id);
}
