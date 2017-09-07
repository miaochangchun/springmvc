package com.miao.test.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 10048 on 2017/9/5.
 */
@Entity@Table
public class Reply {
    @Id@GeneratedValue
    private Long rId;

    @Column
    private String content;

    @Column(name = "reply_time")
    private Date replyTime;

    @ManyToOne
    @JoinColumn(name = "mId", referencedColumnName = "mId")
    private Message message;

    @OneToOne
    @JoinColumn(name = "eId", referencedColumnName = "eId")
    private Employee employee;

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
