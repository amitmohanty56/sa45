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
<title>Enrollments</title>
<%@ include file="/includes/links.jsp"%>
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
		$(document).ready(function() {
			var rowCount = $('#studentGrid tr').length;
			if (rowCount > 1) {
				$("#studentGrid").show();
				$("#noshow").hide();
			} else {
				$("#studentGrid").hide();
				$("#noshow").show();
			}
		});
		
	</script>
</head>
<body>
<div class="container-fluid pg-content">
	<div class="row">
		<div class="col-md-12">
			
			<div class="row">
				<h1><i class="fa fa-book" aria-hidden="true"></i> ${course.courseCode } - ${course.courseName}</h1>
			</div>
			
			<div class="row">
				<div class="col-md-8">
					<div class="table-responsive" style="margin-right: 50px;">
						<table class="table table-bordered">
							<tr>
								<td><b>Course Code: </b></td>
								<td>${course.courseCode }</td>
							</tr>
							<tr>
								<td><b>Course Name: </b></td>
								<td>${course.courseName }</td>
							</tr>
							<tr>
								<td><b>Start Date: </b>
								<td>${course.startDate }</td>
							</tr>
							<tr>
								<td><b>End Date:</b>
								<td>${course.endDate }</td>
							</tr>
							<tr>
								<td><b>Class Size:</b></td>
								<td>${course.classSize }</td>
							</tr>
							<tr>
								<td><b>No.of enrollment:</b></td>
								<td>${course.enrolledSize }</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			
			<div class="row">
				<h1><i class="fa fa-users" aria-hidden="true"></i> Students</h1>
			</div>
			
			<div class="row">
				<div class="col-md-3">
					<label id="noshow" style="display: none">No Students Available!</label>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-8">
					<form action="saveGrade" method="post">
						<div class="table-tableresponsive" style="margin-right:50px;">
							<display:table name="lstStudents" pagesize="5" requestURI="" class="table table-hover" id="studentGrid">
								<display:column title="#" property="studentID"/>
								<display:column title="First Name" property="firstName"/>
								<display:column title="Last Name" property="lastName"/>
								<display:column title="Credit" property="credit"/>
								<display:column title="Grade" property="grade"/>
							</display:table>
						</div>
					</form>
				</div>
			</div>
			
		</div>
	</div>
</div>

</body>
</html>