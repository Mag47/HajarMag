<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<meta charset="UTF-8">
<title>Gestion des Congés</title>
</head>
<body>
	<div class="logo">
		<img title="ajc classroom" class="img-responsive" id="header-logo"
			src="http://188.165.51.107/web/css/themes/cool_blue/images/header-logo-custom1.png"
			alt="AJC FORMATION">
	</div>
	<div class="container">
		<c:if test="${param.error != null}">
			<div class="alert alert-danger">erreur d'authentification</div>
		</c:if>


		<div id="container">

			<div class="login-page">
				<div class="form">
					<form class="login-form" action="" method="POST">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}">
						<p class="title">Connectez-vous</p>
						<input type="email" placeholder="Adresse email" name="username"
							required="required" /> <input type="password"
							placeholder="Mot de passe" name="password" required="required" />
						<button class="button">Se connecter</button>
						<a href="${ctx}" class="btn btn-outline-warning">annuler</a>
					</form>
				</div>
			</div>
		</div>
</body>
</html>