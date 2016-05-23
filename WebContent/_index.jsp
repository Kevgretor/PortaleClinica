<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>SIW-JEE-ES2</title>
</head>
<body>
	<f:view>
		<h:form>
			<h:commandLink action="login.jsp" value="Accedi"
					rendered="#{!login.loggedIn}" />
					<h:outputText rendered="#{login.loggedIn}">Benvenuto ${login.username}</h:outputText>
			<h:commandLink action="#{login.logout}" value="Esci"
					rendered="#{login.loggedIn}" />
		</h:form>
		<h:form>
			<li><h:commandLink action="#{esameController.listEsami}"
					value="List all Esami" /></li>
			<li><h:commandLink
					action="#{esameController.findEsameDiUtente(9)}"
					value="Esami utente 9" /></li>
			<li><h:commandLink
					action="#{tipologiaEsameController.listTipologiaEsame}"
					value="Consulta Tipologie di Esame" /></li>
					<li><h:commandLink
					action="#{esameCreatorController.newEsame}"
					value="Crea nuovo esame" /></li>
		</h:form>
		<br>
		<br>
	</f:view>
</body>
</html>

