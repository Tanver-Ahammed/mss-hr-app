<%--
  Created by IntelliJ IDEA.
  User: tanver
  Date: 7/23/23
  Time: 7:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title> HR Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
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
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <jsp:useBean id="employee" scope="request" type="com.hr.app.model.Employee"/>
            <c:if test="${employee != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${employee == null}">
                <form action="insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${employee != null}">
                                Edit User
                            </c:if>
                            <c:if test="${employee == null}">
                                Add New User
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${employee != null}">
                        <input type="hidden" name="id" value="<c:out value='${employee.id}' />"/>
                    </c:if>

                    <fieldset class="form-group">
                        <label><b>Employee First Name:</b> </label>
                        <label>
                            <input type="text" value="<c:out value='${employee.firstname}' />"
                                   class="form-control" name="firstname" required="required">
                        </label>
                    </fieldset>

                    <fieldset class="form-group">
                        <label><b>Employee Last Name:</b></label>
                        <label>
                            <input type="text" value="<c:out value='${employee.lastname}' />"
                                   class="form-control" name="lastname" required="required">
                        </label>
                    </fieldset>

                    <fieldset class="form-group">
                        <label><b>Employee Title:</b> </label>
                        <label>
                            <input type="text" value="<c:out value='${employee.title}' />"
                                   class="form-control" name="title" required="required">
                        </label>
                    </fieldset>

                    <fieldset class="form-group">
                        <label><b>Employee Division:</b></label>
                        <label>
                            <input type="text" value="<c:out value='${employee.division}' />"
                                   class="form-control" name="division" required="required">
                        </label>
                    </fieldset>

                    <fieldset class="form-group">
                        <label><b>Employee Building:</b></label>
                        <label>
                            <input type="text" value="<c:out value='${employee.building}' />"
                                   class="form-control" name="building" required="required">
                        </label>
                    </fieldset>

                    <fieldset class="form-group">
                        <label><b>Employee Room:</b></label>
                        <label>
                            <input type="text" value="<c:out value='${employee.room}' />"
                                   class="form-control" name="room" required="required">
                        </label>
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save & Update</button>
                </form>
        </div>
    </div>
</div>
</body>

</html>
