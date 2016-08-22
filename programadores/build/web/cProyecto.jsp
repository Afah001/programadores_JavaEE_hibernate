<%-- 
    Document   : cProyecto
    Created on : 16/08/2016, 07:33:41 AM
    Author     : FRAGATA
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Proyecto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LISTA DE PROYECTOS</h1>
        
        <table width="200" border="1">

            <tr>
              <td>NOMBRE</td>
              <td>DURACION</td>
              <td>CLIENTE</td>
              <td>CANTIDAD DE TAREAS</td>
              <td>COSTO TOTAL</td>
            </tr>
    
             
            <% for(Proyecto py:(List<Proyecto>)request.getAttribute("resultado")){ %>
                
                <tr>
                    <td>  <%= py.getNombre() %> </td>
                    <td>  <%= py.getDuracion()%> </td>
                    <td>  <%= py.getCliente() %> </td>
                    <td>  <% out.print((py.getTareas()!=null)? py.getTareas().size() : "0"); %> </td>
                    <td>  <% out.print((py.getCostoTotal()!=0)? py.getCostoTotal(): "0"); %> </td>
                </tr>
                
             <% } %>
            
             
  
    </table>
             <a href="rProyecto.jsp">Volver</a>
    </body>
</html>
