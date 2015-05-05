package com.hello.dao;

import com.hello.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created by derric on 5/5/15.
 */
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    @Override
    public int insertRow(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(employee);
        tx.commit();
        Serializable id = session.getIdentifier(employee);
        session.close();
        return (Integer) id;
    }

    @Override
    public List<Employee> getList() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Employee> employeeList = session.createQuery("from Employee").list();
        session.close();
        return employeeList;
    }

    @Override
    public int updateRow(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(employee);
        tx.commit();
        Serializable id = session.getIdentifier(employee);
        return (Integer) id;
    }

    @Override
    public int deleteRow(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Employee employee = (Employee) session.load(Employee.class, id);
        session.delete(employee);
        tx.commit();
        Serializable ids = session.getIdentifier(employee);
        session.close();
        return (Integer) ids;
    }
}
