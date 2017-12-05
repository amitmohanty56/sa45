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
<title>List of Students</title>
<%@ include file="/includes/links.jsp"%>
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container-fluid pg-content">
	<div class="row">
		<div class="col-md-12 ">

			<div class="row">
				<div class = "col-md-3">
					<h1><i class="fa fa-users" aria-hidden="true"></i> List of Students</h1>
				</div>
					
				<div class = "col-md-2" >
					<a class="btn btn-primary" href="StudentSetup?action=addStudent" style="margin-top: 25px;">Add Student</a>
				</div>
			</div>
				
				<div class="table-responsive">
					<display:table name="studentList" pagesize="5" requestURI="" id="student" class="table table-hover">
						<display:column property="studentID" title="#"/>
						<display:column property="firstName" title="First Name"/>
						<display:column property="lastName" title="Last Name"/>
						<display:column property="email" title="Email"/>
						<display:column property="phoneNumber" title="Phone Number"/>
						<display:column property="address" title="Address"/>
						<display:column>
							<a class="btn btn-warning" href="StudentSetup?action=editStudent&studentID=<c:out value="${student.studentID }"/>">Edit</a>
						</display:column>
						<display:column>
							<a class="btn btn-danger" href="StudentSetup?action=deleteStudent&studentID=<c:out value="${student.studentID }"/>">Delete</a>
						</display:column>
					</display:table>
					
			</div>
		</div>
	</div>
</div>
</body>
</html>