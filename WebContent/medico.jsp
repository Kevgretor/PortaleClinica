<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Inserimento Completato</title>
</head>
<body>
	Inserimento Medico completato!
	
	Ecco i dettagli:
	
	<div>${medicoController.medico.nome}</div>
	<div>${medicoController.medico.cognome}</div>
	<div>${medicoController.medico.specializzazione}</div>
</body>
</html>