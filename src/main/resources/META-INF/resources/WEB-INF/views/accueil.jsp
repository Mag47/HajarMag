<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html xmlns:sec="http://www.thymeleaf.org/extras/spring-security">
<head>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
<c:set var="emp" value="${pageContext.request.userPrincipal.principal.utilisateur}"/>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	
<link rel="stylesheet" href="${ctx}/css/style.css">

<meta charset="UTF-8">
<title>Gestion des Congés</title>
</head>
<div class="logo">
	<img title="ajc classroom" class="img-responsive" id="header-logo"
		src="http://188.165.51.107/web/css/themes/cool_blue/images/header-logo-custom1.png"
		alt="AJC FORMATION">
</div>

<body>
<div class="header-inner-cell">
<jsp:include page="logout.jsp"></jsp:include>
</div>
<div sec:authorize="isAuthenticated()">


	<table class="en-tete"> 
		<tr>
			<td colspan="2">Nom :</td>
			<td>${emp.nom}</td>
		</tr>
		<tr>
			<td colspan="2">Prenom :</td>
			<td>${emp.prenom}</td>
		</tr>
		<tr>
			<td colspan="2">Manager :</td>
			<td>${emp.id_manager}</td>
		</tr>
		<tr>
			<td colspan="2">Service :</td>
			<td>${emp.service.libelle}</td>
		</tr>
	</table>


	<div class="title1-center">
		<p class="title1">Gestion des congés</p>
		<a href="${ctx}/nouvelleDemande/add" class="btn btn-outline-light">Nouvelle demande</a>
		<a href="${ctx}/nouvelleDemande/add" class="btn btn-outline-light">Liste de mes demandes</a>
	</div>
</div>
</body>
</html>