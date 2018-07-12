package com.server.impl;

import com.dao.CourseDao;
import com.dao.PresenceDao;
import com.dao.StudentDao;
import com.dao.impl.CourseDaoImpl;
import com.dao.impl.PresenceDaoImpl;
import com.dao.impl.StudentDaoImpl;
import com.model.*;
import com.server.PresenceInfoServer;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PresenceInfoServerImpl implements PresenceInfoServer {

    public List<AllClassResultEntity> GetAllClassResult(String Cname) {
        PresenceDao presenceDao = new PresenceDaoImpl();
        CourseDao courseDao = new CourseDaoImpl();
        StudentDao studentDao = new StudentDaoImpl();
        List<CourseEntity> courseEntityList = courseDao.findCourseByCname(Cname);
        List<AllClassResultEntity> resultList = new ArrayList<AllClassResultEntity>();
        for (int i = 0; i < courseEntityList.size(); i++) {
            System.out.println("course");
            System.out.println(courseEntityList.size());
            List<PresenceEntity> presenceEntityList = presenceDao.findPresenceByCID(courseEntityList.get(i).getCid());
            for (int j = 0; j < presenceEntityList.size(); j++) {
                System.out.println("presence");
                System.out.println(presenceEntityList.size());
                StudentEntity student = studentDao.findStudentByID(presenceEntityList.get(j).getSno());
                int count = 1;
                int flag = 0;//是否为新的student
                if (resultList.size() == 0) {
                    AllClassResultEntity allClassResultEntity = new AllClassResultEntity();
                    allClassResultEntity.setStudentEntity(student);
                    allClassResultEntity.setCount(count);
                    resultList.add(allClassResultEntity);
                } else {
                    for (int k = 0; k < resultList.size(); k++) {//判断几次重复
                        System.out.println("result");
                        System.out.println(resultList.size());
                        if (student.getsName().equals(resultList.get(k).getStudentEntity().getsName())) {
                            count = resultList.get(k).getCount();
                            count++;
                            resultList.get(k).setCount(count);
                            flag = 1;
                        }
                    }
                    if (flag == 0) {
                        AllClassResultEntity allClassResultEntity = new AllClassResultEntity();
                        allClassResultEntity.setStudentEntity(student);
                        allClassResultEntity.setCount(count);
                        resultList.add(allClassResultEntity);
                    }
                }
            }
        }
        return resultList;
    }

    public List<SingleClassResultEntity> GetSingleClassResult(String Cname, int Cno){
        PresenceDao presenceDao = new PresenceDaoImpl();
        CourseDao courseDao = new CourseDaoImpl();
        StudentDao studentDao = new StudentDaoImpl();
        CourseEntity courseEntity = courseDao.findCourseByCnameAndCno(Cname,Cno);
        List<SingleClassResultEntity> resultList = new ArrayList<SingleClassResultEntity>();
        List<PresenceEntity> presenceEntityList = presenceDao.findPresenceByCID(courseEntity.getCid());
        for (int i = 0; i < presenceEntityList.size(); i++) {
            SingleClassResultEntity singleResult = new SingleClassResultEntity();
            StudentEntity student = studentDao.findStudentByID(presenceEntityList.get(i).getSno());
            int State = presenceEntityList.get(i).getState();
            Timestamp time = presenceEntityList.get(i).getTime();
            singleResult.setState(State);
            singleResult.setTime(time);
            singleResult.setStudent(student);
            resultList.add(singleResult);
        }
        return resultList;
    }

    public List<SingleClassResultEntity> GetSingleClassResult(String Cname,int Cno,int State){
        PresenceDao presenceDao = new PresenceDaoImpl();
        CourseDao courseDao = new CourseDaoImpl();
        StudentDao studentDao = new StudentDaoImpl();
        CourseEntity courseEntity = courseDao.findCourseByCnameAndCno(Cname,Cno);
        List<SingleClassResultEntity> resultList = new ArrayList<SingleClassResultEntity>();
        List<PresenceEntity> presenceEntityList = presenceDao.findPresenceByStateAndCID(State,courseEntity.getCid());
        for (int i = 0; i < presenceEntityList.size(); i++) {
            SingleClassResultEntity singleResult = new SingleClassResultEntity();
            StudentEntity student = studentDao.findStudentByID(presenceEntityList.get(i).getSno());
            Timestamp time = presenceEntityList.get(i).getTime();
            singleResult.setState(State);
            singleResult.setTime(time);
            singleResult.setStudent(student);
            resultList.add(singleResult);
        }
        return resultList;
    }
}
