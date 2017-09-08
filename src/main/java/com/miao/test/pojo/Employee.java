package com.miao.test.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 10048 on 2017/9/5.
 */
@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue
    private Long eId;			//员工编号

    @Column(name = "username", unique = true)
    private String username;	    //员工姓名，不能重复

    @Column(name = "is_male", nullable = false)
    private Boolean male;	        //员工性别,是否为男性

    @Column(name = "birth", nullable = false)
    private Date birth;		    //出生日期

    @Column(name = "phone")
    private String phone;	        //办公室电话

    @Column(name = "place")
    private String place;	        //住址

    @Column(name = "join_time", nullable = false)
    private Date joinTime;			//入职时间

    @Column(name = "password", nullable = false)
    private String password;		//系统口令

    @Column(name = "is_lead", nullable = false)
    private Boolean lead;			//是否为管理层领导

    @Column(name = "gmt_create", insertable = true, updatable = false)
    private Date gmtCrete;      //数据创建时间

    @Column(name = "gmt_modified", insertable = false, updatable = true)
    private Date gmtModified;    //数据修改时间

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getMale() {
        return male;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLead() {
        return lead;
    }

    public void setLead(Boolean lead) {
        this.lead = lead;
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
        return "Employee{" +
                "eId=" + eId +
                ", username='" + username + '\'' +
                ", male=" + male +
                ", birth=" + birth +
                ", phone='" + phone + '\'' +
                ", place='" + place + '\'' +
                ", joinTime=" + joinTime +
                ", password='" + password + '\'' +
                ", lead=" + lead +
                ", gmtCrete=" + gmtCrete +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
