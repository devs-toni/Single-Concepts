<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form action="POC_Servlet" method="get" id="form" name="form">
		
		<input type="text" id="name" name="name" value="Nombre">
		<input type="text" id="estado" name="state" value="Estado Civil">
		<button type="submit">Pulsa Aqui</button>
	
		 
		
		</form>
		
					 
<script>
<% String error = String.valueOf(request.getAttribute("error"));
	System.out.println(error);
%>
var ent = '<%=error%>'
if (ent=="Error de acceso"){
	alert(ent)
}
</script>
</body>
</html>