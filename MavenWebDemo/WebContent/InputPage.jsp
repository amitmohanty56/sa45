<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/MavenWebDemo/Servlet1" method="post">

		<table>
			<tr>
				<td >DATA 1 (REQUEST SCOPE)</td>
				<td><input type="text" id="data1" name="data1" /></td>
			</tr>
			<tr>
				<td >DATA 2 (SESSION SCOPE)</td>
				<td><input type="text" id="data2" name="data2" /></td>
			</tr>
			<tr>
				<td >DATA 3 (APPLICATION SCOPE)</td>
				<td><input type="text" id="data3" name="data3" /></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="SUBMIT WAT ELSE?" />
				</td>

			</tr>
		</table>

	</form>
</body>
</html>