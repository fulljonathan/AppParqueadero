<%-- 
    Document   : ingreso
    Created on : 16/11/2016, 06:52:51 PM
    Author     : sala304
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Ingreso</title>
    </head>
    <body>
        <h1>Ingreso Información</h1>
        <br>
        <form name="frmIngreso" action="./NOMBRESERVLET" method="POST">
            <table border="1">
                <tr>
                    <td>Placa:</td>
                    <td>
                        <input type="text" placeholder="Ingrese Placa"
                               name="txtplaca" required>
                    </td>
                </tr>
                <tr>
                    <td>Nombres:</td>
                    <td>
                        <input type="text" placeholder="Ingrese Nombres"
                               name="txtnombres" required>
                    </td>
                </tr>                
                <tr>
                    <td>Cedula:</td>
                    <td>
                        <input type="text" placeholder="Ingrese Cedula"
                               name="txtcedula" required>
                    </td>
                </tr>
                <tr>
                    <td>Contacto:</td>
                    <td>
                        <input type="text" placeholder="Ingrese Contacto"
                               name="txtcontacto" required>
                    </td>
                </tr>  
                <tr>
                    <td>Brillada</td>
                    <td>
                        SI<input type="radio" name="rdBrillada" value="SI">
                        NO<input type="radio" name="rdBrillada" value="NO" checked>
                    </td>
                </tr>
                <tr>
                    <td>Lavada</td>
                    <td>
                        SI<input type="radio" name="rdLavada" value="SI">
                        NO<input type="radio" name="rdLavada" value="NO" checked>
                    </td>
                </tr> 
                <tr>
                    <td>Polichada</td>
                    <td>
                        SI<input type="radio" name="rdPolichada" value="SI">
                        NO<input type="radio" name="rdPolichada" value="NO" checked>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnAccion" value="Guardar"></td>
                    <td><input type="submit" name="btnAccion" value="Eliminar"></td>
                </tr>  
                <tr>
                    <td><input type="submit" name="btnAccion" value="Consultar"></td>
                    <td><input type="submit" name="btnAccion" value="Actualizar"></td>
                </tr>
                <tr>
                    <td><input type="reset" name="btnLimpiar" value="Limpiar"></td>
                </tr>                
            </table>
        </form>
    </body>
</html>
