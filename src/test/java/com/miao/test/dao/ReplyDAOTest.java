package com.miao.test.dao;

import com.miao.test.pojo.Employee;
import com.miao.test.pojo.Reply;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by 10048 on 2017/9/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ReplyDAOTest {
    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private MessageDAO messageDAO;

    @Autowired
    private ReplyDAO replyDAO;

    @Test
    public void addReplay() throws Exception {
        Reply reply = new Reply();
        Employee employee1 = employeeDAO.findEmployeeById((long) 3);
        reply.setEmployee(employee1);
        reply.setMessage(messageDAO.findMessageById((long) 1));
        reply.setGmtCrete(new Date());
        reply.setGmtCrete(new Date());
        reply.setContent("this is new reply message.3");
        reply.setReplyTime(new Date());
        System.out.println(reply);
        replyDAO.addReplay(reply);
    }

    @Test
    public void findReplyByMsgId() throws Exception {
        List<Reply> list = replyDAO.findReplyByMsgId((long) 4);
        for (Reply reply : list) {
            System.out.println(reply);
        }
    }

    @Test
    public void findCountByMsgId() throws Exception {
        long i = replyDAO.findCountByMsgId((long) 4);
        System.out.println(i);
    }

}