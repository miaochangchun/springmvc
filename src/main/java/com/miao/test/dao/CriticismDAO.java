package com.miao.test.dao;

import com.miao.test.pojo.Criticism;

import java.util.List;

/**
 * Created by 10048 on 2017/9/5.
 */
public interface CriticismDAO {
    /**
     * 添加批复
     * @param criticism
     */
    public void addCriticism(Criticism criticism);

    /**
     * 按文章ID查找批复
     * @param mId
     * @return
     */
    public Criticism findCriticismByMsgId(Long mId);
}
