package com.miao.test.dao.impl;

import com.miao.test.dao.EmployeeDAO;
import com.miao.test.pojo.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 10048 on 2017/9/5.
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    @Override
    public void add(Employee employee) {
        getCurrentSession().save(employee);
    }

    @Override
    public void update(Employee employee) {
        getCurrentSession().createQuery("update Employee e  set e.birth = ?, " +
                "e.gmtCrete = ?, e.gmtModified = ?, e.joinTime = ?, e.lead = ?," +
                "e.male = ?, e.password = ?, e.phone = ?, e.place = ?, e.username = ? " +
                "where e.eId = ?").setParameter(0, employee.getBirth()).setParameter(1, employee.getGmtCrete())
                    .setParameter(2, employee.getGmtModified()).setParameter(3, employee.getJoinTime()).setParameter(4, employee.getLead())
                    .setParameter(5, employee.getMale())
                    .setParameter(6, employee.getPassword())
                    .setParameter(7, employee.getPhone())
                    .setParameter(8, employee.getPlace()).setParameter(9, employee.getUsername())
                    .setParameter(10, (Long)employee.geteId()).executeUpdate();
    }

    @Override
    public void delete(Long eId) {
        getCurrentSession().createQuery("delete from Employee e where e.eId = ?").setParameter(0, eId).executeUpdate();
    }

    @Override
    public List<Employee> findAllEmployee() {
        return getCurrentSession().createQuery("from Employee").list();
    }

    @Override
    public Employee findEmployeeById(Long eId) {
        return (Employee)getCurrentSession().createQuery("from Employee e where e.eId = ?").setParameter(0, eId).uniqueResult();
    }


}
