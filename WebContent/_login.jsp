<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<f:view>
	${login.messaggio }
		<h:form rendered="#{!login.loggedIn}">
		<div>username: <h:inputText value="#{login.username}" 
	                     required="true"
	                     requiredMessage="username is mandatory"
	                     id="username"/> <h:message for="username" />
		</div> 
	    <div>password: <h:inputSecret value="#{login.password}" 
	                     required="true"
	                     requiredMessage="password is mandatory"
	                     id="password"/> <h:message for="password" />
		</div>
		<div>
		<h:commandButton value="Login" action="#{login.login}" />
		</div>
		</h:form>
		<h:form>
	    <h:commandButton value="Logout" action="#{login.logout}" rendered="#{login.loggedIn}"/>
	    </h:form>
		</f:view>
</body>
</html>