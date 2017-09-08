package com.miao.test.dao;

import com.miao.test.pojo.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 10048 on 2017/9/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MessageDAOTest {
    @Autowired
    private MessageDAO dao;

    @Autowired
    private EmployeeDAO employeeDAO;

    @Test
    public void addMessage() throws Exception {
        Message message = new Message();
        message.setContent("这是答案2");
        message.setEmployee(employeeDAO.findEmployeeById((long) 2));
        message.setGmtCrete(new Date());
        message.setGmtModified(new Date());
        message.setPublishTime(new Date());
        message.setTitle("这是问题2");
        System.out.println(message);
        dao.addMessage(message);
    }

    @Test
    public void updateMessage() throws Exception {
        Message message = dao.findMessageById((long) 4);
        message.setGmtModified(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        message.setPublishTime(sdf.parse("2015-05-06 12:23:55"));
        message.setTitle("have a good dream");
        dao.updateMessage(message);

    }

    @Test
    public void deleteMessage() throws Exception {
        dao.deleteMessage((long) 3);
    }

    @Test
    public void findAllMessage() throws Exception {
        List<Message> list = dao.findAllMessage();
        for (Message message : list) {
            System.out.println(message);
        }
    }

    @Test
    public void findMessageById() throws Exception {
        Message message = dao.findMessageById((long) 1);
        System.out.println(message);
    }

    @Test
    public void findAllCount() throws Exception {
        long i = dao.findAllCount();
        System.out.println(i);
    }

    @Test
    public void test() {
        List<Message> list = dao.findMessageByPage(12*(2-1), 12);
        for (Message message : list) {
            System.out.println(message);
        }
    }
}