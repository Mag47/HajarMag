<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
<title>Nouvelle demande</title>
</head>

<body>

<div class="header-inner-cell">
<jsp:include page="logout.jsp"></jsp:include>
</div>

<div class="login-page">
	<div class="form">
		<p class="title">Nouvelle demande</p>
		<form:form action="save" method="post" modelAttribute="conge">
			<div class="form-group">
				<form:label path="demande">Date de la demande :</form:label>
				<form:input path="demande" cssClass="form-control"  readonly="true" />
			</div>
			<div class="form-group">
				<form:label path="debut">Date de début :</form:label>
				<form:input type="date" path="debut" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="fin">Date de fin :</form:label>
				<form:input type="date" path="fin" cssClass="form-control" />
			</div>	
			
			
			<div class="form-group">
			<form:label path="typec">Type de congés :</form:label>
			<form:select path="typec">
					<form:option value="CongePaye">Congés payés</form:option>
					<form:option value="CongeSansSolde">Congés sans solde</form:option>
					<form:option value="AbsenceAutorise">Absence autorisée</form:option>
					<form:option value="AbsenceJustifie">Absence justifiée</form:option>
			</form:select>
			</div>
			<div class="form-group">
				<form:label path="motif">Motif de votre demande :</form:label>
				<form:input type="text" path="motif" cssClass="form-control" />
			</div>	
			
			
			<div class="form-group">
				<button type="submit" class="button1 btn btn-outline-success">Valider</button>
				<a href="${ctx}/accueil" class="button 1 btn btn-outline-warning">Annuler</a>
			</div>
			
			</form:form>
		</div>
	</div>

</body>
</html>