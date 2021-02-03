<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	

<link rel="stylesheet" href="${ctx}/css/style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<div class="logo">
	<img title="ajc classroom" class="img-responsive" id="header-logo"
		src="http://188.165.51.107/web/css/themes/cool_blue/images/header-logo-custom1.png"
		alt="AJC FORMATION">
</div>

<body>


	<div class="container">
		<jsp:include page="../logout.jsp"></jsp:include>
		<h1>liste des conges</h1>
		<table class="table">
			<tr>
				<th>Date de la demande</th>
				<th>Date de début</th>
				<th>Date de fin</th>
				<th>Type de conges</th>
				<th>Nombre de jours</th>
				<th>Motif de la demande</th>
			
			</tr>
			<c:forEach var="c" items="${conges}">
				<tr>
					<td>${c.demande}</td>
					<td>${c.debut}</td>
					<td>${c.fin}</td>
					
					<td>${c.typec}</td>
					<td>${c.nbr_jours}</td>
					<td>${c.motif}</td>
					
					<td><a href="${ctx}/nouvelleDemande/delete?id=${c.id}"
						class="btn btn-outline-danger">supprimer</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>