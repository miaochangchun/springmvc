package com.miao.test.dao;

import com.miao.test.pojo.Criticism;
import com.miao.test.pojo.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by 10048 on 2017/9/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CriticismDAOTest {
    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private MessageDAO messageDAO;

    @Autowired
    private CriticismDAO criticismDAO;

    @Test
    public void addCriticism() throws Exception {
        Criticism criticism = new Criticism();
        criticism.setContent("同意");
        criticism.setGmtModified(new Date());
        criticism.setGmtCrete(new Date());
        criticism.setCriticismTime(new Date());
        criticism.setEmployee(employeeDAO.findEmployeeById((long) 3));
        criticism.setMessage(messageDAO.findMessageById((long) 4));
        System.out.println(criticism);
        criticismDAO.addCriticism(criticism);
    }

    @Test
    public void findCriticismByMsgId() throws Exception {
        Criticism criticism = criticismDAO.findCriticismByMsgId((long) 4);
        System.out.println(criticism);
    }

}