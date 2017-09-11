package com.miao.test.dao;

import com.miao.test.pojo.Reply;

import java.util.List;

/**
 * Created by 10048 on 2017/9/5.
 */
public interface ReplyDAO {
    /**
     * 添加回复
     * @param reply
     */
    public void addReplay(Reply reply);

    /**
     * 按文章ID查找回复
     * @param mId
     * @return
     */
    public List<Reply> findReplyByMsgId(Long mId);

    /**
     * 查询消息回复记录数
     * @param mId
     * @return
     */
    public Long findCountByMsgId(Long mId);
}
