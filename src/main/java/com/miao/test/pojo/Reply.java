package com.miao.test.pojo;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 10048 on 2017/9/5.
 */
@Entity@Table
public class Reply {
    @Id@GeneratedValue
    private Long rId;

    @Column(name = "content", nullable = false)
    private String content;         //回复内容

    @Column(name = "reply_time", nullable = false)
    private Date replyTime;         //回复时间

    @ManyToOne
    @JoinColumn(name = "mId", referencedColumnName = "mId", nullable = false)
    private Message message;        //一条消息可以有多个评论

    @ManyToOne
    @JoinColumn(name = "eId", referencedColumnName = "eId", nullable = false)
    private Employee employee;      //一个评论由一个员工发出，一个员工可以发多个评论

    @Column(name = "gmt_create", insertable = true, updatable = false)
    private Date gmtCrete;      //数据创建时间

    @Column(name = "gmt_modified", insertable = false, updatable = true)
    private Date gmtModified;    //数据修改时间

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getGmtCrete() {
        return gmtCrete;
    }

    public void setGmtCrete(Date gmtCrete) {
        this.gmtCrete = gmtCrete;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "rId=" + rId +
                ", content='" + content + '\'' +
                ", replyTime=" + replyTime +
                ", message=" + message +
                ", employee=" + employee +
                ", gmtCrete=" + gmtCrete +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
