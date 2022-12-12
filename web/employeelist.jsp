<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 11.12.2022
  Time: 0:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
  <title>Restaurant</title>
</head>
<body>
<center>
  <h1>Employees Management</h1>
  <h2>
    <a href="${pageContext.request.contextPath}/new">Add New Employee</a>
    &nbsp;&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/list">List All Employees</a>

  </h2>
</center>
<div align="center">
  <table border="1" cellpadding="5">
    <caption><h2>List of Employees</h2></caption>
    <tr>
      <th>ID</th>
      <th>Full Name</th>
      <th>Date of Birth</th>
      <th>Position</th>
      <th>Actions</th>
    </tr>
    <c:forEach var="employee" items="${listEmployee}">
      <tr>
        <td><c:out value="${employee.id}" /></td>
        <td><c:out value="${employee.fullName}" /></td>
        <td><c:out value="${employee.birthDate}" /></td>
        <td><c:out value="${employee.position}" /></td>
        <td>
          <a href="${pageContext.request.contextPath}/edit?id=<c:out value='${employee.id}' />">Edit</a>
          &nbsp;&nbsp;&nbsp;&nbsp;
          <a href="${pageContext.request.contextPath}/delete?id=<c:out value='${employee.id}' />">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
