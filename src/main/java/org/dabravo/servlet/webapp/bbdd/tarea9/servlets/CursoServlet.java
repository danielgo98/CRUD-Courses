package org.dabravo.servlet.webapp.bbdd.tarea9.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dabravo.servlet.webapp.bbdd.tarea9.models.Curso;
import org.dabravo.servlet.webapp.bbdd.tarea9.service.CursoService;
import org.dabravo.servlet.webapp.bbdd.tarea9.service.CursoServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet({"/index.html", "/cursos"})
public class CursoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CursoService service = new CursoServiceImpl(conn);

        List<Curso> cursos = service.listar();
        req.setAttribute("titulo", "Lista de Cursos");
        req.setAttribute("cursos", cursos);
        getServletContext().getRequestDispatcher("/listar.jsp").forward(req, resp);
    }
}
