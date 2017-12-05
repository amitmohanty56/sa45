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
<title>Lecturer Setup</title>
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
					<h1><i class="fa fa-user-plus" aria-hidden="true"></i> Lecturer Details</h1>
				</div>
			</div>	
	
				<form action="/caps/LecturerSetup" method="post">
				<div class="row">
					<input type ="hidden" name="lecturerID" value="<c:out value="${lecturer.lecturerID}" />"/>
        			<input type ="hidden" name="userID" value="<c:out value="${lecturer.userID}" />"/>
        		</div>
           
            <div class="row" style="margin-bottom:10px;">
				<div class="col-md-12">
					<div class="form-group">
						<label class="control-label col-md-3" for="firstName">First Name:</label> 
						<div class="col-md-9">
							<input required="required" type="text" class="form-control" name="firstName" value="<c:out 
							value="${lecturer.firstName}" />" placeholder="First Name" />
            				
            			</div>
            		</div>
            	</div>
            </div>
            
            <div class="row" style="margin-bottom:10px;">
            	<div class="col-md-12">
            		<div class="form-group">
               			 <label class="control-label col-md-3" for="lastName">Last Name:</label> 
               			 <div class="col-md-9">
               			 	<input required="required" type="text" class="form-control" name="lastName" value="<c:out 
               			 	value="${lecturer.lastName}" />" placeholder="Last Name" />
            			</div>
            		</div>
            	</div>
            </div>
            
          	<div class="row" style="margin-bottom:10px;">
            	<div class="col-md-12">
            		<div class="form-group">
               			<label class="control-label col-md-3" for="email">Email:</label>
               			<div class="col-md-9"> 
               				<input required="required" type="email" class="form-control" name="email" value="<c:out 
               				value="${lecturer.email}" />" placeholder="email address" />
               			</div>
               		</div>
               	</div>
            </div>
            
			<div class="row" style="margin-bottom:10px;">
            	<div class="col-md-12">
            		<div class="form-group">
               			 <label class="control-label col-md-3" for="address">Address:</label> 
               			 <div class="col-md-9">
               			 	<input required="required" type="text" class="form-control" name="address" value="<c:out 
               			 value="${lecturer.address}" />" placeholder="Address" />
           			 	</div>
            		</div>
          	  </div>
           </div>
           
           <div class="row" style="margin-bottom:10px;">
            	<div class="col-md-12">
            		<div class="form-group">
               			 <label class="control-label col-md-3" for="phoneNumber">Phone Number:</label>
               			 <div class="col-md-9"> 
               			 	<input required="required" type='number' class="form-control" name="phoneNumber" 
               			 	value="<c:out value="${lecturer.phoneNumber}" />" placeholder="Phone Number" 
               			 	oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" maxlength = "8"/>
               			 </div>
               		</div>
               	</div>
            </div>
            
             <div class="row" style="margin-bottom:10px;">
            	<div class="col-md-12">
            		<div class="form-group">
               			 <label class="control-label col-md-3" for="description">Description:</label> 
               			 <div class="col-md-9"> 
               				 <input type="text" class="form-control" name="description" value="<c:out 
               				 value="${lecturer.description}" />" placeholder="Description" >
           				 </div>
            		</div>
            	</div>
            </div>
           
           <div class="row" style="margin-bottom:10px;">
				<div class="col-md-3"></div>
				<div class="col-md-3"><input class="btn btn-primary btn-block" type="submit" value="Submit" id="btnAddLecturer"></div>  					
				<div class="col-md-3"><input class="btn btn-default btn-block" type="button" value="Cancel" onclick="javascript:window.location.href ='/caps/ListLecturerServlet';"></div>
				<div class="col-md-3"></div>
			</div>              
		</form>
			
	</div>
	<div class="col-md-2"></div>
	
	</div>
</div>

</body>
</html>