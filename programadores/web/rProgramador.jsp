<%-- 
    Document   : rProgramador
    Created on : 16/08/2016, 07:32:25 AM
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
        <h1>Progamador</h1>
        
         <form action="servlet_Programador?action=registrar"registrar method="post">
             
            Nombre<input name="nombre" ><br><br>
            Apellido<input name="apellido"><br><br>
            Direccion<input name="direccion"> <br><br>
            Telefono<input name="telefono"  ><br><br>
            
            Salario Base<select name="salarioBase">
                            <option value="600000">$600000</option>
                            <option value="1200000">$1200000</option>
                            <option value="2500000">$2500000</option>
                
                        </select><br><br><br>
          
            
            <input type="submit" value="Registrar"><br>
            <a href="servlet_Programador?action=consultar">Lista de programadores</a><br>
            <a href="index.jsp">Volver</a>
            
        </form>
        
    </body>
</html>
