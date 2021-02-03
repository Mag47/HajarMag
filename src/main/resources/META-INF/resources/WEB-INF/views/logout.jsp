<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />

<link rel="stylesheet" href="${ctx}/css/style.css">
<div align="right">
	<form action="${ctx}/logout" method="post" class="form-inline">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}">
		<!--  ${pageContext.request.userPrincipal.name}&nbsp;-->
		<button class="header-item">Se déconnecter</button>
	</form>
</div>