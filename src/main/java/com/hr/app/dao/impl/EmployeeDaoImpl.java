package com.hr.app.dao.impl;

import com.hr.app.dao.EmployeeDao;
import com.hr.app.db.DbConnection;
import com.hr.app.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private static Connection connection = DbConnection.getInstance();
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private static final String INSERT_SQL = "INSERT INTO employee " +
            "(id, firstname, lastname, title, division, building, room) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL_SQL = "SELECT * FROM employee";
    private static final String GET_BY_ID_SQL = "SELECT * FROM employee WHERE id = ?";

    private static final String UPDATE_SQL = "UPDATE employee SET firstname = ?, lastname = ?, title = ?," +
            " division = ?, building = ?, room = ? WHERE id = ?";

    private static final String DELETE_SQL = "DELETE FROM employee WHERE id = ?";

    @Override
    public Employee saveEmployee(Employee employee) throws SQLException {
        this.preparedStatement = connection.prepareStatement(INSERT_SQL);
        this.preparedStatement.setInt(1, employee.getId());
        this.preparedStatement.setString(2, employee.getFirstname());
        this.preparedStatement.setString(3, employee.getLastname());
        this.preparedStatement.setString(4, employee.getTitle());
        this.preparedStatement.setString(5, employee.getDivision());
        this.preparedStatement.setInt(6, employee.getBuilding());
        this.preparedStatement.setString(7, employee.getRoom());
        this.preparedStatement.execute();
        this.preparedStatement.close();
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        try {
            this.preparedStatement = connection.prepareStatement(GET_ALL_SQL);
            this.resultSet = this.preparedStatement.executeQuery();
            while (this.resultSet.next())
                employeeList.add(rsToEmployee(resultSet));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(employeeList);
        this.preparedStatement.close();
        this.resultSet.close();
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(int empId) {
        Employee employee = null;
        try {
            this.preparedStatement = connection.prepareStatement(GET_BY_ID_SQL);
            this.preparedStatement.setInt(1, empId);
            this.resultSet = this.preparedStatement.executeQuery();
            while (this.resultSet.next())
                employee = rsToEmployee(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(employee);
        return employee;
    }

    /**
     * UPDATE employee SET firstname = ?, lastname = ?, title = ?, division = ?, building = ?, room = ? WHERE CustomerID = ?;
     */
    @Override
    public Employee updateEmployee(Employee employee, int empId) {
        try {
            this.preparedStatement = connection.prepareStatement(UPDATE_SQL);
            this.preparedStatement.setString(1, employee.getFirstname());
            this.preparedStatement.setString(2, employee.getLastname());
            this.preparedStatement.setString(3, employee.getTitle());
            this.preparedStatement.setString(4, employee.getDivision());
            this.preparedStatement.setInt(5, employee.getBuilding());
            this.preparedStatement.setString(6, employee.getRoom());
            this.preparedStatement.setInt(7, empId);
            try {
                int affectedRow = this.preparedStatement.executeUpdate();
                System.out.println(affectedRow);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return employee;
    }

    @Override
    public boolean deleteEmployee(int empId) {
        try {
            this.preparedStatement = connection.prepareStatement(DELETE_SQL);
            this.preparedStatement.setInt(1, empId);
            this.resultSet = this.preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    private Employee rsToEmployee(ResultSet resultSet) throws SQLException {
        int id = this.resultSet.getInt("id");
        String firstname = this.resultSet.getString("firstname");
        String lastname = this.resultSet.getString("lastname");
        String title = this.resultSet.getString("title");
        String division = this.resultSet.getString("division");
        int building = this.resultSet.getInt("building");
        String room = this.resultSet.getString("room");
        return new Employee(id, firstname, lastname, title, division, building, room);
    }

}
