<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>List of users</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<style type="text/css">
	

 .container-fluiddd {
     overflow: hidden;
     margin-top: 250px;
     background: #262626;
     color: #627482 !important;
     margin-bottom: 3px;
     padding-bottom: 3px;
 }

 small {
     font-size: calc(12px + (15 - 12) * ((100vw - 360px) / (1600 - 360))) !important
 }

 .bold-text {
     color: #989c9e !important
 }

 .mt-55 {
     margin-top: calc(50px + (60 - 50) * ((100vw - 360px) / (1600 - 360))) !important
 }

 h3 {
     font-size: calc(34px + (40 - 34) * ((100vw - 360px) / (1600 - 360))) !important
     
 }
 
 .px-2 {
  padding-left: ($spacer * .11) !important;
 
}

 .social {
     font-size: 21px !important
 }

 .rights {
     font-size: calc(20px + (22 - 20) * ((130vw - 370px) / (1600 - 360))) !important
 }
	</style>
</head>
<body>

	<jsp:include page="navbar.jsp"></jsp:include>
    <p>
			<button class = "btn btn-primary" onclick="window.location.href = 'views/user-register.jsp'">Add User</button>
		</p>
	<div class="container">
		<h2>Detalis of Users</h2>
		<p>you are now in the list of all user that avaliable in our website :</p>
		<table class="table table-dark table-hover">
			<thead>
				<tr>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Email</th>
					<th>NIf</th>
					<th>Age</th>
					<th>Marital  Status</th>
					
					<th>Actions</th>
					<th>address-STREET</th>
					<th>address-CODEPOSTAL</th>
					<th>address-COUNTRY</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="userr">
			
				<tr>
					<td>${userr.firstname}</td>
					<td>${userr.lastname}</td>
					<td>${userr.nif}</td>
					<td>${userr.email}</td>
					<td>${userr.age}</td>
					<td>${userr.maritalstatus}</td>
					
					<td> 
							<a href = "${pageContext.request.contextPath}/all?action=VIEW&id=${userr.id}">show</a>
					|
						<a href = "${pageContext.request.contextPath}/all?action=u&id=${userr.id}">edit</a> 
						|
						<a href = "${pageContext.request.contextPath}/all?action=d&id=${userr.id}">delete</a> 
					</td>
								</c:forEach>

					<c:forEach items="${listaddress}" var="address">
					<td>${address.street}</td>
					<td>${address.codepostal}</td>		
                    <td>${address.country}</td>
				</tr>	</c:forEach>
				
			</tbody>
		</table>
	</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
