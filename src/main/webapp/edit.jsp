<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="update" name="fn">
		<table border="1" align="center">
			<input hidden type="text" name="uid" value="${data.uid}">
			
			<tr>
				<td>NAME:-</td>
				<td><input type="text" name="name" value="${data.name}"></td>
			</tr>
			<tr>
				<td>UNAME:-</td>
				<td><input type="text" name="uname" value="${data.uname}"></td>
			</tr>
			<tr>
				<td>PASSWORD:-</td>
				<td><input type="text" name="upass" value="${data.upass}"></td>
			</tr>
			<tr>
				<td>Mobile NO:-</td>
				<td><input type="text" name="mobileno" value="${data.mobileno}"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update"></td>
			</tr>
		</table>
			</form>
	

</body>
</html>