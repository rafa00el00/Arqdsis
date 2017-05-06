<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Usuario</title>

</head>
<body>
<c:import url="/menu.jsp"></c:import>
	<div class="container">
		<form action="CrudController.do" method="post"
			class="panel panel-primary col-xs-12 col-md-6 col-md-offset-3">

			<header class="panel-heading">
			<h3>Conjunto</h3>
			</header>

			<div class="form-group">
				<label>N�mero do Conjunto:</label> 
				<input type="text" name="nrConjunto" value="${entidade.nrConjunto}"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Andar:</label> 
				<input type="text" name="andar" value="${entidade.andar}"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Alugel:</label> <input type="text" name="alugel"
					value="${entidade.Alugel}" class="form-control" />
			</div>
			<div class="form-group">
				<label>Tamanho:</label> <input type="number" name="tamanho"
					value="${entidade.tamanho}" class="form-control" />
			</div>
			
			
			
			<div class="form-group">
				<input type="hidden" name="entidadeName" value="empresa">
				<input type="hidden" name="_method" value="${_metodo}">
				<input type="hidden" name="id" value="${entidade.id}">
	            <input type="hidden" name="idConjunto" value="1">		
			</div>

			<div class="form-group">
				<input type="submit" value="cadastrar"
					class="btn btn-lg btn-primary pull-right">
			</div>
		</form>

	</div>

	
</body>
</html>