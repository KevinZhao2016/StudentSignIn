package com.dao.impl;

import com.dao.TeacherDao;
import com.model.TeacherEntity;
import com.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao{
    public List ListTeacher(){
        Session session = new HibernateUtil().getSession();
        try {
            List<TeacherEntity> list = session.createQuery("FROM TeacherEntity Teacher").list();
            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public Boolean AddTeacher(TeacherEntity Teacher){
        Session session = new HibernateUtil().getSession();
        Transaction tran = session.beginTransaction();
        try {
            session.save(Teacher);
            tran.commit();
            return true;
        }catch (HibernateException e){
            e.printStackTrace();
            tran.rollback();
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    public Boolean UpdateTeacher(TeacherEntity Teacher){
        Session session = new HibernateUtil().getSession();
        Transaction tran = session.beginTransaction();
        try {
            session.update(Teacher);
            tran.commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            tran.rollback();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    public TeacherEntity findTeacherByID(int id){
        Session session = new HibernateUtil().getSession();
        String hql = "from TeacherEntity where tid = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        TeacherEntity teacher = (TeacherEntity) query.uniqueResult();
        if (teacher != null) {
            return teacher;
        } else {
            return null;
        }
    }

    public TeacherEntity findTeacherByName(String name){
        Session session = new HibernateUtil().getSession();
        String hql = "from TeacherEntity where tUserName = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0, name);
        TeacherEntity teacher = (TeacherEntity) query.uniqueResult();
        if (teacher != null) {
            return teacher;
        } else {
            return null;
        }
    }

    public Boolean DeleteTeacher(int id){
        Session session = new HibernateUtil().getSession();
        TeacherEntity teacher = this.findTeacherByID(id);
        Transaction tran = session.beginTransaction();
        try {
            session.delete(teacher);
            tran.commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            tran.rollback();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public String Login(String TuserName, String TpassWord){
        Session session = new HibernateUtil().getSession();
        try{
            String hql = "FROM TeacherEntity WHERE tUserName = ?";
            Query query = session.createQuery(hql);
            query.setParameter(0,TuserName);
            TeacherEntity teacher = (TeacherEntity) query.uniqueResult();
            if(teacher != null){
                String pwd = teacher.gettPassword();
                if (pwd.equals(TpassWord)){
                    return teacher.gettName();
                }else {
                    return null;
                }
            } else
                return null;
        }catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<String> ListCourse(String TuserName){
        Session session = new HibernateUtil().getSession();
        try {
            List<String> list = new ArrayList<String>();
            //= session.createQuery("FROM CourseEntity WHERE tUserName =?").list();
            String hql = "SELECT DISTINCT cName FROM CourseEntity WHERE tUserName =?";
            Query query = session.createQuery(hql);
            query.setParameter(0,TuserName);
            list = query.getResultList();
            for (int i = 0; i < list.size(); i ++){
                System.out.println(list.get(i));
            }
            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public int CourseId(String CName, int Cno){
        Session session = new HibernateUtil().getSession();
        try {
            int courseID;
            String hql = "SELECT cid FROM CourseEntity WHERE cName = ? AND  cno = ?";
            Query query = session.createQuery(hql);
            query.setParameter(0,CName);
            query.setParameter(1,Cno);
            courseID = (int)query.uniqueResult();

            System.out.println(courseID);

            return courseID;
        } catch (HibernateException e) {
            e.printStackTrace();
            return 0;
        } finally {
            session.close();
        }
    }
}
