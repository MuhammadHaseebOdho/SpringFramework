<%@page import="spring.mvc.crud.entities.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Student</title>
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
	transition: background-color 0.3s;
}

.container {
	margin: 20px;
	padding: 20px;
	background-color: white;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

form {
	max-width: 600px;
	margin: auto;
}

label {
	display: block;
	margin-bottom: 10px;
}

input, select {
	width: 100%;
	padding: 10px;
	margin-bottom: 15px;
	box-sizing: border-box;
}

.crud-buttons {
	margin-top: 10px;
}

.crud-buttons button {
	padding: 10px;
	margin: 0 5px;
	cursor: pointer;
}

.styled-button {
	display: inline-block;
	padding: 10px 20px;
	text-decoration: none;
	color: #fff;
	background-color: #4CAF50;
	border: 1px solid #4CAF50;
	border-radius: 5px;
	font-weight: bold;
	text-align: center;
	cursor: pointer;
	transition: background-color 0.3s;
}

.nav-bar-hover:hover, .styled-button:hover {
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
			<a class="nav-bar-hover" href="/SpringMvcCrud/home">Home</a> 
			<a class="nav-bar-hover" href="/SpringMvcCrud/addStudent">Add New Student</a>

		</center>
	</nav>
<% Student student=(Student)request.getAttribute("student"); %>
	<div class="container">
		<form action="/SpringMvcCrud/editstudent" method="post">
			<input type="hidden" id="id" name="id" value="<%= student.getId() %>">
			<label for="name">Student Name:</label>
			<input type="text" id="name" name="name" value="<%= student.getName() %>" required> 
			<label for="rollNumber">RollNumber:</label>
			<input type="text" id="rollNumber" name="rollNumber" value="<%= student.getRollNumber() %>" required> 
			<label for="department">Department:</label> 
			<input type="text" id="department" name="department" value="<%= student.getDepartment() %>" required>
			<label for="age">Age:</label> 
			<input type="text" id="age" name="age" value="<%= student.getAge() %>" required>


			<div class="crud-buttons">
				<button type="submit" class="styled-button">Update</button>
				<button type="button" onclick="window.location.href='/SpringMvcCrud/home'"
					class="styled-button">Cancel</button>
			</div>
		</form>
	</div>

</body>
</html>