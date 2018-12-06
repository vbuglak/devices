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
<h2>Registration Page</h2>
	<form:form method="post" action="registration" modelAttribute="User">
		<div >
			<div>
				<form:input path="userName" placeholder="User Name" />
			</div>
			<div>
				<form:input path="password" placeholder="Password" />
			</div>
			<c:if test="${param.existerror ne null}">
                    <div>Username already exsist.</div>
            </c:if>
			<div>
				<input type="submit" value="Sign Up" class="button red small" />
			</div>
		</div>
	</form:form>

</body>
</html>
