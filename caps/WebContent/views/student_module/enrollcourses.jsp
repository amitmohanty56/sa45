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
<title>Courses</title>
<%@ include file="/includes/links.jsp" %>
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container-fluid pg-content">
	<div class="row">
		<div class="col-md-12">
		
			<div class="row">
				<div class="col-md-3">
					<h1><i class="fa fa-book" aria-hidden="true"></i> My Courses</h1>
				</div>
			</div>
			
			<div class="table-responsive">
				<display:table name="courses" pagesize="3" requestURI="" id="course" class="table table-hover">
					<display:column property="courseCode" title="Course Code"/>
					<display:column property="courseName" title="Course Name"/>
					<display:column property="startDate" title="Start Date"/>
					<display:column property="endDate" title="End Date"/>
					<display:column property="credit" title="Credit"/>
					<display:column property="grade" title="Grade"/>
				</display:table>
			</div>
		</div>
	</div>
</div>

</body>
</html>