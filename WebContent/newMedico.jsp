<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@page buffer="500kb" autoFlush="true" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>New Medico</title>
</head>
<body>
<f:view>
<h:form>
    <div>Name: <h:inputText value="#{medicoController.nome}" 
                     required="true"
                     requiredMessage="Nome is mandatory"
                     id="nome"/> <h:message for="nome" />
	</div> 
    <div>Cognome: <h:inputText value="#{medicoController.cognome}" 
                     required="true"
                     requiredMessage="Cognome is mandatory"
                     id="cognome"/> <h:message for="cognome" />
	</div>
    <div>Specializzazione: <h:inputText value="#{medicoController.specializzazione}" 
                     required="true"
                     requiredMessage="Specializzazione is mandatory"
                     id="specializzazione"/> <h:message for="specializzazione" />
	</div>
	<div>
		<h:commandButton value="Invia"  action="#{medicoController.createMedico}"/>
	</div>
</h:form> 
</f:view> 
</body>
</html>