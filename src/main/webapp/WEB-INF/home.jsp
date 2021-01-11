<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Driving License </title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
</head>
<body>
	<section>
		<div class="container">
			<div class="notification">
	<h1>Welcome to Driver's License!</h1>
  		<b>🚗</b><br>
			</div>
			<h1>New Person</h1>

			<form:form action="/create/person" method="post"
				modelAttribute="person">
				<p>
					<form:label path="first_name">First Name: </form:label>
					<form:errors path="first_name" />
					<form:input path="first_name" type="text" />
				</p>
				<p>
					<form:label path="last_name">Last Name</form:label>
					<form:errors path="last_name" />
					<form:input path="last_name" type="text" />
				</p>
				<input type="submit" value="Create" />
			</form:form>
		</div>
	</section>
</body>
</html>