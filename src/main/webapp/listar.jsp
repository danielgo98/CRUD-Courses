<%@page contentType="UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${titulo}</title>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
<h1>${titulo}</h1>
<a class="btn btn-primary my-2" href="${pageContext.request.contextPath}/cursos/form">Crear [+]</a>
<form action="${pageContext.request.contextPath}/cursos/buscar" method="post">
    <div class="row mb-4">
        <div class="col-sm-4">
            <input class="form-control" type="search" name="nombre" id="nombre">
        </div>
        <div class="col-sm-2">
            <input class="btn btn-primary" type="submit" value="Buscar">
        </div>
    </div>
</form>
<table class="table table-hover table-striped">
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
            <td><a class="btn btn-success" href="${pageContext.request.contextPath}/cursos/form?id=${curso.id}">editar</a></td>
            <td><a class="btn btn-danger" onclick="return confirm('¿Estás seguro que desea eliminar?');"
            href="${pageContext.request.contextPath}/cursos/eliminar?id=${curso.id}">eliminar</a></td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>