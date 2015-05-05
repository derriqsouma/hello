package com.hello.services;

import com.hello.dao.EmployeeDao;
import com.hello.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by derric on 5/5/15.
 */
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDao employeeDao;
    
    @Override
    public int insertRow(Employee employee) {
        return employeeDao.insertRow(employee);
    }

    @Override
    public List<Employee> getList() {
        return employeeDao.getList();
    }

    @Override
    public int updateRow(Employee employee) {
        return employeeDao.updateRow(employee);
    }

    @Override
    public int deleteRow(int id) {
        return employeeDao.deleteRow(id);
    }
}
