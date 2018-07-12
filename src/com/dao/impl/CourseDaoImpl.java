package com.dao.impl;

import com.dao.CourseDao;
import com.model.CourseEntity;
import com.model.PresenceEntity;
import com.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CourseDaoImpl implements CourseDao{
    public List ListCourse(){
        Session session = new HibernateUtil().getSession();
        try {
            List<PresenceEntity> list = session.createQuery("FROM CourseEntity Course").list();
            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public Boolean AddCourse(CourseEntity course){
        Session session = new HibernateUtil().getSession();
        Transaction tran = session.beginTransaction();
        try {
            session.save(course);
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

    public Boolean UpdateCourse(CourseEntity course){
        Session session = new HibernateUtil().getSession();
        Transaction tran = session.beginTransaction();
        try {
            session.update(course);
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

    public CourseEntity findCourseByID(int id){
        Session session = new HibernateUtil().getSession();
        String hql = "from CourseEntity where cid = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        CourseEntity course = (CourseEntity) query.uniqueResult();
        if (course != null) {
            return course;
        } else {
            return null;
        }
    }

    public List<CourseEntity> findCourseByCname(String Cname){
        Session session = new HibernateUtil().getSession();
        String hql = "from CourseEntity where cName = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0, Cname);
        List<CourseEntity> course = (List<CourseEntity>) query.getResultList();
        if (course != null) {
            return course;
        } else {
            return null;
        }
    }

    public Boolean DeleteCourse(int id){
        Session session = new HibernateUtil().getSession();
        CourseEntity course = this.findCourseByID(id);
        Transaction tran = session.beginTransaction();
        try {
            session.delete(course);
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
}
