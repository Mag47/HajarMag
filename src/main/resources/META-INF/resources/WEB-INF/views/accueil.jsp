<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
<c:set var="emp"
	value="${pageContext.request.userPrincipal.principal.utilisateur}" />

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

		<jsp:include page="logout.jsp"></jsp:include>
<body>

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
		<a href="${ctx}/nouvelleDemande/add" class="btn btn-outline-light">Nouvelle
			demande</a> <a href="${ctx}/nouvelleDemande/list"
			class="btn btn-outline-light">Liste de mes demandes</a>
			
		<sec:authorize access="hasRole('ROLE_ADMINISTRATEUR')">
			<a href="http://localhost:4200" class="btn btn-outline-light">Gestion des employés</a>
		</sec:authorize>
		
		<sec:authorize access="hasRole('ROLE_MANAGER')">
			<a href="${ctx}/nouvelleDemande/list" class="btn btn-outline-light">Validation
				des demandes en attentes</a>
		</sec:authorize>
	</div>
</body>
</html>