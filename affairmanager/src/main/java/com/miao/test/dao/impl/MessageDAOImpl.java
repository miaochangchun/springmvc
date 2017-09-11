package com.miao.test.dao.impl;

import com.miao.test.dao.MessageDAO;
import com.miao.test.pojo.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 10048 on 2017/9/5.
 */
@Repository
public class MessageDAOImpl implements MessageDAO {

    @Autowired
    private SessionFactory sessionFactory;


    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    @Override
    public void addMessage(Message message) {
        getCurrentSession().save(message);
    }

    @Override
    public void updateMessage(Message message) {
        getCurrentSession().createQuery("update Message m set m.gmtModified = ?, m.gmtCrete = ?, m.content = ?," +
                "m.employee.eId = ?, m.publishTime = ?, m.title = ? where m.mId = ?").setParameter(0, message.getGmtModified())
        .setParameter(1, message.getGmtCrete()).setParameter(2, message.getContent()).
                setParameter(3, message.getEmployee().geteId()).setParameter(4, message.getPublishTime())
        .setParameter(5, message.getTitle()).setParameter(6, message.getmId()).executeUpdate();
    }

    @Override
    public void deleteMessage(Long mId) {
        getCurrentSession().createQuery("delete from Message m where m.mId = ?").setParameter(0, mId).executeUpdate();
    }

    @Override
    public List<Message> findAllMessage() {
        return getCurrentSession().createQuery("from Message ").list();
    }

    @Override
    public List<Message> findMessageByCount(int i) {
        return getCurrentSession().createQuery("from Message m order by m.mId desc ").setMaxResults(i).list();
    }

    @Override
    public List<Message> findMessageByPage(int pageNum, int count) {
        return getCurrentSession().createQuery("from Message m ").setFirstResult(pageNum).setMaxResults(count).list();
    }

    @Override
    public Message findMessageById(Long mId) {
        return (Message)getCurrentSession().createQuery("from Message m where m.mId = ?").setParameter(0, mId).uniqueResult();
    }

    @Override
    public Long findAllCount() {
        return (Long)getCurrentSession().createQuery("select count(*) from Message m").iterate().next();
    }
}
