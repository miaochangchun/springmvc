package com.miao.test.dao;

import com.miao.test.pojo.Employee;

import java.util.List;

/**
 * Created by 10048 on 2017/9/5.
 */
public interface EmployeeDAO {
    /**
     * 定义添加员工信息的方法
     * @param employee
     */
    public void add(Employee employee);

    /**
     * 定义修改员工信息的方法
     * @param employee
     */
    public void update(Employee employee);

    /**
     * 定义删除员工信息的方法
     * @param eId
     */
    public void delete(Long eId);

    /**
     * 定义查询所有员工信息的方法
     * @return
     */
    public List<Employee> findAllEmployee();

    /**
     * 定义按ID查询员工信息的方法
     * @param eId
     * @return
     */
    public Employee findEmployeeById(Long eId);
}
