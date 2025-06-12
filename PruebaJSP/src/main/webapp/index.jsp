<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<%
    String error = null;
    if("POST".equalsIgnoreCase(request.getMethod())){
        String usuario = request.getParameter("username");
        String clave = request.getParameter("pwd");

        if("admin".equals(usuario) && "12345".equals(clave)){
            session.setAttribute("acceso", usuario);
            response.sendRedirect("pagina2.jsp");
            return;
        }else{
            session.invalidate();
            error = "Usuario o contraseña incorrecto";
        }
    }

    if(error != null){ %>
        <br/><p class="error"><%= error %></p><br/>
<% } %>

<form method="post" action="index.jsp">
    <h3>Inicio de Sesión</h3>
    <div class="form-group">
        <label for="username">Usuario:</label>
        <input type="text" id="username" name="username" required>
    </div>
    <div class="form-group">
        <label for="pwd">Contraseña:</label>
        <input type="password" id="pwd" name="pwd" required>
    </div>
    <input type="submit" value="Ingresar" />
</form>

</body>
</html>