<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projeto Arqdsis</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>


<form action="LoginController.do" method="post" class="well col-sm-6 col-sm-push-3">
	<h1>Login:</h1>	
	<label>Username</label>
	<input type="text" nome="login" id="login" class="form-control">
	<label>Senha</label>
	<input type="password" nome="password" id="password" class="form-control">
	<input type="hidden" name="command" value="FazerLogin" />
	<input type="submit" value="Logar" class="btn btn-primary">

</form>

</body>
</html>