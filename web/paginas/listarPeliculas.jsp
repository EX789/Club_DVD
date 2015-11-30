<%-- 
    Document   : listarPeliculas
    Created on : 21-11-2015, 19:34:54
    Author     : Ivan
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
        <c:if test="${empty lista}">
            <c:redirect url="/Genero"/>
        </c:if>
        <c:if test="${not empty sessionScope.msn}">
            <script>alert('${msn}')</script>
        </c:if>
        <h1>Listado de peliculas</h1>
        <form action="ListarPeliculas" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Seleccionar un genero</td>
                        <td><select name="cbSeleccionarGenero">
                                <option>(todos)</option>
                                <c:forEach var="listaGeneros" items="${lista}">
                                    <option value="${listaGeneros.id}">${listaGeneros.nombre}</option>
                                </c:forEach>
                            </select></td>
                        <td><input type="submit" value="LISTAR" name="btnListar" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <form action="EliminarPeliculas" method="POST">
            <c:if test="${not empty sessionScope.listaPeliculas}">
                <table border="1" >
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Genero</th>
                            <th>Año</th>
                            <th>Fecha Registro</th>
                            <th>Accion</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pelicula" items="${listaPeliculas}">
                            <tr>
                                <td><input type="text" name="txtNombre" value="${pelicula.nombre}" readonly="readonly" /></td>
                                <td><input type="text" name="txtID" value="${pelicula.id_genero}" readonly="readonly" /></td>
                                <td><input type="text" name="txtAno" value="${pelicula.año}" readonly="readonly" /></td>
                                <td><input type="text" name="txtFechaRegistro" value="${pelicula.fechaRegistro}" readonly="readonly" /></td>
                                <td><input type="submit" value="ELIMINAR" name="btnEliminar" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </form>
    </body>
</html>
