package com.hr.app.controller;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

import com.hr.app.dao.EmployeeDao;
import com.hr.app.dao.impl.EmployeeDaoImpl;
import com.hr.app.file.read.XmlFileRead;
import com.hr.app.model.Employee;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao;

    public void init() {
        this.employeeDao = new EmployeeDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    addNewEmpFromXML(request, response);
                    break;
                case "/ListEmployees":
                    listEmployees(request, response);
                    break;
                case "/delete":
                    deleteEmployee(request, response);
                    break;
                case "/edit":
                    employeeEdit(request, response);
                    break;
                case "/update":
                    updateEmployee(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
//            throw new ServletException(ex);
            System.err.println(ex.getMessage());
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String title = request.getParameter("title");
        String division = request.getParameter("division");
        int building = Integer.parseInt(request.getParameter("building"));
        String room = request.getParameter("room");

        Employee employee = new Employee(id, firstname, lastname, title, division, building, room);
        this.employeeDao.updateEmployee(employee, id);
        response.sendRedirect("ListEmployees");
    }

    private void addNewEmpFromXML(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        XmlFileRead xmlFileRead = new XmlFileRead();
        xmlFileRead.retrieveEmpInfoSaveDB();
        listEmployees(request, response);
    }

    private void employeeEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existingEmployee = this.employeeDao.getEmployeeById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
        request.setAttribute("employee", existingEmployee);
        dispatcher.forward(request, response);
    }

    private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Employee> employeeList = this.employeeDao.getAllEmployee();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.employeeDao.deleteEmployee(id);
        this.listEmployees(request, response);
    }

    public void destroy() {
    }
}