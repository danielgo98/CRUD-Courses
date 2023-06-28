<%@page contentType="UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${titulo}</title>
</head>
<body>
<h1>${titulo}</h1>
<p><a href="${pageContext.request.contextPath}/cursos/form">Crear [+]</a></p>
<form action="${pageContext.request.contextPath}/cursos/buscar" method="post">
    <input type="search" name="nombre" id="nombre">
    <input type="submit" value="Buscar">
</form>
<table>
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Instructor</th>
        <th>Duracion</th>
        <th>Editar</th>
        <th>Eliminar</th>
    </tr>
    <c:forEach items="${cursos}" var="curso">
        <tr>
            <td>${curso.id}</td>
            <td>${curso.nombre}</td>
            <td>${curso.instructor}</td>
            <td>${curso.duracion}</td>
            <td><a href="${pageContext.request.contextPath}/cursos/form?id=${curso.id}">editar</a></td>
            <td><a onclick="return confirm('¿Estás seguro que desea eliminar?');"
            href="${pageContext.request.contextPath}/cursos/eliminar?id=${curso.id}">eliminar</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>