package com.dao.impl;

import com.dao.StudentDao;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class StudentDaoImplTest {
    StudentDao studentDao = new StudentDaoImpl();
    @Test
    public void listStudent() {
//        System.out.println(studentDao.ListStudent());
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
    }

    @Test
    public void findStudentByID() {
        System.out.println(studentDao.findStudentByID("pengju").getsName());
    }
}