<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>License Assignment</title>
</head>
<body>
	<h1><c:out value="${person.first_name} ${person.last_name }"/></h1>
	<h3>License number  <c:out value="${person.licenses.number}"/></h3>
	<h3>State   <c:out value="${person.licenses.state}" /></h3>	
	<h3>Expiration Date   <fmt:formatDate value="${person.licenses.expirationDate}" pattern="MM-dd-yyyy" /></h3>	
</body>
</html>