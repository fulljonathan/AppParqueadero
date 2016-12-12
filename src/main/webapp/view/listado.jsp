<%-- 
    Document   : listado
    Created on : 16/11/2016, 07:19:17 PM
    Author     : sala304
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Listado</title>
    </head>
    <body>
        <h1>Listado de Vehículos</h1>
        <br>
        <table border="1">
            <thead>
                <tr>
                    <td>Placa</td>
                    <td>Nombres</td>
                    <td>Cedula</td>
                    <td>Contacto</td>
                    <td>Brillada</td>
                    <td>Lavada</td>
                    <td>Polichada</td>
                </tr>                
            </thead>
            <tbody>
                
            </tbody>
        </table>
        <br>        
        <a href="${pageContext.servletContext.contextPath}/view/ingreso.jsp">Regresar</a>
        
    </body>
</html>
