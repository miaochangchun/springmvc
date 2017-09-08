package com.miao.test.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 10048 on 2017/9/5.
 */
@Entity@Table
public class Message {
    @Id@GeneratedValue
    private Long mId;

    @Column(name = "title", unique = true, nullable = false)
    private String title;           //文章标题不能重复

    @Column(name = "content", nullable = false)
    private String content;         //文章内容

    @Column(name = "publish_time", nullable = false)
    private Date publishTime;       //文章发布时间

    @ManyToOne
    @JoinColumn(name = "eId", referencedColumnName = "eId", nullable = false)
    private Employee employee;          //文章发布作者Id

    @Column(name = "gmt_create", insertable = true, updatable = false)
    private Date gmtCrete;      //数据创建时间

    @Column(name = "gmt_modified", insertable = false, updatable = true)
    private Date gmtModified;    //数据修改时间

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
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
        return "Message{" +
                "mId=" + mId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publishTime=" + publishTime +
                ", employee=" + employee +
                ", gmtCrete=" + gmtCrete +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
