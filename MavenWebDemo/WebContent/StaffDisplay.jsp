<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>SOME SILLY MESSAGE</h1>
<jsp:useBean id="staff" class="javabean.Staff" scope="request"/>
<h2>
<jsp:getProperty property="name" name="staff"/>
<br/>
<jsp:getProperty property="nick" name="staff"/>
<jsp:setProperty property="nick" name="staff" value="STUPID"/>
<br/>
<jsp:getProperty property="nick" name="staff"/>
</h2>
</body>
</html>