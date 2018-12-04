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
		<a href="registration">Регистрация пользователя</a><br>
        <a href="login">Авторизация пользователя</a><br>
		<a href="registry/devices/add">Добавить устройство</a><br>
		<a href="registry/devices">Посмотреть список устройств</a><br>
		<a href="registry/devices/stats">Статистика пользователей и устройств</a><br>
		<a href="registry/json/devices">Посмотреть список устройств json</a><br>
		<a href="registry/xml/devices">Посмотреть список устройств xml</a><br>
	</div>

	<div>
		<h1>
			Hello <b><c:out value="${pageContext.request.remoteUser}"></c:out></b>
		</h1>
		<form action="/logout" method="post">
			<input type="submit"  value="Разлогиниться" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>

</body>
</html>
