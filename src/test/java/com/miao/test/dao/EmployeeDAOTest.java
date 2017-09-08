package com.miao.test.dao;

import com.miao.test.pojo.Employee;
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
public class EmployeeDAOTest {
    @Autowired
    private EmployeeDAO dao;

    @Test
    public void add() throws Exception {
        Employee employee = new Employee();
        employee.setGmtModified(new Date());
        employee.setPlace("北京");
        employee.setPassword("123456");
        employee.setGmtCrete(new Date());
        employee.setMale(true);
        employee.setLead(true);
        employee.setBirth(new Date());
        employee.setJoinTime(new Date());
        employee.setPhone("17610068133");
        employee.setUsername("苗长春");
        dao.add(employee);
    }

    @Test
    public void update() throws Exception {
        Employee employee = dao.findEmployeeById((long) 3);
        employee.setGmtModified(new Date());
        employee.setPhone("17610068133");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        employee.setBirth(sdf.parse("1989-04-05"));
        employee.setJoinTime(sdf.parse("2017-08-08"));
        System.out.println(employee);
        dao.update(employee);
    }

    @Test
    public void delete() throws Exception {
        dao.delete((long) 2);
    }

    @Test
    public void findAllEmployee() throws Exception {
        List<Employee> list = dao.findAllEmployee();
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    @Test
    public void findEmployeeById() throws Exception {
        Employee employee = dao.findEmployeeById((long) 2);
        System.out.println(employee);
    }

}