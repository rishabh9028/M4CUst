<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="myCss.css" rel="stylesheet">
</head>
<body>
<form:form action = "reg.capg" modelAttribute="bean" method="post">
<table>
<tr><td>Customer Id:</td><td><form:input path = "custId"/></td><td style="color:red"><form:errors path = "custId"/></td></tr>

<tr><td>Customer Name:</td><td><form:input path = "custName"/><form:errors path = "custName"/></td></tr>

<tr><td>Customer mobile:</td><td><form:input path = "mobile"/><form:errors path = "mobile"/></td></tr>

<tr><td>Customer email:</td><td><form:input path = "email"/><form:errors path = "email"/></td></tr>

<tr><td>Customer date-of-birth:</td><td><form:input path = "birthDate"/><form:errors path = "birthDate"/></td></tr>

<tr><td></td><td><input type = "submit" value = "submit"/></td></tr>
</table>
</form:form>
</body>
</html>