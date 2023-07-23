package com.hr.app.dao;

import com.hr.app.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {

    Employee saveEmployee(Employee employee) throws SQLException;

    List<Employee> getAllEmployee() throws SQLException;

    Employee getEmployeeById(int empId);

    Employee updateEmployee(Employee employee, int empId);

    boolean deleteEmployee(int empId);

}
