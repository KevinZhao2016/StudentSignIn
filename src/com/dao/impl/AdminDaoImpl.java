package com.dao.impl;

import com.dao.AdminDao;
import com.model.AdminEntity;
import com.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AdminDaoImpl implements AdminDao {

    @Override
    public String Login(String userName, String passWord){
        Session session = new HibernateUtil().getSession();
        try{
            String hql = "from AdminEntity where aUserName = ?";
            Query query = session.createQuery(hql);
            query.setParameter(0,userName);
            AdminEntity admin = (AdminEntity) query.uniqueResult();
            if(admin != null){
                String pwd = admin.getaPassword();
                if (pwd.equals(passWord)){
                    return admin.getaUserName();
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
}
