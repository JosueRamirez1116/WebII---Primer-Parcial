<%--
  Created by IntelliJ IDEA.
  User: KJ_Al
  Date: 2/6/2025
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Pagina interna</title>
    <link rel="stylesheet" type="text/css" href="css/style2.css">
</head>
<body>
    <%@ include file="menu.jsp"%>

    <%
    String usuario = (String)session.getAttribute("acceso");
    boolean ingresoCorrecto = false;

    if(usuario != null){
        session.setAttribute("acceso", usuario);
        ingresoCorrecto = true;
    }else{
        session.invalidate();
        response.sendRedirect("index.jsp");
    }


    if(ingresoCorrecto){
    %>
    <br><p>Usuario: <%= usuario%></p>
    <p>Obteniendo información de Request</p>
    IP: <%= request.getRemoteAddr() %><br>
    Host: <%= request.getRemoteHost() %><br>
    ServerName: <%= request.getServerName()%><br>

    <form method="post">
        <div class="form-group">
            <label for="username">Numero 1:</label>
            <input type="text" name="numero1" />
        </div>
        <div class="form-group">
            <label for="username">Numero 2: </label>
            <input type="text" name="numero2" />
        </div>
        <input type="submit" value="Sumar Numeros" />
    </form><br>

    <%! int resultado = 0;
        String mensaje = null;
    %>
    <%
        try{
            mensaje = null;
            if(request.getParameter("numero1") != null && request.getParameter("numero2") != null){
                int numero1 = Integer.parseInt(request.getParameter("numero1"));
                int numero2 = Integer.parseInt(request.getParameter("numero2"));

                resultado = numero1 + numero2;
            }
        }catch(Exception e){
            mensaje = "Favor ingrese unicamente numeros en los campos.";
            resultado = 0;
        }

        if(mensaje == null){
    %>
    <h3>Resultado: <%= resultado %></h3>
    <%
        }
    %>
    <h4><%= mensaje == null? "": mensaje %></h4>
<% }else{%>
<h3>Favor iniciar sesión</h3>
<% } %>

</body>
</html>
