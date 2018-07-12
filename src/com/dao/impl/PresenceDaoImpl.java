package com.dao.impl;

import com.dao.PresenceDao;
import com.model.PresenceEntity;
import com.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PresenceDaoImpl implements PresenceDao {

    public List ListPresence() {
        Session session = new HibernateUtil().getSession();
        try {
            List<PresenceEntity> list = session.createQuery("FROM PresenceEntity presence").list();
            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public Boolean PresenceAdd(PresenceEntity presenceEntity) {
        Session session = new HibernateUtil().getSession();
        Transaction tran = session.beginTransaction();
        try {
            session.save(presenceEntity);
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

    public PresenceEntity findPresenceBySnoAndCID(String Sno, int CID) {
        Session session = new HibernateUtil().getSession();
        String hql = "from PresenceEntity where sno = ? and cid = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0, Sno);
        query.setParameter(1, CID);
        PresenceEntity presenceEntity = (PresenceEntity) query.uniqueResult();
        if (presenceEntity != null) {
            return presenceEntity;
        } else {
            return null;
        }
    }

    public List<PresenceEntity> findPresenceByCID(int CID){
        Session session = new HibernateUtil().getSession();
        String hql = "from PresenceEntity where cid = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0, CID);
        List<PresenceEntity> list = (List<PresenceEntity>) query.uniqueResult();
        if (list != null) {
            return list;
        } else {
            return null;
        }
    }

    public List<PresenceEntity> findPresenceByStateAndCID(int State,int CID){
        Session session = new HibernateUtil().getSession();
        String hql = "from PresenceEntity where state = ? and cid = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0, State);
        query.setParameter(1, CID);
        List<PresenceEntity> list = (List<PresenceEntity>) query.getResultList();
        if (list != null) {
            return list;
        } else {
            return null;
        }
    }

}
