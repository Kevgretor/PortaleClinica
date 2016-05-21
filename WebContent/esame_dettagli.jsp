<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Esame</title>
</head>
<body>
<h1>Dettaglio esame n^ ${esameController.esame.id}</h1>
	<f:view>
		<h:form>
			<li>Nome: ${esameController.esame.medico.nome}</li>
			<li>Medico: ${esameController.esame.medico.nome}</li>
			<li>Tipo di Esame: ${esameController.esame.tipologiaEsame.nome}</li>
			<li>Data Esame: ${esameController.esame.dataEsame}</li>
			<li>Data Prenotazione: ${esameController.esame.dataPrenotazione}</li>
		</h:form>
	</f:view>
</body>
</html>