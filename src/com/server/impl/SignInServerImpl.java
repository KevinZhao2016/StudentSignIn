package com.server.impl;

import com.dao.CourseDao;
import com.dao.PresenceDao;
import com.dao.TeacherDao;
import com.dao.impl.CourseDaoImpl;
import com.dao.impl.PresenceDaoImpl;
import com.dao.impl.TeacherDaoImpl;
import com.model.CourseEntity;
import com.model.PresenceEntity;
import com.model.TeacherEntity;
import com.server.SignInServer;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

public class SignInServerImpl implements SignInServer {
    public PresenceEntity SetPresenceEntity(String sno, int cid) {
        PresenceEntity presenceEntity = new PresenceEntity();
        PresenceDao presenceDao = new PresenceDaoImpl();
        CourseDao courseDao = new CourseDaoImpl();
        CourseEntity course = courseDao.findCourseByID(cid);
        TeacherDao teacherDao = new TeacherDaoImpl();

        Calendar calendar = Calendar.getInstance();//可以对每个时间域单独修改
        TeacherEntity teacher = teacherDao.findTeacherByName(course.gettUserName());

        presenceEntity.settUserName(course.gettUserName());
        presenceEntity.setSno(sno);
        presenceEntity.setCid(cid);
        presenceEntity.setTime(Calendar2Timestamp(calendar));
        int state;
        if(CompareTime(calendar,course.getcStart())){
            state = 1;//迟到
        }else
            state = 0;//正常签到
        presenceEntity.setState(state);
        return presenceEntity;
    }

    public Boolean AddPresence(PresenceEntity presenceEntity) {
        PresenceDao presenceDao = new PresenceDaoImpl();
        return presenceDao.PresenceAdd(presenceEntity);
    }

    public Boolean GetSignInStatus(String sno, int CID) {
        PresenceDao presenceDao = new PresenceDaoImpl();
        if (presenceDao.findPresenceBySnoAndCID(sno, CID) == null) {
            return true;//签到正常
        } else
            return false; //重复签到
    }

    //将Calendar转换为Timestamp
    private Timestamp Calendar2Timestamp(Calendar calendar) {
        int Seconds = calendar.get(Calendar.SECOND);
        int Minutes = calendar.get(Calendar.MINUTE);
        int Hours = calendar.get(Calendar.HOUR_OF_DAY);
        int Year = calendar.get(Calendar.YEAR);
        int Month = calendar.get(Calendar.MONTH);
        int Day = calendar.get(Calendar.DATE);
        Timestamp time = new Timestamp(Year, Month, Day, Hours, Minutes, Seconds, 0);
        return time;
    }

    //将Timestamp转换为Time
    private Time Timestamp2Time(Timestamp timestamp) {
        int Seconds = timestamp.getSeconds();
        int Minutes = timestamp.getMinutes();
        int Hours = timestamp.getHours();
        Time time = new Time(Hours, Minutes, Seconds);
        return time;
    }

    //比较两个时间，A>B返回True
    private Boolean CompareTime(Calendar TimeA, Time TimeB) {
        if (TimeA.get(Calendar.HOUR_OF_DAY) > TimeB.getHours()) {
            return true;
        } else if (TimeA.get(Calendar.HOUR_OF_DAY) == TimeB.getHours()) {
            if (TimeA.get(Calendar.MINUTE) > TimeB.getMinutes()) {
                return true;
            } else if (TimeA.get(Calendar.MINUTE) == TimeB.getMinutes()) {
                if (TimeA.get(Calendar.SECOND) > TimeB.getSeconds()) {
                    return true;
                }
            }
        }
        return false;
    }
}
