<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>
<table>
			<tr>
				<td >DATA 1 (REQUEST SCOPE)</td>
				<td>${d1}</td>
			</tr>
			<tr>
				<td >DATA 2 (SESSION SCOPE)</td>
				<td>${d2}</td>
			</tr>
			<tr>
				<td >DATA 3 (APPLICATION SCOPE)</td>
				<td>${d3}</td>
			</tr>
			
			
		</table>
		
		</h2>
		
		<a href="/MavenWebDemo/Servlet3"> Link to servlet 3</a>
</body>
</html>