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
<title>Course Setup</title>
<%@ include file="/includes/links.jsp" %>
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container-fluid pg-content">
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8 ">
			<div class="row">
				<div class = "col-md-12">
					<h1><i class="fa fa-plus-square" aria-hidden="true"></i> Course Details</h1>
				</div>
			</div>
		
			<form action="/caps/CourseSetup" method="post">
				<div class="row">
					<input type="hidden" name="courseId" value="${course.courseId}" />
				</div>
				
				<div class="row" style="margin-bottom:10px;">
					<div class="col-md-12">
						<div class="form-group">
							<label class="control-label col-md-3" for="id_course_code">Course Code:</label>
							<div class="col-md-9">
								<input required="required" type="text" class="form-control" name="courseCode" id="id_course_code" 
									value="${course.courseCode}" placeholder="Course Code"/>
                    				
							</div>
						</div>
					</div>
				</div>
				
				<div class="row" style="margin-bottom:10px;">
					<div class="col-md-12">
						<div class="form-group">
							<label class="control-label col-md-3" for="id_course_name">Course Name:</label>
							<div class="col-md-9">
								<input required="required" type="text" class="form-control" name="courseName" id="id_course_name"
									value="${course.courseName}" placeholder="Course Name"/>
							</div>
						</div>
					</div>
				</div>
				
				
				<div class="row" style="margin-bottom:10px;">
					<div class="col-md-12">
						<div class="form-group">
							<label class="control-label col-md-3">Lecturer:</label>
							<div class="col-md-9">
								<select required="required" name="lecturerID" class="form-control">
									<option>Select Lecturer</option>
									<c:forEach var="lecturer" items="${lecturers}">
										<option value="${lecturer.lecturerID }" <c:if test="${course.lecturerID == lecturer.lecturerID}">selected</c:if>>
											${lecturer.firstName }
										</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row" style="margin-bottom:10px;">
					<div class="col-md-12">
						<div class="form-group">
							<label class="control-label col-md-3" for="id_start_date">Start Date:</label>
							<div class="col-md-9">
								<input required="required" type="date" class="form-control" placeholder="yyyy-MM-dd" id="id_start_date" name="startdate" value="${course.startDate}"/> 
							</div>
						</div>
					</div>	
				</div>
				
				<div class="row" style="margin-bottom:10px;">
					<div class="col-md-12">
						<div class="form-group">
							<label class="control-label col-md-3" for="id_end_date">End Date:</label>
							<div class="col-md-9">
								<input required="required" type="date" class="form-control" placeholder="yyyy-MM-dd" id="id_end_date" name="enddate" value="${course.endDate}"/>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row" style="margin-bottom:10px;">
					<div class="col-md-12">
						<div class="form-group">
							<label class="control-label col-md-3" for="id_class_size">Class Size:</label>
							<div class="col-md-9">
								<input required="required" type="number" class="form-control" placeholder="Class Size" id="id_class_size" name="classsize" value="${course.classSize}"/>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row" style="margin-bottom:10px;">
					<div class="col-md-12">
						<div class="form-group">
							<label class="control-label col-md-3" for="id_credit">Credit:</label>
							<div class="col-md-9">
								<input required="required" type="number" class="form-control" placeholder="Credit" id="id_credit" name="credit" value="${course.credit}"/>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row" style="margin-bottom:10px;">
					<div class="col-md-3"></div>
					<div class="col-md-3"><input class="btn btn-primary btn-block" type="submit" value="Submit" id="btnAddCourse"></div>
					<div class="col-md-3"><input class="btn btn-default btn-block" type="button" value="Cancel" onclick="javascript:window.location.href ='/caps/ListCourseServlet';"></div>
					<div class="col-md-3"></div>
				</div>
			</form>
			
		</div>
		<div class="col-md-2"></div>
	</div>
</div>

</body>
</html>