package com.server.impl;

import com.dao.CourseDao;
import com.dao.PresenceDao;
import com.dao.StudentDao;
import com.dao.impl.CourseDaoImpl;
import com.dao.impl.PresenceDaoImpl;
import com.dao.impl.StudentDaoImpl;
import com.model.AllClassResultEntity;
import com.model.CourseEntity;
import com.model.PresenceEntity;
import com.model.StudentEntity;
import com.server.PresenceInfoServer;

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
            AllClassResultEntity allClassResultEntity = new AllClassResultEntity();
            List<PresenceEntity> presenceEntityList = presenceDao.findPresenceByCID(courseEntityList.get(i).getCid());
            for (int j = 0; j < presenceEntityList.size(); j++) {
                StudentEntity student = studentDao.findStudentByID(presenceEntityList.get(j).getSno());
                allClassResultEntity.setStudentEntity(student);
                int count = 1;
                for (int k = 0; k < resultList.size(); k++) {//判断几次重复
                    if (student.getSno().equals(resultList.get(i).getStudentEntity().getSno())) {
                        count++;
                    }
                }
                allClassResultEntity.setCount(count);
            }
            resultList.add(allClassResultEntity);
        }
        return resultList;
    }
}
