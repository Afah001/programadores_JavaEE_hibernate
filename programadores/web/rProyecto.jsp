<%-- 
    Document   : rProyecto
    Created on : 16/08/2016, 07:33:28 AM
    Author     : FRAGATA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Proyecto</h1>
        
        <form action="servlet_Proyecto?action=registrar"registrar method="post">
             
            Nombre<input name="nombre" ><br><br>
            Duracion<input name="duracion" type="number"><br><br>
            Cliente<input name="cliente"> <br><br><br>  
          
            <input type="submit" value="Registrar">
            
            
        </form>
        
        <a href="servlet_Proyecto?action=consultar">Lista de Proyectos</a><br>
        <a href="index.jsp">Volver</a>
    </body>
</html>
