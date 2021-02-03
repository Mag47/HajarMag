<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
<link rel="stylesheet" href="${ctx}/css/style.css">

<meta charset="UTF-8">
<title>Nouvelle demande</title>
</head>
<body>
	<div class="login-page">
		<div class="form">
			<p class="title">Nouvelle demande</p>
			<form:form action="" method="post">
			<div class="form-group">
				<form:label path="dateDemande">Date de la demande :</form:label>
				<form:input path="numero" cssClass="form-control" readonly="true" />
			</div>
				<p id="dateDemande" name="dateDemande">Date de la demande :
				<fmt:formatDate pattern="dd/MM/yyyy" value="${conge.demande}" />
					</p>
				Date de début : <input type="date" > <br /> <br /> Date de fin : <input
					type="date"  ><br />
				<br /> Type de congés : <select class="" name="typeConge">
					<option value="choix1">Congés payés</option>
					<option value="choix2">Congés sans solde</option>
					<option value="choix3">Absence autorisée</option>
					<option value="choix4">Absence justifiée</option>
				</select><br /> <br /> Motif de votre demande : <input type="text"
					name="motif"><br /> <br /> <input id="bV" type="submit"
					value="Valider"> <input id="bA" type="reset"
					value="Annuler">
			</form:form>
		</div>
	</div>

</body>
</html>