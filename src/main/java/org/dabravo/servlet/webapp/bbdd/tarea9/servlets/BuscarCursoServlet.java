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

@WebServlet("/cursos/buscar")
public class BuscarCursoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CursoService service = new CursoServiceImpl(conn);
        String nombre = req.getParameter("nombre");

        List<Curso> nombres = service.porNombre(nombre);
        req.setAttribute("titulo", "Tarea 9: filtrando cursos");
        req.setAttribute("cursos", nombres);
        getServletContext().getRequestDispatcher("/listar.jsp").forward(req, resp);

    }
}
