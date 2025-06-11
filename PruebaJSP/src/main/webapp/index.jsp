<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%@include file="menu.jsp"%>
<h1>Prueba de JSP</h1>

<br>
<form method="post">
    Numero 1: <input type="text" name="num1" id="num1">
    Numero 2: <input type="text" name="num2" id="num2">
    <input type="submit" value="Sumar">
</form>

<%! int resultado = 0;
    String mensaje = null;
%>

<%
    try{
        mensaje = null;
        if(request.getParameter("num1") != null && request.getParameter("num2") !=null){
            int numero1 = Integer.parseInt(request.getParameter("num1"));
            int numero2 = Integer.parseInt(request.getParameter("num2"));

            resultado = numero1 + numero2;
        }
    }catch (Exception e){
            //response.getWriter().println("<p>Favor ingrese unicamente numeros en los campos</p>");

            mensaje = "Favor ingrese unicamente numeros en los campos";
            //<h4>Por favor ingrese solamente numeros.</h4>
            resultado = 0;
    }


    if(mensaje == null){
%>
    <h3>Resultado: <%= resultado%></h3>
<%
    }
%>

<h4><%= mensaje == null? "": mensaje %></h4>


</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>