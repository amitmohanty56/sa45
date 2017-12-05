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
<script type="text/javascript">
		$(document).ready(function() {
			var rowCount = $('#courseGrid tr').length;
			if (rowCount > 1) {
				$("#courseGrid").show();
				$("#noshow").hide();
			} else {
				$("#courseGrid").hide();
				$("#noshow").show();
			}
		});
	</script>
</head>
<body>
<div class="container-fluid pg-content" >
	<div class="row">
		<div class="col-md-12 ">
		
			<div class="row">
				<div class="col-md-3">
					<h1><i class="fa fa-book" aria-hidden="true"></i> Course List</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<label id="noshow" style="display: none">No Courses available!</label>
				</div>
			</div>
			
			<div class="table-responsive">
				<table class="table table-hover" id="courseGrid" style="display: none">
					<thead>
						<tr>
							<th>Course Code</th>
							<th>Course Name</th>
							<th>Start Day</th>
							<th>End Day</th>
							<th>Class Size</th>			
							<th>No. of Enrollment</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${clist}" var="course">
							<tr>
								<td>${course.courseCode}</td>
								<td>${course.courseName}</td>
								<td>${course.startDate}</td>
								<td>${course.endDate}</td>
								<td>${course.classSize}</td>
								<td>${course.enrolledSize}</td>
								<td>
									<c:url var="courseDetailsUrl"
										value="/lecturer/coursedetail" scope="request">
										<c:param name="courseID" value="${course.courseId}"></c:param>
									</c:url> <a class="btn btn-primary" href="${courseDetailsUrl}">Details</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table> 
				
			</div>

	
		</div>
	</div>
</div>
</body>
</html>