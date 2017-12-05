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

<script language='javascript'>
if(<%=request.getAttribute("isAbleToEnroll")%>==-1){
	alert('already enrolled this course');
}
else if(<%=request.getAttribute("isAbleToEnroll")%>==0)
{
	alert('size full');
}else if(<%=request.getAttribute("isAbleToEnroll")%>==1){
	alert('enroll successful');
}
</script>

</head>
<body>
<div class="container-fluid pg-content">
	<div class="row">
		<div class="col-md-12 pg-content">
			
			<div class="row">
				<div class="col-md-3">
					<h1><i class="fa fa-book" aria-hidden="true"></i> Course List</h1>
				</div>
			</div>
			
			<!-- <div class="row">
				<input type="text" name="searchInput" value="">
				<input type="submit" value="search">
			</div> -->
			
			<div class="table-responsive">
				<display:table name="courses" pagesize="5"  requestURI="" id="course" class="table table-hover">
					<display:column property="courseCode" title="Course Code"/>
					<display:column property="courseName" title="Course Name"/>
					<display:column property="lecturerName" title="Lecturer"/>
					<display:column property="startDate" title="Schedule"/>
					<display:column>
							<c:url var="detailPage" value="CourseDetailServlet"
								scope="request">
								<c:param name="courseCode" value="${course.courseCode}"></c:param>
								<c:param name="courseID" value="${course.courseId}"></c:param>
								<c:param name="courseName" value="${course.courseName}"></c:param>
								<c:param name="startDate" value="${course.startDate}"></c:param>
								<c:param name="endDate" value="${course.endDate}"></c:param>
								<c:param name="classSize" value="${course.classSize}"></c:param>
								<c:param name="enrollSize" value="${course.enrolledSize}"></c:param>
								<c:param name="lecturerID" value="${course.lecturerID}"></c:param>
							</c:url>
							<a class="btn btn-primary" href="${detailPage}">Detail</a>
						</display:column>
					<display:column>
							<c:url var="enrollPage" value="EnrollCourseServlet"
								scope="request">
								<c:param name="courseID" value="${course.courseId}"></c:param>
								<c:param name="requestURL"
									value="/views/student_module/home.jsp"></c:param>
							</c:url>
							<c:choose>
								<c:when test='${course.isEnrolled == 0}'>
									<a class="btn btn-warning" href="${enrollPage}">Enroll</a>
								</c:when>
								<c:when test='${course.isEnrolled == 1}'>
									<c:out value="Enrolled" />
								</c:when>
							</c:choose>
						</display:column>
					
				</display:table>
			
			<div class="table-responsive">
			</div>
			
		</div>
	</div>
</div>

</body>
</html>