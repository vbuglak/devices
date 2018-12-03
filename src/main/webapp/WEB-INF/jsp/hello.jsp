<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Hello</title>
</head>
<body>
	<div>

		<h2>Spring Security - JDBC Authentication</h2>
		<a href="registry/devices/add">add</a>
		<a href="registry/devices">check</a>
		<a href="registry/devices/stats">stats</a>
	</div>

	<div>
		<h1>
			Hello <b><c:out value="${pageContext.request.remoteUser}"></c:out></b>
		</h1>
		<form action="/logout" method="post">
			<input type="submit"  value="Sign Out" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>

</body>
</html>
