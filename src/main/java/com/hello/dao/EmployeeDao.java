package com.hello.dao;

import com.hello.models.Employee;

import java.util.List;

/**
 * Created by derric on 5/5/15.
 */
public interface EmployeeDao {
    public int insertRow(Employee employee);

    public List<Employee> getList();

    public int updateRow(Employee employee);

    public int deleteRow(int id);
}
