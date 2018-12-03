<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Stats devices</title>
</head>
<body>
<h2>Last Devices</h2>
<table>
	<c:if test="${not empty devices}">
         <c:forEach var="dev" items="${devices}">
        <tr>
            <td><c:out value="${dev.serialNo}"/></td>
            <td><c:out value="${dev.type}"/></td>
            <td><c:out value="${dev.description}"/></td>
            <td><c:out value="${dev.owner.userName}"/></td>
            <td><c:out value="${dev.createdAt}"/></td>
        </tr>
         </c:forEach>
    </c:if>
</table>
<h2>Top Users</h2>
<table>
	<c:if test="${not empty topUsers}">
         <c:forEach var="topUser" items="${topUsers}">
        <tr>
            <td><c:out value="${topUser.user.userName}"/></td>
            <td><c:out value="${topUser.deviceCount}"/></td>
        </tr>
         </c:forEach>
    </c:if>
</table>
</body>
</html>