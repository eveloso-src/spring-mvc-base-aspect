<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hola mundo</title>
</head>
<body>
	<h2>${message}</h2>
	<h4>Server date time is : ${date} 
	<div>
		usuario: <input type="text" id="user"/>
	</div>

	<div>
		contraseña: <input type="password" id="password"/>
	</div>
	
	<a href="login">continuar</a></h4>
	
</body>
</html>