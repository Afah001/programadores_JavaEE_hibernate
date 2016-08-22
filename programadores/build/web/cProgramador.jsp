<%-- 
    Document   : cProgramador
    Created on : 16/08/2016, 07:32:42 AM
    Author     : FRAGATA
--%>

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
        <h1>Lista de programadores</h1>
        
        <table width="200" border="1">

            <tr>
              <td>NOMBRE</td>
              <td>APELLIDO</td>
              <td>DIRECCION</td>
              <td>TELEFONO</td>
              <td>SALARIO BASE</td>
              <td>CANTIDAD DE TAREAS</td>
            </tr>
    
             
            <% for(Programador p:(List<Programador>)request.getAttribute("resultado")){ %>
                
                <tr>
                    <td>  <%= p.getNombre() %> </td>
                    <td>  <%= p.getApellido() %> </td>
                    <td>  <%= p.getDireccion() %> </td>
                    <td>  <%= p.getTelefono() %> </td>
                    <td>  <%= p.getSalarioBase() %> </td>
                    <!--condicion de una linea en java OPERADOR TERNARIO-->
                    <td>  <% out.print((p.getTareas()!=null)? p.getTareas().size():"0"); %> </td>
                </tr>
                
             <% } %>
            
              <a href="rProgramador.jsp">Volver</a>
  
    </table>

        
    </body>
</html>
