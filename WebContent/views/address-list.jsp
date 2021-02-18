<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>List of Addresses</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<jsp:include page="navbar.jsp"></jsp:include>
    <p>
			<button class = "btn btn-primary" onclick="window.location.href = 'views/address-edit.jsp'">Add Address</button>
		</p>
	<div class="container">
		<h2>Detalis of Users</h2>
		<p>you are now in the list of all user that avaliable in our website :</p>
		<table class="table table-dark table-hover">
			<thead>
				<tr>
					<th>Street</th>
					<th>Country</th>
					<th>CodePostal</th>
					
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${addresses}" var="address">
			
				<tr>
					<td>${address.street}</td>
					<td>${address.country}</td>
					<td>${address.codepostal}</td>
				
					<td> 
							<a href = "${pageContext.request.contextPath}/AddressController?action=v&id=${address.id}">show</a>
					|
						<a href = "${pageContext.request.contextPath}/AddressController?action=u&id=${address.id}">edit</a> 
						|
						<a href = "${pageContext.request.contextPath}/AddressController?action=d&id=${address.id}">delete</a> 
					</td>
				</tr>
				
			</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>