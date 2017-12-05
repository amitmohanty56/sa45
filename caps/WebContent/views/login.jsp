<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login</title>
<%@ include file="/includes/links.jsp" %>
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6 pg-content" style="margin-top: 60px;">
			<h2><i class="fa fa-sign-in" aria-hidden="true"></i> Login</h2> 
			<br>
			<%
				String login_msg=(String)request.getAttribute("error");  
				if(login_msg!=null)
				out.println("<font color=red size=2px>"+login_msg+"</font><br>");
			%>
			<form action="/caps/authenticate" method="post">
				<div class="row" style="margin-bottom:10px;">
					<div class="col-md-12">
						<div class="form-group">
							<label class="control-label col-md-3" for="id_username">User Name:</label>
							<div class="col-md-9">
								<input class="form-control" required="required" type="text" id="id_username" name="username" placeholder="Type Username"/>
							</div>
						</div>
					</div>
				</div>
					
				<div class="row" style="margin-bottom:10px;">
					<div class="col-md-12">
						<div class="form-group">
							<label class="control-label col-md-3" for="id_password">Password:</label>
							<div class="col-md-9">
								<input class="form-control" required="required" type="password" id="id_password" name="password" placeholder="Type Password"/>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row" style="margin-bottom:10px;">
					<div class="col-md-12">
						<input class="btn btn-primary btn-block" type="submit" value="LOGIN">
					</div>
				</div>
				
				
			</form>
		</div>
		<div class="col-md-3"></div>
	</div>
</div>

</body>
</html>