<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">




<html lang="en">

<head>

<!-- Required meta tags -->

<meta charset="utf-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>MenuItem Details</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<style type="text/css">
.table {
	border-radius: 5px;
	width: 50%;
	margin: 0px auto;
	float: none;
}
body {
	background:
		url("https://images.wallpapersden.com/image/download/meat-chicken-grilled_45572_2560x1440.jpg")
		no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}
</style>
</head>

<body><nav class="navbar navbar-expand-md navbar-light bg-warning"> <a
		class="navbar-brand" href="/bookstore/${userName}">Welcome to
		Food Mart </a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">

			<li class="nav-item"><a class="nav-link"
				href="admin/add">Add Menuitems</a></li>
				
			<li class="nav-item"><a class="nav-link"
				href="/menuitems/admin/delete">Delete Menuitems</a></li>

		</ul>
		<ul class="nav navbar-nav ml-auto">
			<li class="nav-item"><a class="nav-link" href="/menuitems/">Admin Panel</a></li>
			<li class="nav-item"><a class="nav-link" href="#"> User Panel</a></li>
		</ul>
	</div>
	</nav>
	<br>
	<center>


		<table class="table table-dark table-striped">
			<thead>
				<tr>
					
					<th scope="col">Name</th>
					<th scope="col">Price</th>
					
					<th scope="col">Date of Launch</th>
					<th scope="col">Category</th>
					<th scope="col">Free Delivery</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${menuItem}" var="emp">
					<tr>
					
						<td><c:out value="${emp.name}" /></td>
						<td><c:out value=" Rs ${emp.price}" /></td>
						
						<td><c:out value="${emp.dateOfLaunch}" /></td>
						<td><c:out value="${emp.category}" /></td>
						<td><c:out value="${emp.freeDelivery}" /></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</center>
</body>
</html>