<%-- 
    Document   : AgregarPelicula
    Created on : 14-11-2015, 21:21:06
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:if test="${lista == null}">
        <c:redirect url="/CargarGeneros"/>
    </c:if>
    <form action="AgregarPelicula" method="POST">
        <table border="1">
            <tbody>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="txtNombre" value="" /></td>
                </tr>
                <tr>
                    <td>Genero</td>
                    <td><select name="cbSeleccionarGenero">
                            <c:forEach var="listaGenero" items="${requestScope.lista}">
                                <option>${listaGenero}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td>Año</td>
                    <td><select name="cbAño">
                            <option>2010</option>
                            <option>2011</option>
                            <option>2012</option>
                            <option>2013</option>
                            <option>2014</option>
                            <option>2015</option>  
                        </select></td>
                </tr>
            </tbody>
        </table>
        <input type="submit" value="REGISTRAR" name="btnRegistrar"/>
    </form>
</body>
</html>
