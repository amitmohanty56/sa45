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
<title>Course Details</title>
<%@ include file="/includes/links.jsp"%>
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
		$(document).ready(function() {
			$(".enrID").click(function() {
				var id = $(this).data("stdid");
				$("#gradedd-" + id).prop("hidden", false);
				$("#lblGrade-" + id).prop("hidden", true);
				$("#grade-" + id).prop("hidden", true);
				$("#save-" + id).prop("hidden", false);
				$("#cancel-" + id).prop("hidden", false);
			});
			$(".saveStu , .cancelStu").click(function() {
				var id = $(this).data("stdid");
				$("#gradedd-" + id).prop("hidden", true);
				$("#lblGrade-" + id).prop("hidden", false);
				$("#grade-" + id).prop("hidden", false);
				$("#save-" + id).prop("hidden", true);
				$("#cancel-" + id).prop("hidden", true);
				$("#studentIDHdn").prop("value", id);
				debugger;
				var val = $("#gradedd-" + id).val();
				$("#gradeHdn").prop("value", val);
			});
			
			/* 			$(".target").change(function() {
			 var end = this.value;
			 $("#gradeHdn").prop("value", end);
			 });
			 */
		});
		
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
							<table class="table table-bordered" id="studentGrid" style="display: none">
								<thead>
									<tr>
										<th>StudentID</th>
										<th>First Name</th>
										<th>Last Name</th>
										<th>Credit</th>
										<th>Grade</th>
										<th></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${lstStudents}" var="StudentInfo">
										<tr>
											<td>${StudentInfo.studentID }</td>
											<td>${StudentInfo.firstName}</td>
											<td>${StudentInfo.lastName}</td>
											<td>${StudentInfo.credit }</td>
											<td>
												<label id="lblGrade-${StudentInfo.studentID }">${StudentInfo.grade }</label>
												<select class="target" name="grade" id="gradedd-${StudentInfo.studentID}" hidden="true">
													<option value="A">A</option>
													<option value="B">B</option>
													<option value="C">C</option>
													<option value="D">D</option>
													<option value="E">E</option>
													<option value="F">F</option>
												</select>
												<input type="hidden" id="studentIDHdn" name="studentIDHdn" value="${StudentInfo.studentID }" /> 
												<input type="hidden" id="courseIDHdn" name="courseIDHdn" value="${course.courseId }" />
												<input type="hidden" id="gradeHdn" name="gradeHdn" />
											</td>
											<td>
												<input class="enrID" type="Button" id="grade-${StudentInfo.studentID }" data-stdid="${StudentInfo.studentID}" value="Grade Student" />
												<input id="save-${StudentInfo.studentID }" class="saveStu" hidden="true" type="submit" data-stdid="${StudentInfo.studentID}" value="Save" />
												<input type="button" id="cancel-${StudentInfo.studentID }" class="cancelStu" hidden="true" data-stdid="${StudentInfo.studentID}" value="Cancel" /></td>
											<td>
												<c:url var="studentPerformanceUrl" value="/lecturer/performance" scope="request">
													<c:param name="studentid" value="${StudentInfo.studentID}"></c:param>
												</c:url>
												<a class="btn btn-primary" href="${studentPerformanceUrl}">Performance</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</form>
				</div>
			</div>
			
		</div>
	</div>
</div>

</body>
</html>