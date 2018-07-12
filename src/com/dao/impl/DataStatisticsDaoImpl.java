package com.dao.impl;

import com.dao.DataStatisticsDao;
import com.dao.StudentDao;
import com.model.PresenceEntity;
import com.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Gavin on 2018/7/10.
 */

public class DataStatisticsDaoImpl implements DataStatisticsDao {

//    @Override
//    public List In_Out_Students(String TUserName, int CID, int state){
//        Session session = new HibernateUtil().getSession();
//        try{
//            String hql = "SELECT sno " +
//                    "FROM PresenceEntity " +
//                    "WHERE state = ? and tUserName = ? and cid = ?";
//            Query query = session.createQuery(hql);
//            query.setParameter(0, state);
//            query.setParameter(1, TUserName);
//            query.setParameter(2, CID);
//            List list = query.list();
//            return list;
//        }catch (HibernateException error){
//            error.printStackTrace();
//            return null;
//        }finally {
//            session.close();
//        }
//    }

    @Override
    public List Miss_rate_Attendance(String CName, int Cno){
        Session session = new HibernateUtil().getSession();
        int cid = 0;
        try{
            //在课程表中查找对应课程名与上课次数的课程号
            String hql = "SELECT cid " +
                    "FROM CourseEntity " +
                    "WHERE cName = ? and cno = ? ";
            Query query = session.createQuery(hql);
            query.setParameter(0, CName);
            query.setParameter(1, Cno);
            List listCid = query.list();
            cid = (int) listCid.get(0);
        }catch (HibernateException error){
            error.printStackTrace();
        }

        try{
            String hql2 = "FROM PresenceEntity " +
                    "WHERE cid = ? ";
            Query query2 = session.createQuery(hql2);
            query2.setParameter(0, cid);
            List list = query2.list();
            return list;
        }catch (HibernateException error){
            error.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public List SingleClass(String CName, int Cno, int state){
        Session session = new HibernateUtil().getSession();
        int cid = 0;
        try{
            //在课程表中查找对应课程名与上课次数的课程号
            String hql1 = "SELECT cid " +
                    "FROM CourseEntity " +
                    "WHERE cName = ? and cno = ? ";
            Query query1 = session.createQuery(hql1);
            query1.setParameter(0, CName);
            query1.setParameter(1, Cno);
            List listCid = query1.list();
            cid = (int) listCid.get(0);
        }catch (HibernateException error){
            error.printStackTrace();
        }
        try {
            if(state == 0 || state == 1) {
                //在签到表中按上述查找的课程号与签到状态查找学生学号
                String hql2 = "FROM PresenceEntity " +
                        "WHERE cid = ? and state = ? ";
                Query query2 = session.createQuery(hql2);
                query2.setParameter(0, cid);
                query2.setParameter(1, state);
                List<PresenceEntity> user = query2.list();
                return user;
            }else {
                String hql2 = "FROM PresenceEntity " +
                        "WHERE cid = ? ";
                Query query2 = session.createQuery(hql2);
                query2.setParameter(0, cid);
                List<PresenceEntity> user = query2.list();
                return user;
            }
        }catch (HibernateException error){
            error.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }
    //    @Override
//    public List AllClass(String CName){
//        Session session = new HibernateUtil().getSession();
//        List listCid = new ArrayList();
//        try{
//            //在课程表中查找对应课程名与上课次数的课程号集合
//            String hql1 = "SELECT cid " +
//                    "FROM CourseEntity " +
//                    "WHERE cName = ? ";
//            Query query1 = session.createQuery(hql1);
//            query1.setParameter(0, CName);
//            listCid = query1.list();
//        }catch (HibernateException error) {
//            error.printStackTrace();
//        }
//
//        try{
//            //在签到表中按上述查找的课程号与签到状态查找学生学号
//            List listSnos = new ArrayList();
//            for(int i = 0; i < listCid.size(); i++) {
//                int cid = (int) listCid.get(i);
//                String hql2 = "FROM PresenceEntity " +
//                        "WHERE cid = ?";
//                Query query2 = session.createQuery(hql2);
//                query2.setParameter(0, cid);
//                List<PresenceEntity> listSnoState = query2.list();
//                listSnos.add(i, listSnoState);
//            }
//            return listSnos;
//        }catch (HibernateException error){
//            error.printStackTrace();
//            return null;
//        }finally {
//            session.close();
//        }
//    }
    @Override
    public List AllClass(String CName, int state){
        Session session = new HibernateUtil().getSession();
        List listCid = new ArrayList();
        try{
            //在课程表中查找对应课程名与上课次数的课程号集合
            String hql1 = "SELECT cid " +
                    "FROM CourseEntity " +
                    "WHERE cName = ? ";
            Query query1 = session.createQuery(hql1);
            query1.setParameter(0, CName);
            listCid = query1.list();
        }catch (HibernateException error) {
            error.printStackTrace();
        }

        try{
            //在签到表中按上述查找的课程号与签到状态查找学生学号
            List listSnos = new ArrayList();
            for(int i = 0; i < listCid.size(); i++) {
                int cid = (int) listCid.get(i);
                String hql2 = "SELECT sno " +
                        "FROM PresenceEntity " +
                        "WHERE cid = ? and state = ? ";
                Query query2 = session.createQuery(hql2);
                query2.setParameter(0, cid);
                query2.setParameter(1, state);
                List listSno = query2.list();
                listSnos.add(i, listSno);
            }
            return listSnos;
        }catch (HibernateException error){
            error.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }
}
