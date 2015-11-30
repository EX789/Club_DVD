<%-- 
    Document   : agregarPelicula
    Created on : 16-nov-2015, 23:17:10
    Author     : raide
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${lista == null}">
            <c:redirect url="/Genero"/>
        </c:if>
        <c:if test="${not empty sessionScope.msn}">
            <c:set var="mensaje" value="${msn}"/>
            <script>
                alert('${mensaje}');
            </script>
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
                                <c:forEach var="listaGenero" items="${lista}">
                                    <option value="${listaGenero.id}">${listaGenero.nombre}</option>
                                </c:forEach>
                            </select></td>

                    </tr>
                    <tr>
                        <td>Año</td>
                        <td><select name="cbAno">
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
