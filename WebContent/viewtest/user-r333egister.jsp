<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sign up</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	
	<div class="mt-5 mb-5 container">

		<h1>form register</h1>
		<hr />

		<div class="row">
			<div class="col-md-4">
				<form action="${pageContext.request.contextPath}/all"
					method="POST">
                    	<div class="form-group">
						<label for="first_name"><b>first name</b></label> <input type="text"
							placeholder="Enter Firstname" name="first_name" value="${userr.firstname}"
							required>
					</div>
					
					  	<div class="form-group">
						<label for="last_name"><b>last name</b></label> <input type="text"
							placeholder="Enter Lastname" name="last_name" value="${userr.lastname}"
							required>
					</div>
					 
					<div class="form-group">
						<label for="email"><b>Email</b></label> <input type="text"
							placeholder="Enter email" name="email" value="${userr.email}"
							required>
					</div>
					
						<div class="form-group">
						<label for="age"><b>Age</b></label> <input type="text"
							placeholder="Enter age" name="age" value="${userr.age}"
							required>
					</div>
					
						<div class="form-group">
						<label for="nif"><b>nif</b></label> <input type="text"
							placeholder="Enter NIF" name="nif" value="${userr.nif}"
							required>
					</div>
					
					
					
					
					<div class="form-group">

						<label for="password"><b>Password</b></label> <input
							type="password" placeholder="Enter Password" name="password" value="${userr.password}"
							required>
					</div>
					
					
						<div class="form-group">

						<label for="marital_status"><b>Marital Status</b></label> <input
							type="text" placeholder="single & married " name="marital_status" value="${userr.maritalstatus}"
							required>
					</div>
					

					<input type="hidden" name="id" value="${userr.id}" />

					<button type="submit" class="btn btn-primary mt-3">register</button>
				</form>
			</div>
		</div>
		<a href="${pageContext.request.contextPath}/profile">Back to List</a>
	</div>



	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>