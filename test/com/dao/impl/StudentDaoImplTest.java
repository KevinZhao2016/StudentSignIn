package com.dao.impl;

import com.dao.StudentDao;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentDaoImplTest {
    StudentDao studentDao = new StudentDaoImpl();
    @Test
    public void listStudent() {
        System.out.println(studentDao.ListStudent());
    }

    @Test
    public void findStudentByID() {
        System.out.println(studentDao.findStudentByID("pengju").getsName());
    }
}