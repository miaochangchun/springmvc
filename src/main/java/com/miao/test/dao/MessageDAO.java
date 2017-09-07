package com.miao.test.dao;

import com.miao.test.pojo.Message;

import java.util.List;

/**
 * Created by 10048 on 2017/9/5.
 */
public interface MessageDAO {
    /**
     * 定义添加消息的方法
     * @param message
     */
    public void addMessage(Message message);

    /**
     * 定义修改消息的方法
     * @param message
     */
    public void updateMessage(Message message);

    /**
     * 定义删除消息的方法
     * @param mId
     */
    public void deleteMessage(Long mId);

    /**
     * 定义按分页信息查询所有消息的方法
     * @return
     */
    public List<Message> findAllMessage();

    /**
     * 从数据库中只查最新的integer条数据
     * @param i
     * @return
     */
    public List<Message> findMessageByCount(int i);

    /**
     * 分页查询
     * @param pageNum   每页的起始页码
     * @param count     每页显示的消息数
     * @return
     */
    public List<Message> findMessageByPage(int pageNum, int count);

    /**
     * 定义按ID查询消息的方法
     * @param mId
     * @return
     */
    public Message findMessageById(Long mId);

    /**
     * 定义查询消息记录数
     * @return
     */
    public Long findAllCount();
}
