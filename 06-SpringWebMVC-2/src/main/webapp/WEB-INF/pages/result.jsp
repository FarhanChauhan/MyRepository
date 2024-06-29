<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Details</title>
</head>
<body>
	<h1 style='color:red;text-align:center'>EMPLOYEE REGUSTERED DATA</h1>
	<center>
		<table border='1'>
			<tr>
			<td>EMPLOYEE NO :</td>
			<td>${employee.eno}</td>
			</tr>
			<tr>
			<td>EMPLOYEE NAME</td>
			<td>${employee.ename}</td>
			</tr>
			<tr>
			<td>EMPLOYEE DESIGNATION</td>
			<td>${employee.desg}</td>
			</tr>
			<tr>
			<td>EMPLOYEE SALARY</td>
			<td>${employee.salary}</td>
			</tr>
		</table>
	</center>
</body>
</html>