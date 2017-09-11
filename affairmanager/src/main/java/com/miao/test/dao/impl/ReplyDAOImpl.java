package com.miao.test.dao.impl;

import com.miao.test.dao.ReplyDAO;
import com.miao.test.pojo.Reply;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 10048 on 2017/9/5.
 */
@Repository
public class ReplyDAOImpl implements ReplyDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    @Override
    public void addReplay(Reply reply) {
        getCurrentSession().save(reply);
    }

    @Override
    public List<Reply> findReplyByMsgId(Long mId) {
        return getCurrentSession().createQuery("from Reply r where r.message.mId = ?").setParameter(0, mId).list();
    }

    @Override
    public Long findCountByMsgId(Long mId) {
        return (Long)getCurrentSession().createQuery("select count(*) from Reply r where r.message.mId = ?").setParameter(0, mId).iterate().next();
    }
}
