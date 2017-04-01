<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="../CrudController.do" method="post" >
	
	<h3>Cadastro Usuario</h3>
	
	<label>CPF:</label>
	<input type="text" name="cpf" value="456" />
	<br>
	
	<label>Empresa:</label>
	<select value=1 name="idEmpresa" >
		<option>Selecione...</option>
		<option value=1>Oi</option>
	</select>
	<br>
	
	<label>Hora Acesso:</label>
	<input type="time" name="horaAcesso" value="08:30" />
	<br>
	
	<label>Hora Saida:</label>
	<input type="time" name="horaSaida" value="08:30"  />
	<br>
	
	<label>Login:</label>
	<input type="text" name="login" value="rafa" />
	<br>
	
	<label>senha:</label>
	<input type="password" name="senha" value="123" />
	<br>
	
	<label>nome:</label>
	<input type="text" name="nome" value="rafa" />
	<br>
	
	<label>perfil:</label>
	<select name="perfil" value="Admin">
		<option>Selecione...</option>
		<option value="Admin">Administrador</option>
		<option value="comum">Comum</option>
		<option value="comumComPrivilegio">Comum com Privilegio</option>
	</select>
	<br>
	<input type="hidden" name="entidaName" value="usuario">
	<input type="submit" value="cadastrar">
	
</form>
</body>
</html>