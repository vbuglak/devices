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
<h2>Device create Page</h2>
	<form:form method="post" action="/registry/devices/add" modelAttribute="Device">
		<div >
			<div>
				<form:input path="serialNo" placeholder="serialNo" />
			</div>
			<div>
				<form:input path="type" placeholder="type" />
			</div>
			<div>
            	<form:input path="description" placeholder="description" />
            </div>
			<div>
				<input type="submit" value="create" />
			</div>
		</div>
	</form:form>

</body>
</html>