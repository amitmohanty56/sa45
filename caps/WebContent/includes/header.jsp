<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="navbar-header">
     <a class="navbar-brand" href="/caps/views/login.jsp">CAPS</a>
</div> 
<c:choose>
	<c:when test = '${profile.getRole().equals("administrator")}'>
		<!-- navigation menu for administrator -->
		<ul class="nav navbar-nav">
			<li class="active"><a href="/caps/ListCourseServlet">Courses</a></li>
			<li><a href="/caps/ListLecturerServlet">Lecturers</a></li>
			<li><a href="/caps/ListStudentServlet">Students</a></li>
		</ul>
	</c:when>
	<c:when test = '${profile.getRole().equals("student")}'>
		<!-- navigation menus for students -->
		<ul class="nav navbar-nav">
			<li class="active"><a href="/caps/ListCourseServlet">Home</a></li>
			<li><a href="/caps/ListEnrolledCourse">My Courses</a>
		</ul>
	</c:when>
	<c:when test = '${profile.getRole().equals("lecturer")}'>
		<!-- navigation menus  for lecturer -->
		<ul class="nav navbar-nav">
			<li class="active"><a href="/caps/lecturer/">Home</a></li>
			<li><a href="/caps/views/lecturer_module/performance.jsp">Student's Performance</a>
		</ul>
	</c:when>
</c:choose>

<ul class="nav navbar-nav navbar-right">
	<c:choose>
		<c:when test = "${profile != null}">
			<li><a href="#">${profile.getName() }</a></li>
			<li><a href="/caps/LogOut">Logout</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="/caps/views/login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
		</c:otherwise>
	</c:choose>
		
</ul>