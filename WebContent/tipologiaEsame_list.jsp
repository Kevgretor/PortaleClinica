<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Tipologia Esami</title>
</head>
<body>
	<f:view>
		<h1>Tipologia Esami</h1>
		<h:form>
			<table>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Prezzo</th>
				</tr>
				<c:forEach var="te" items="#{tipologiaEsameController.tesami}">
					<tr>
						<td>${te.id}</td>
						<td><h:commandLink
								action="#{tipologiaEsameController.findTipologiaEsame}"
								value="#{te.nome}">
								<f:param name="id" value="#{te.id}" />
							</h:commandLink></td>
						<td>${te.costo}</td>
					</tr>
				</c:forEach>
			</table>
		</h:form>

	</f:view>
</body>
</html>