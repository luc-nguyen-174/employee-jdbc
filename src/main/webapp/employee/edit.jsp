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
        <a href="/employees">Back To List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>Edit Employee</caption>
            <c:if test="${employee != null}">
                <input type="hidden" name="id" value="<c:out value='${employee.id}' />"/>
            </c:if>
            <tr>
                <th>Employee Code</th>
                <td>
                    <input type="text" name="employee_id" id="employee_id" size="45" value="<c:out value='${employee.employee_id}' />">
                </td>
            </tr>
            <tr>
                <th>Employee Name</th>
                <td><input type="text" name="name" id="name" size="45" value="<c:out value='${employee.name}' />"></td>
            </tr>
            <tr>
                <th>Employee ID Card Number</th>
                <td><input type="text" name="id_number" id="id_number" size="45" value="<c:out value='${employee.id_number}' />"></td>
            </tr>
            <tr>
                <th>Phone Number</th>
                <td><input type="text" name="phone" id="phone" size="45" value="<c:out value='${employee.phone}' />"></td>
            </tr>
            <tr>
                <th>Address</th>
                <td><input type="text" name="address" id="address" size="45" value="<c:out value='${employee.address}' />"></td>
            </tr>
            <tr>
                <th>Email</th>
                <td><input type="text" name="email" id="email" size="45" value="<c:out value='${employee.email}' />"></td>
            </tr>
            <tr>
                <th>Note</th>
                <td><textarea name="note" id="note" rows="4" cols="45" value="<c:out value='${employee.note}' />"></textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
