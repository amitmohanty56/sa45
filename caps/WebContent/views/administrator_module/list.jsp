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
<title>List of Courses</title>
<%@ include file="/includes/links.jsp" %>
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container-fluid pg-content">
	<div class="row">		
		<div class="col-md-12"> 
		
			<div class="row">
				<div class = "col-md-3">
					<h1><i class="fa fa-book" aria-hidden="true"></i> List of Courses</h1>
				</div>
				<div class = "col-md-2" >
					<a class="btn btn-primary" href="/caps/CourseSetup?action=insert" style="margin-top: 25px;">Add Course</a>
				</div>
			</div>
			
			<div class="table-responsive">
				<display:table name="courses" pagesize="5" requestURI="" id="course" class="table table-hover">
					<display:column property="courseId" title="#" />
					<display:column property="courseCode" title="Code" />
					<display:column property="courseName" title="Course Name" />
					<display:column property="lecturerName" title="Lecturer" />
					<display:column property="startDate" title="Start Date" />
					<display:column property="endDate" title="End Date" />
					<display:column property="classSize" title="Class Size" />
					<display:column property="enrolledSize" title="No.of Enrollments" />
					<display:column property="credit" title="Credit" />
					<display:column>
						<a class="btn btn-default" href="/caps/ListEnrolledStudents?courseId=<c:out value="${course.courseId }"/>">Enrollments</a>
					</display:column>
					<display:column>
						<a class="btn btn-warning" href="/caps/CourseSetup?action=edit&courseId=<c:out value="${course.courseId }"/>">Edit</a>
					</display:column>
					<display:column>
						<a class="btn btn-danger" href="/caps/CourseSetup?action=delete&courseId=<c:out value="${course.courseId }"/>">Delete</a>
					</display:column>
				</display:table>
			</div>
		</div>
		
	</div>
</div>


</body>
</html>