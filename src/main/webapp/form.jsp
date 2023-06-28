<%@page contentType="UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/styles.css"/>
    <title>${titulo}</title>
</head>
<body>
<h1>${titulo}</h1>
    <form action="${pageContext.request.contextPath}/cursos/form" method="post">
        <div>
            <label for="nombre">Nombre</label>
            <div>
                <input type="text" name="nombre" id="nombre" value="${curso.nombre}">
            </div>
            <c:if test="${errores != null && !empty errores.nombre}">
                <div style="color: red;">${errores.nombre}</div>
            </c:if>
        </div>
        <div>
            <label for="instructor">Instructor</label>
            <div>
                <input type="text" name="instructor" id="instructor" value="${curso.instructor}">
            </div>
            <c:if test="${errores != null && !empty errores.instructor}">
                <div style="color: red;">${errores.instructor}</div>
            </c:if>
        </div>
        <div>
            <label for="duracion">Duracion</label>
            <div>
                <input type="number" name="duracion" id="duracion" value="${curso.duracion}">
            </div>
            <c:if test="${errores != null && !empty errores.duracion}">
                <div style="color: red;">${errores.duracion}</div>
            </c:if>
        </div>
        <div>
            <label for="descripcion">Descripcion</label>
            <div>
                <textarea name="descripcion" id="descripcion">${curso.descripcion}</textarea>
            </div>
            <c:if test="${errores != null && !empty errores.descripcion}">
                <div style="color: red;">${errores.descripcion}</div>
            </c:if>
        </div>
        <div>
            <input type="submit" value="${curso.id != null && curso.id > 0 ? "Editar" : "Crear"}">
        </div>
        <input type="hidden" name="id" value="${curso.id}">

    </form>
</body>
</html>