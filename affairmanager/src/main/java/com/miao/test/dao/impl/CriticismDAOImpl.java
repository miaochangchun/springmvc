package com.miao.test.dao.impl;

import com.miao.test.dao.CriticismDAO;
import com.miao.test.pojo.Criticism;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by 10048 on 2017/9/5.
 */
@Repository
public class CriticismDAOImpl implements CriticismDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    @Override
    public void addCriticism(Criticism criticism) {
        getCurrentSession().save(criticism);
    }

    @Override
    public Criticism findCriticismByMsgId(Long mId) {
        return (Criticism)getCurrentSession().createQuery("from Criticism c where c.message.mId = ?").setParameter(0, mId).uniqueResult();
    }
}
