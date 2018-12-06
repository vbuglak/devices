<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Spring Security</title>
</head>
<body>
<h2>Login Page</h2>
	<form action="/login" method="post">
		<div>
			<div>
				<input type="text" name="username"
					placeholder="User Name" />
			</div>
			<div>
				<input type="password" name="password"
					placeholder="Password" />
			</div>
			<div>
				<input type="submit" value="Sign In" />
			</div>
			<c:if test="${param.error ne null}">
				<div>Invalid username and password.</div>
			</c:if>
			<c:if test="${param.logout ne null}">
				<div>You have been logged out.</div>
			</c:if>
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</body>
</html>
