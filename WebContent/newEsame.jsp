<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>New Medico</title>
</head>
<body>
	<f:view>
		<h:form>
		<table>
				<tr>
					<th>Paziente</th>
					<th>Medico</th>
					<th>Tipologia Esame</th>
					<th>Data</th>
				</tr>
				<tr>
					<th>
				<h:selectOneMenu id="utente" value="#{esameCreatorController.utente_id}">
					<f:selectItems value="#{esameCreatorController.utenti}" var="p"
						itemLabel="#{p.nome} #{p.cognome}" itemValue="#{p.id}" />
				</h:selectOneMenu>
					</th>
					<th><h:selectOneMenu id="medico"
							value="#{esameCreatorController.medico_id}">
							<f:selectItems value="#{esameCreatorController.medici}" var="p"
								itemLabel="#{p.nome} #{p.cognome}" itemValue="#{p.id}" />
						</h:selectOneMenu></th>
					<th><h:selectOneMenu id="tipologiaEsame"
							value="#{esameCreatorController.tipologiaEsame_id}">
							<f:selectItems value="#{esameCreatorController.tipologiaEsami}" var="p"
								itemLabel="#{p.nome}" itemValue="#{p.id}" />
						</h:selectOneMenu></th>
					<th> <h:inputText value="#{esameCreatorController.dataEsame}" id="dataEsame">
							<f:convertDateTime pattern="dd-MM-yyyy"/> 
							</h:inputText> </th>
						</table> 
			<div>
				<h:commandButton value="Invia"
					action="#{esameCreatorController.createEsame}" />
			</div>
		</h:form>
	</f:view>
</body>
</html>