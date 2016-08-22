<%-- 
    Document   : rTarea
    Created on : 16/08/2016, 07:33:01 AM
    Author     : FRAGATA
--%>

<%@page import="modelo.Proyecto"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Programador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tarea</h1>
        
        <form action="servlet_Tarea?action=registrar"registrar method="post">
            
            <!--select de Programadores-->
            Elige Programador <select name="programador"> 
                <% for(Programador p:(List <Programador>)request.getAttribute("resultado1")){ %>
                 <option value="<%= p.getId_Programador() %>"><%= p.getNombre()+" "+p.getApellido()  %></option>
                <% } %>
            </select><br><br>
            
            <!--select de Proyecto-->
            Elige Proyecto <select name="proyecto"> 
                <% for(Proyecto py:(List <Proyecto>)request.getAttribute("resultado2")){ %>
                 <option value="<%= py.getId_Proyecto() %>"><%= py.getNombre() %></option>
                <% } %>
            </select><br><br>
            
            Duracion<input name="duracion" type="number"><br><br>
            
            Fecha<input name="fecha" type="date"> <br><br>
          
            <input type="submit" value="Registrar">
            
        </form>
            
            <a href="servlet_Tarea?action=consultar">Lista de Tareas</a><br>
            <a href="servlet_Tarea?action=consultarPP">Volver</a>
    </body>
</html>
