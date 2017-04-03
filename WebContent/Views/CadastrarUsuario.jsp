<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form action="../CrudController.do" method="post"
			class="panel panel-primary col-xs-12 col-md-6 col-md-offset-3">

			<header class="panel-heading">
			<h3>Cadastro Usuario</h3>
			</header>

			<div class="form-group">
				<label>CPF:</label> <input type="text" name="cpf" value="456"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Empresa:</label> <select value=1 name="idEmpresa"
					class="form-control">
					<option>Selecione...</option>
					<option value=1>Oi</option>
				</select>
			</div>
			<div class="form-group">
				<label>Hora Acesso:</label> <input type="time" name="horaAcesso"
					value="08:30" class="form-control" />
			</div>
			<div class="form-group">
				<label>Hora Saida:</label> <input type="time" name="horaSaida"
					value="08:30" class="form-control" />
			</div>
			<div class="form-group">
				<label>Login:</label> <input type="text" name="login" value="rafa"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>senha:</label> <input type="password" name="senha"
					value="123" class="form-control" />
			</div>
			<div class="form-group">
				<label>nome:</label> <input type="text" name="nome" value="rafa"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>perfil:</label> <select name="perfil" value="Admin"
					class="form-control">
					<option>Selecione...</option>
					<option value="Admin">Administrador</option>
					<option value="comum">Comum</option>
					<option value="comumComPrivilegio">Comum com Privilegio</option>
				</select>
			</div>
			<div class="form-group">
				<input type="hidden" name="entidaName" value="usuario">
			</div>

			<div class="form-group">
				<input type="submit" value="cadastrar"
					class="btn btn-lg btn-primary pull-right">
			</div>
		</form>

	</div>

	<script type="text/javascript" scr="../js/npm.js"></script>
	<script type="text/javascript" scr="../js/bootstrap.min.js"></script>
</body>
</html>