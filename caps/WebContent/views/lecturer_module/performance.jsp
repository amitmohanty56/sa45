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
<title>Home</title>
<%@ include file="/includes/links.jsp"%>
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet" type="text/css"/>

</head>
<body>
<div class="container-fluid pg-content">
	<div class="row">
		<div class="col-md-12">
			<form action="/caps/lecturer/performance" method="get">
				<div class="row" >
				<label id="lblStudent">Student ID:</label>
				<input  required="required" type="text" name="studentid" id="txtStudentID" value="${param['studentid']}" maxlength=20> 
				<input class="btn btn-primary" type="submit" value="Search">
				<input class="btn btn-warning" type="button" id="reset" value="Reset">
				</div>
					
				<div class="row">
					<div class="col-md-6">First Name: <label>${elist[0].firstName }</label></div>
				</div>
				<div class="row">
					<div class="col-md-6">Last Name: <label>${elist[0].lastName }</label></div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="table-responsive">
							<table class="table table-hover">
								<tr>
									<th>Course Code</th>
									<th>Course Name</th>
									<th>Start Date</th>
									<th>End Date</th>
									<th>Grade</th>
									<th>Credit</th>
								</tr>
								<c:forEach items="${elist}" var="enr">
									<tr>
										<td>${enr.courseCode}</td>
										<td>${enr.courseName}</td>
										<td>${enr.startDate}</td>
										<td>${enr.endDate }</td>
										<td>${enr.grade }</td>
										<td>${enr.credit }</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
				
				
			</form>
		</div>
	</div>
</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#reset").click(function() {
				$("#txtStudentID").prop("value", "");
				$("#txtStudentName").prop("value", "");
				
			});
		});
	</script>
</body>
</html>