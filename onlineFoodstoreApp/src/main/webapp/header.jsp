<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!--Bootstrap css-->
<link rel="stylesheet" href="css/bootstrap.min.css" />
<!--font css-->
<link rel="stylesheet" href="css/all.min.css" />
<!--jquerry-->
<script src="js/jquery-3.6.0.min.js"></script>

<title>Insert title here</title>
</head>
<body>

	<!-- nav bar started -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp">Food-Store</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link">Contact Us</a></li>
					<core:if test="${sessionScope.user != null}">
						<li class="nav-item"><a class="nav-link active" aria-current="page" href="index.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="do.foodoperation?action=showfoodlist">Menu</a></li> 
						<li class="nav-item"><a class="nav-link">DEMO</a></li>
						<li class="nav-item"><a class="nav-link">WELCOME ${sessionScope.user.first_Name}</a></li>
						<core:if test="${sessionScope.user.type == 'Admin'}">
							<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"> Dropdown </a>
								<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
									<li class="nav-item"><a class="nav-link" href="AddFood.jsp">Add FOOD</a></li>
										<li class="nav-item"><a class="nav-link" href="do.foodoperation?action=showuserlist">UserList</a></li>
										<li class="nav-item"><a class="nav-link" href="Adduser.jsp">Add User</a></li>
									<li><hr class="dropdown-divider"></li>
									<li><a class="dropdown-item" href="#">Something elsehere</a></li>
								</ul>
							</li>
						</core:if>
						<li class="nav-item"><a class="nav-link" href="do.foodoperation?action=userlogout">Signout</a></li>
					</core:if>
					<core:if test="${sessionScope.user == null}"> 
						<li class="nav-item"><a class="nav-link">DEMO1</a></li>
						<li class="nav-item"><a class="nav-link" href="do.foodoperation?action=showfoodlist">Menu</a></li>
						<li class="nav-item"><a class="nav-link" href="#">About Us</a></li>
						<li class="nav-item"><a class="nav-link active" aria-current="page" href="index.jsp">Home</a></li>
					</core:if> 	 	
				</ul>
			</div>
		</div>
	</nav>
	<!-- nav bar ended -->
