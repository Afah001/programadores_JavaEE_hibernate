<%-- 
    Document   : cTarea
    Created on : 16/08/2016, 07:33:11 AM
    Author     : FRAGATA
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Tarea"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Tareas</h1>
        
         <table width="200" border="1">

            <tr>
              <td>PROGRAMADOR</td>
              <td>PROYECTO</td>
              <td>COSTO</td>
              <td>DURACION</td>
              <td>ESTADO</td>
              <td>FECHA</td>
            </tr>
    
            <% for(Tarea t:(List<Tarea>)request.getAttribute("resultado")){ %>
                
                <tr>
                    <td>  <%= t.getProgramador().getNombre() %> </td>
                    <td>  <%= t.getProyecto().getNombre() %> </td>
                    <td>  <%= t.getCosto() %> </td>  <!--costo de la tarea-->
                    <td>  <%= t.getDuracion() %> </td>
                    <td>  <%= t.getEstado() %> </td>
                    <td>  <%= t.getFecha() %> </td>
                </tr>
                
             <% } %>
            
      </table>
      <a href="servlet_Tarea?action=consultarPP">Volver</a>
    </body>
</html>
