<%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 11.12.2022
  Time: 0:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Restaurant Application</title>
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
    <c:if test="${employee != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${employee == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${employee != null}">
                            Edit Employee
                        </c:if>
                        <c:if test="${employee == null}">
                            Add New Employee
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${employee != null}">
                    <input type="hidden" name="id" value="<c:out value='${employee.id}' />" />
                </c:if>
                <tr>
                    <th>Full Name: </th>
                    <td>
                        <input type="text" name="fullName" size="45"
                               value="<c:out value='${employee.fullName}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Date of Birth: </th>
                    <td>
                        <input type="date" name="birthDate" size="45"
                               value="<c:out value='${employee.birthDate}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Position: </th>
                    <td>
                        <input type="text" name="position" size="5"
                               value="<c:out value='${employee.position}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>

</div>
</body>
</html>
