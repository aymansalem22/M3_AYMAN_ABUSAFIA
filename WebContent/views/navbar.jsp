<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Users Website</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath}/all">Home</a></li>
      <li><a href="#">Profile</a></li>
      <li><a href="#">About us</a></li>
      <li><a href="${pageContext.request.contextPath}/logout">logout</a></li>
    </ul>
  </div>
</nav>