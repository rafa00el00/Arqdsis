<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="br.usjt.arqdsis.sisPredial.Models.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Usuario usr = (Usuario)request.getAttribute("entidade");%>
<%= usr.getId()%> - <%= usr.getNome()  %>
<label>CPF:</label><%=usr.getCPF() %><br>
<label>Hora Entrada:</label><%=usr.getHoraAcesso() %><br>
<label>Hora Saida:</label><%=usr.getHoraSaida() %><br>
<label>Login:</label><%=usr.getLogin() %><br>
<label>Privilegio:</label><%=usr.getPerfil().name() %><br>
</body>
</html>