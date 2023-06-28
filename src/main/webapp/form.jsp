<%@page contentType="UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/styles.css"/>
    <title>${titulo}</title>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>
<h1>${titulo}</h1>
    <form action="${pageContext.request.contextPath}/cursos/form" method="post">
        <div class="row mb-2">
            <label class="col-form-label col-sm-2" for="nombre">Nombre</label>
            <div class="col-sm-4">
                <input class="form-control" type="text" name="nombre" id="nombre" value="${curso.nombre}">
            </div>
            <c:if test="${errores != null && !empty errores.nombre}">
                <div style="color: red;">${errores.nombre}</div>
            </c:if>
        </div>
        <div class="row mb-2">
            <label class="col-form-label col-sm-2" for="instructor">Instructor</label>
            <div class="col-sm-4">
                <input class="form-control" type="text" name="instructor" id="instructor" value="${curso.instructor}">
            </div>
            <c:if test="${errores != null && !empty errores.instructor}">
                <div style="color: red;">${errores.instructor}</div>
            </c:if>
        </div>
        <div class="row mb-2">
            <label class="col-form-label col-sm-2" for="duracion">Duracion</label>
            <div class="col-sm-4">
                <input class="form-control" type="number" name="duracion" id="duracion" value="${curso.duracion}">
            </div>
            <c:if test="${errores != null && !empty errores.duracion}">
                <div style="color: red;">${errores.duracion}</div>
            </c:if>
        </div>
        <div class="row mb-2">
            <label class="col-form-label col-sm-2" for="descripcion">Descripcion</label>
            <div class="col-sm-4">
                <textarea class="form-control" name="descripcion" id="descripcion">${curso.descripcion}</textarea>
            </div>
            <c:if test="${errores != null && !empty errores.descripcion}">
                <div style="color: red;">${errores.descripcion}</div>
            </c:if>
        </div>
        <div class="row mb-6">
            <div>
                <input class="btn btn-primary" type="submit" value="${curso.id != null && curso.id > 0 ? "Editar" : "Crear"}">
            </div>
        </div>
        <input type="hidden" name="id" value="${curso.id}">

    </form>
</body>
</html>