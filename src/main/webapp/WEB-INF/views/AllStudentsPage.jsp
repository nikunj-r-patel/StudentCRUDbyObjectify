<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Of All Students</title>
<style type="text/css">
body {
	overflow: auto;
}
.head {
	font-size: 25px;
}
.table {
	border: 3px solid gray;
	background-color: pink;
	border-radius: 10px;
	border-spacing: 5px;
	padding: 5px;
}
th, td {
	font-size: 20px
}
a {
	font-size: 25px;
	text-decoration: none;
	color: blue;
}
a:visited {
	colour: black;
}
</style>
</head>
<body>
<div class="head">
		<a href="<%=request.getContextPath()%>/register">&larr; Add New
			Student</a>
	</div>
	<br>
	<br>
	<div class=bigBox>
		<table class="table" border="1" width="100%">
			<thead>
				<th>ID</th>
				<th>NAME</th>
				<th>EAMIL</th>
				<th>CITY</th>
				<th colspan="2">EDIT OPTIONS</th>
			</thead>
			<tbody>
				<c:forEach var="student" items="${listOfAllStudents}">
					<tr>
						<td><c:out value="${student.id}" /></td>
						<td><c:out value="${student.name}" /></td>
						<td><c:out value="${student.email}" /></td>
						<td><c:out value="${student.city}" /></td>
						<td><a href="edit?id=<c:out value='${student.id}'/>">Update</a></td>
						<td><a href="delete?id=<c:out value='${student.id}'/>">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>