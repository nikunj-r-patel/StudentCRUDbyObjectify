<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Students Entry Form</title>
<style type="text/css">
.container {
	background-color: pink;
	width: 50%;
	border: 2px solid gray;
	border-radius: 20px;
	box-shadow: -6px 6px 12px #c5c5c5, -6px 6px 12px #ffffff;
	padding: 20px;
	font-size: 20px;
	margin-left: auto;
	margin-right: auto;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

h1 {
	border-bottom: 1px solid black;
}

#empForm table tr td input {
	padding: 10px;
	font-size: 20px;
	border: none;
	border-radius: 0.5em;
	background: #e8e8e8;
	border: 1px solid #e8e8e8;
	transition: all .3s;
}

.inputLable {
	border-radius: 15px;
	text-align: right;
}

button {
	background-color: pink;
	margin-top: 20px;
	padding: 0.7em 1.7em;
	font-size: 20px;
	border-radius: 0.5em;
	border: 1px solid #e8e8e8;
	transition: all .3s;
	box-shadow: 6px 6px 12px #c5c5c5, -6px -6px 12px #ffffff;
}

button:hover {
	border: 1px solid gray;
}

a {
	text-decoration: none;
}

.outOfContainer {
	background-color: pink;
	margin-top: 20px;
	padding: 0.7em 1.7em;
	font-size: 20px;
	border-radius: 0.5em;
	border: 2px solid aqua;
	transition: all .3s;
	box-shadow: 6px 6px 12px #c5c5c5, -6px -6px 12px #ffffff;
	font-size: 20px;
	padding: 10px;
	margin-right: auto;
	display: flex;
	flex-direction: row;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Add New Student</h1>
		<form id="empForm" action="<%=request.getContextPath()%>/insert"
			method="post">
			<table>
				<tr>
					<td class="inputLable">Enter Student Name:</td>
					<td><input type="text" name="stdName"
						placeholder="enter name " required="required"></td>
				</tr>
				<tr>
					<td class="inputLable">Enter Student Email:</td>
					<td><input type="email" name="stdEmail"
						placeholder="enter email " required="required"></td>
				</tr>
				<tr>
					<td class="inputLable">Enter Student City:</td>
					<td><input type="text" name="stdCity"
						placeholder="enter city " required="required"></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<button type="submit">Register</button>&nbsp;&nbsp;
						<button type="reset">Reset</button>
					</td>
				</tr>
			</table>
		</form>
		<br>
		<div class="outOfContainer">
			<a href="<%=request.getContextPath()%>/StudentController">See All
				Students</a>
		</div>
	</div>
</body>
</html>