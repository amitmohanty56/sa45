<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    session=request.getSession();
    if(session.getAttribute("profile")==null)
    {
        response.sendRedirect("/caps/views/login.jsp");
    }

%>
<html>
<head>
<title>Student Setup</title>
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
					<h1><i class="fa fa-user-plus" aria-hidden="true"></i> Student Detail</h1>
				</div>
			</div>
			
			<form  action = "/caps/StudentSetup" method="post">
				<div class="row">
					<input type="hidden" name="studentID" value="<c:out value="${student.studentID}" />"/>
        			<input type ="hidden" name="userID" value="<c:out value="${student.userID}" />"/>
        		</div>
        		
        		<div class="row" style="margin-bottom:10px;">
					<div class="col-md-12">
						<div class="form-group">
							<label class="control-label col-md-3" for="firstName">First Name:</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="firstName" id="firstName" 
									value="<c:out value="${student.firstName}"/>" placeholder="First Name" />
							</div>
						</div>
					</div>
				</div>
							
				<div class="row" style="margin-bottom:10px;">
					<div class="col-md-12">
						<div class="form-group">
							<label class="control-label col-md-3" for="lastName">Last Name:</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="lastName" id="lastName"
									value="<c:out value="${student.lastName}"/>" placeholder="Last Name"/>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row" style="margin-bottom:10px;">
					<div class="col-md-12">
						<div class="form-group">
							<label class="control-label col-md-3" for="email">email:</label>
							<div class="col-md-9">
								<input type="email" class="form-control" name="email" id="email" 
									value="<c:out value="${student.email}"/>" placeholder="email Address" />
							</div>
						</div>
					</div>
				</div>
								
				<div class="row" style="margin-bottom:10px;">
					<div class="col-md-12">
						<div class="form-group">
							<label class="control-label col-md-3" for="phone">Phone Number:</label>
							<div class="col-md-9">
								<input type='number' class="form-control" name="phoneNumber" id="phoneNumber" 
									value="<c:out value="${student.phoneNumber}"/>" placeholder="Phone Number" 
									oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" maxlength = "8"/>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row" style="margin-bottom:10px;">
					<div class="col-md-12">
						<div class="form-group">
							<label class="control-label col-md-3" for="address">Address:</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="address" id="address" 
									value="<c:out value="${student.address}"/>"
									placeholder="Address" />
							</div>
						</div>
					</div>
				</div>
				
				<div class="row" style="margin-bottom:10px;">
					<div class="col-md-3"></div>
					<div class="col-md-3"><input class="btn btn-primary btn-block" type="submit" value="Submit" id="btnAddStudent"></div>
					<div class="col-md-3"><input class="btn btn-default btn-block" type="button" value="Cancel" onclick="javascript:window.location.href ='/caps/ListStudentServlet';"></div>
					<div class="col-md-3"></div>
				</div>

			</form>
		</div>
		<div class="col-md-2"></div>
		</div>
	</div>

</body>
</html>


	
				
				