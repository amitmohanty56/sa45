<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%
    session=request.getSession();
    if(session.getAttribute("profile")==null)
    {
        response.sendRedirect("/caps/views/login.jsp");
    }

%>
<html>
<head>
<title>CourseDetail</title>
<%@ include file="/includes/links.jsp"%>
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container-fluid pg-content">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<h1><i class="fa fa-book" aria-hidden="true"></i> ${param.courseCode} - ${param.courseName }</h1>
			</div>
			
			<div class="row">
				<div class="col-md-8">
					<div class="table-responsive" style="margin-right:50px;">
						<table class="table table-bordered">
							<tr>
								<td><b>Course Code:</b></td>
								<td>${param.courseCode }</td>
							</tr>
							<tr>
								<td><b>Course Name:</b>
								<td>${param.courseName }</td>
							</tr>
							<tr>
								<td><b>Start Date: </b>
								<td>${param.startDate }</td>
							</tr>
							<tr>
								<td><b>End Date:</b>
								<td>${param.endDate }</td>
							</tr>
							<tr>
								<td><b>Lecturer Name:</b></td>
								<td>${lecturer.firstName } ${lecturer.lastName }</td>
							</tr>
							<tr>
								<td><b>Class Size:</b></td>
								<td>${param.classSize }</td>
							</tr>
							<tr>
								<td><b>No.of enrollment:</b></td>
								<td>${param.enrollSize }</td>
							</tr>
							
						</table>
						<input class="btn btn-primary" type="button" value="Back" onclick="javascript:window.location.href ='/caps/ListCourseServlet';">
					</div>
				</div>
				<div class="col-md-6"></div>
			</div>
			
		</div>
	</div>
</div>
	

</body>
</html>