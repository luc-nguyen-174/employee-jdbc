<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee Management Application</title>
</head>
<body>
<center>
    <h1>Employee Management</h1>
    <h2>
        <a href="/employees?action=create">Add New Employee</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Employees</h2></caption>
        <tr>
            <th>ID</th>
            <th>Employee Code</th>
            <th>Employee Name</th>
            <th>ID Card Number</th>
            <th>Phone Number</th>
            <th>Address</th>
            <th>Email</th>
            <th>Note</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="employee" items="${employeeList}">
            <tr>
                <td><c:out value="${employee.id}"/></td>
                <td><c:out value="${employee.employee_id}"/></td>
                <td><c:out value="${employee.name}"/></td>
                <td><c:out value="${employee.id_number}"/></td>
                <td><c:out value="${employee.phone}"/></td>
                <td><c:out value="${employee.address}"/></td>
                <td><c:out value="${employee.email}"/></td>
                <td><c:out value="${employee.note}"/></td>
                <td>
                    <a href="/employees?action=edit&id=${employee.id}">Edit</a>
                    <a href="/employees?action=delete&id=${employee.id}">Delete</a>
                    <a href="/employees?action=view&id=${employee.id}">View</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
