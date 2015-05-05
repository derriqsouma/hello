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
<%@page session="true"%>
<html>
<head>
    <title></title>
</head>
<body>

<c:if test="${not empty error}">
    <div class="error">${error}</div>
</c:if>
<c:if test="${not empty msg}">
    <div class="msg">${msg}</div>
</c:if>

<form action="<c:url value='/create' />" method='POST'>

    <input type="text" placeholder="first name" name="fname" >
    <input type="text" placeholder="last name" name="lname" >
    <input type="email" placeholder="email" name="email" >
    <input type="number" placeholder="phone no." name="phone" >

    <button> Create</button>

</form>

</body>
</html>