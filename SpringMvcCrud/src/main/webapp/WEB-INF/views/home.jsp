<%@page import="spring.mvc.crud.entities.Student,java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Management System</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f4f4f4;
}

header {
	background-color: #333;
	color: white;
	padding: 10px;
	text-align: center;
}

nav {
	background-color: #444;
	padding: 10px;
}

nav a {
	color: white;
	text-decoration: none;
	padding: 10px;
	margin: 0 10px;
}

.container {
	margin: 20px;
	padding: 20px;
	background-color: white;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

table, th, td {
	border: 1px solid #ddd;
}

th, td {
	padding: 15px;
	text-align: left;
}

th {
	background-color: #4CAF50;
	color: white;
}

.crud-buttons {
	margin-top: 10px;
}

.crud-buttons button {
	padding: 10px;
	margin: 0 5px;
	cursor: pointer;
}

.button-like {
	display: inline-block;
	padding: 10px 20px;
	text-decoration: none;
	color: #fff;
	background-color: #4CAF50;
	border-radius: 5px;
	font-weight: bold;
	text-align: center;
	cursor: pointer;
	transition: background-color 0.3s;
}

.nav-bar-hover:hover, .button-like:hover {
	background-color: black;
}
</style>
</head>
<body>

	<header>
		<h1>Student Management System</h1>
	</header>

	<nav>
		<center>
			<a class="nav-bar-hover" href="#">Home</a> <a class="nav-bar-hover"
				href="addStudent">Add New Student</a>

		</center>
	</nav>

	<div class="container">
		

		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Roll Number</th>
					<th>Department</th>
					<th>Age</th>
					<th>Action</th>
				</tr>
			</thead>

					<%
					List<Student> list=(List<Student>) request.getAttribute("studentsList");
			for (Student student : list) {
			%>
			<!-- Display book records here -->
			<tr>
				<td><%= student.getName() %></td>
				<td><%=student.getRollNumber()%></td>
				<td><%=student.getDepartment()%></td>
				<td><%=student.getAge()%></td>
			<td>
				<div class="crud-buttons">
					<a href="editstudentform/<%= student.getId() %>" class="button-like">Edit</a>
						<a href="deletestudent/<%= student.getId() %>" class="button-like">Delete</a>

				</div>
			</td>
			</tr>
			<%
			 } 
			%>



		</table>
	</div>

</body>
</html>