<%--
  Created by IntelliJ IDEA.
  User: tanver
  Date: 7/23/23
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title> HR Application </title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="#" class="navbar-brand"> HR Application </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/ListEmployees" class="nav-link">Employees</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Employees</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Employee</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>LastName</th>
                <th>Title</th>
                <th>Division</th>
                <th>Building</th>
                <th>Room</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <!--   for (Todo todo: todos) {  -->
            <jsp:useBean id="employeeList" scope="request" type="java.util.List"/>
            <c:forEach var="employee" items="${employeeList}">

                <tr>
                    <td>
                        <c:out value="${employee.id}"/>
                    </td>
                    <td>
                        <c:out value="${employee.firstname}"/>
                    </td>
                    <td>
                        <c:out value="${employee.lastname}"/>
                    </td>
                    <td>
                        <c:out value="${employee.title}"/>
                    </td>
                    <td>
                        <c:out value="${employee.division}"/>
                    </td>
                    <td>
                        <c:out value="${employee.building}"/>
                    </td>
                    <td>
                        <c:out value="${employee.room}"/>
                    </td>
                    <td><a href="edit?id=<c:out value='${employee.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${employee.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
    </div>
</div>
</body>

</html>
