package com.miao.test.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 10048 on 2017/9/5.
 */
@Entity@Table
public class Criticism {
    @Id@GeneratedValue
    private Long cId;

    @Column
    private String content;

    @Column(name = "criticism_time")
    private Date criticismTime;

    @OneToOne
    @JoinColumn(name = "eId", referencedColumnName = "eId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "mId", referencedColumnName = "mId")
    private Message message;

    @Column(name = "gmt_create", insertable = true, updatable = false)
    private Date gmtCrete;      //数据创建时间

    @Column(name = "gmt_modified", insertable = false, updatable = true)
    private Date gmtModified;    //数据修改时间

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCriticismTime() {
        return criticismTime;
    }

    public void setCriticismTime(Date criticismTime) {
        this.criticismTime = criticismTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
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
        return "Criticism{" +
                "cId=" + cId +
                ", content='" + content + '\'' +
                ", criticismTime=" + criticismTime +
                ", employee=" + employee +
                ", message=" + message +
                ", gmtCrete=" + gmtCrete +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
