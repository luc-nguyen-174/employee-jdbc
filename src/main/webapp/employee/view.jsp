<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employees Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/employees">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Employee Information</h2>
            </caption>
            <tr>
                <td>Employee Code:</td>
                <td>${employee.employee_id}</td>
            </tr>
            <tr>
                <td>Employee Name:</td>
                <td>${employee.name}</td>
            </tr>
            <tr>
                <td>Employee ID Card Number:</td>
                <td>${employee.id_number}</td>
            </tr>
            <tr>
                <td>Phone Number:</td>
                <td>${employee.phone}</td>
            </tr>
            <tr>
                <td>Address:</td>
                <td>${employee.address}</td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>${employee.email}</td>
            </tr>
            <tr>
                <td>Note:</td>
                <td>${employee.note}</td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
