package com.dao.impl;

import com.dao.StudentDao;
import com.model.StudentEntity;
import com.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List ListStudent() {
        Session session = new HibernateUtil().getSession();
        try {
            List<StudentEntity> list = session.createQuery("FROM StudentEntity user").list();
            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public int RegisterStudent(StudentEntity student){
        Session session = new HibernateUtil().getSession();
        Transaction tran = session.beginTransaction();
        try {
            session.save(student);
            tran.commit();
            return 1;
        }catch (HibernateException e){
            e.printStackTrace();
            tran.rollback();
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        } finally {
            session.close();
        }
    }

    @Override
    public Boolean UpdateUser(StudentEntity student){
        Session session = new HibernateUtil().getSession();
        Transaction tran = session.beginTransaction();
        try {
            session.update(student);
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
    public StudentEntity  findStudentByID(String id){
        Session session = new HibernateUtil().getSession();
        String hql = "from StudentEntity where sno = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        StudentEntity user = (StudentEntity) query.uniqueResult();
        if (user != null) {
            return user;
        } else {
            return new StudentEntity();
        }
    }

    @Override
    public Boolean DeleteStudent(String id) {
        Session session = new HibernateUtil().getSession();
        StudentEntity user = this.findStudentByID(id);
        Transaction tran = session.beginTransaction();
        try {
            session.delete(user);
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
