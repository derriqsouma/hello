
<%--
  Created by IntelliJ IDEA.
  User: derric
  Date: 5/5/15
  Time: 12:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title></title>
</head>
<body>

<h2>List of Employees</h2>
<c:if test="${!empty employeeList}">
<table border="true">
  <thead>
  <tr>
    <td>Sno.</td>
    <td>First Name</td>
    <td>Last Name</td>
    <td>Email</td>
    <td>Phone</td>
  </tr>
  </thead>
  <c:forEach items="employeeList" var="emp" varStatus="counter">
    <tr>
      <td>${counter.count}</td>
      <td>${emp[counter]}</td>
      <td>Last Name</td>
      <td>Email</td>
      <td>Phone</td>
      
    </tr>

  </c:forEach>
  
  
</table>

</c:if>

</body>
</html>
