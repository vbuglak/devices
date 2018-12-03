<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>User devices</title>
</head>
<body>
<h2>Devices</h2>
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
</body>
</html>