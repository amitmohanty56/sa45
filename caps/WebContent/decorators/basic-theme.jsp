<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
<title><decorator:title/></title>
<%@ include file="/includes/links.jsp" %>
<decorator:head />
</head>

<body>
	<div class="whole-content">
		<!-- navigation bar -->
		<div class="container-fluid nav-css">
			<div class="row">
				<!-- <div class="col-md-2"></div> -->
				<div class="col-md-12">
					<%@ include file="/includes/header.jsp" %>
				</div>
				<!-- <div class="col-md-2"></div> -->
			</div>
		</div>
		
		<!-- body content -->
		<decorator:body/>
		
	</div>
</body>
</html>

