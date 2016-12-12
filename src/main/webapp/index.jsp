<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <br>
        <form name="frmLogin" action="./LoginServlet" method="POST">
        <table border="1">
            <tr>
                <td>Usuario</td>
                <td><input type="text" name="txtUsuario" 
                           placeholder="Ingrese Usuario"
                           required>
                </td>
            </tr>
            <tr>
                <td>Clave</td> 
                <td><input type="text" name="txtClave" 
                           placeholder="Ingrese Clave"
                           required>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Ingresar" name="btnIngresar"></td>
                <td><input type="reset" value="Cancelar" name="btnCancelar"></td>
            </tr>
        </table>
        </form>
    </body>
</html>
